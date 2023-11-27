package com.example.practice1_mysql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "STOCK")
    private int stock;
    // Getter, Setter, Constructors 등 필요한 메서드 추가

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
}