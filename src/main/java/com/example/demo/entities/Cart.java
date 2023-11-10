package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "package_price")
    private BigDecimal package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    // Key/Foreign Key references "customer_id" of customers
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    //, mappedBy = "cart"?
    @OneToMany (
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cart")
    private Set<CartItem> cartitem;

    public void add(CartItem item){
        if (item!=null){
            if (cartitem==null){
                cartitem = new HashSet<>();
            }
            cartitem.add(item);
            item.setCart(this);
        }
    }
}
