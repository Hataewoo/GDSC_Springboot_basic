package com.example.practice1_mysql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "'ORDER'")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE")
    private String date;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "orderProduct",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private Payment payment;
    // Getter, Setter, Constructors 등 필요한 메서드 추가
}