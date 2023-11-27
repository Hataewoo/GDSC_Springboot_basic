package com.example.practice1_mysql;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.metamodel.mapping.NonAggregatedIdentifierMapping;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PAYDATE")
    private String payDate;

    @Column(name = "PAYCOUNT")
    private int payCount;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;
    // Getter, Setter, Constructors 등 필요한 메서드 추가


}