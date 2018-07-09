package com.mysqlpostgres.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "GST_NUMBER")
    private String gstNumber;

    public Customer() {
    }
}
