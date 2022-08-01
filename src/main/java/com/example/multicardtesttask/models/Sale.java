package com.example.multicardtesttask.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotBlank()
    @Length(min = 3, max = 30)
    private String name;

    @Column(name = "lastname")
    @NotBlank()
    @Length(min = 3, max = 30)
    private String lastname;

    @Column(name = "age")
    @Min(1)
    @Max(120)
    private int age;

    @Column(name = "count")
    @Min(1)
    private int count;

    @Column(name = "amount")
    @Max(9999999)
    private Double amount;

    @Column(name = "purchase_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sale")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Item> purchaseItem;

    public Sale() {
    }

    public Sale(Integer id, String name, String lastname, int age, int count, Double amount, LocalDate purchaseDate) {
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchase_date) {
        this.purchaseDate = purchase_date;
    }

    public List<Item> getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(List<Item> purchaseItem) {
        this.purchaseItem = purchaseItem;
    }


}
