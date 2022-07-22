package com.example.multicardtesttask.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

    public static final String DATE_TIME_PATTERN = "dd.MM.yyyy";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "lastname", nullable = false)
    @NotNull
    private String lastname;

    @Column(name = "age", nullable = false)
    @NotNull
    @Min(1)
    private int age;

    @Column(name = "purchase_item", nullable = false)
    @NotNull
    private String purchase_item;

    @Column(name = "count", nullable = false)
    @NotNull
    @Min(1)
    private int count;

    @Column(name = "amount", nullable = false)
    @NotNull
    @Size(min = 0, max = 9999999)
    private Double amount;

    @Column(name = "purchase_date", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime purchase_date;

    public Sale() {
    }

    public Sale(String name, String lastname, int age, String purchase_item, int count, Double amount, LocalDateTime purchase_date) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.purchase_item = purchase_item;
        this.count = count;
        this.amount = amount;
        this.purchase_date = purchase_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPurchase_item() {
        return purchase_item;
    }

    public void setPurchase_item(String purchase_item) {
        this.purchase_item = purchase_item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDateTime purchase_date) {
        this.purchase_date = purchase_date;
    }
}
