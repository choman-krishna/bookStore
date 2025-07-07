package com.crishna.bookStore.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private float price;
    private float discount;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    @JsonBackReference
    private List<Purchase> purchases;


    public Book(@JsonProperty("name") String name,
                @JsonProperty("author") String author,
                @JsonProperty("price") float price)
    {
        this.name = name;
        this.author = author;
        this.price = price;
    }
}
