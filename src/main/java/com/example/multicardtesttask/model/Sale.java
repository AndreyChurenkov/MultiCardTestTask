package com.example.multicardtesttask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


}
