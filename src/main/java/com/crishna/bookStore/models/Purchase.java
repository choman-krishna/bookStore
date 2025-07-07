package com.crishna.bookStore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;
    private float selling_price;

    @JoinColumn(name = "order_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JsonBackReference
    private Orders order;

    @JoinColumn(name = "book_id")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Book book;

    public Purchase(int quantity, float selling_price, Orders order, Book book) {
        this.quantity = quantity;
        this.selling_price = selling_price;
        this.order = order;
        this.book = book;
    }
}
