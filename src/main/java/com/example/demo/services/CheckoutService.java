package com.example.demo.services;

import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;

public interface CheckoutService {

    //define a method to checkout
    //pass in a "purchase" and return a "purchase response"
    PurchaseResponse placeOrder(Purchase purchase);
}
