package com.example.multicardtesttask.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    public static final String DATE_TIME_PATTERN = "dd.MM.yyyy";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "lastname")
    @NotNull
    private String lastname;

    @Column(name = "age")
    @NotNull
    @Min(1)
    private int age;

    @Column(name = "count")
    @NotNull
    @Min(1)
    private int count;

    @Column(name = "amount")
    @NotNull
    @Size(min = 0, max = 9999999)
    private Double amount;

    @Column(name = "purchase_date")
    @NotNull
    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private LocalDateTime purchaseDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sale")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Item> purchaseItem;

    public Sale() {
    }

    public Sale(Integer id, String name, String lastname, int age, int count, Double amount, LocalDateTime purchaseDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.count = count;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
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

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchase_date) {
        this.purchaseDate = purchase_date;
    }

    public List<Item> getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(List<Item> purchaseItem) {
        this.purchaseItem = purchaseItem;
    }
}
