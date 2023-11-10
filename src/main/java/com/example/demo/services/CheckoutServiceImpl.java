package com.example.demo.services;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.ExcursionRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    //Service will implement a repo to save data
    private CustomerRepository customerRepository;
    private CartItemRepository cartItemRepository;

    // constructor to inject repo
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CartItemRepository cartItemRepository){

        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve cart info form DTO (Purchase);
        Cart cart = purchase.getCart();

        //Generate Tracking number and set to purchase response
        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        //populate cart with cart items
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            //cartItemRepository.save(cartItem);
        });

        //set cart status to ordered
        cart.setStatus(StatusType.ordered);

        //retrieve customer info form DTO (Purchase);
        Customer customer = purchase.getCustomer();

        //add cart to customer
        customer.add(cart);

        //save customer into repository
        customerRepository.save(customer);

        //return tracking number
        return new PurchaseResponse(orderTrackingNumber);
    }
    public String generateOrderTrackingNumber(){
        //generate random "UUID"
        //UUID version -4
        return UUID.randomUUID().toString();
    }
}
