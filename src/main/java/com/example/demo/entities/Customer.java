package com.example.demo.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotNull
    @Column(name = "customer_first_name")
    private String firstName;

    @NotNull
    @Column(name = "customer_last_name")
    private String lastName;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "postal_code")
    private String postal_code;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_Update")
    @UpdateTimestamp
    private Date last_update;

    // Key/Foreign Key references "division_id" from divisions
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "division_id")
    private Division division;

    //MappedBy customer?
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    public void add(Cart cart){
        if (cart !=null){
            if (carts==null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
