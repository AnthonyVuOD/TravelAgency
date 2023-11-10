package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    //Key/Foreign Key references "vacation_id" of vacations/ Should be differnt?
    // OnetoOne and Column?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

//    @ManyToMany (
//            //cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER, mappedBy = "cartitem")

    @ManyToMany
            //(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable (name = "excursion_cartitem",
                joinColumns = @JoinColumn (name = "cart_item_id"),
                inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;

    //Key/ Foreign Key references "cart_id" of carts
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;
}
