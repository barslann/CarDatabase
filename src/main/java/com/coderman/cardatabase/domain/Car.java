package com.coderman.cardatabase.domain;

import javax.persistence.*;

@Entity
public class Car {
    @Id // -> Primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //-> defines that id is automatically generated by the database
    // auto means jpa provides selects the best strategy for a particular database
    private Long id;

    private String brand;
    private String model;
    private String color;
    private String registerNumber;
    private int year;
    private int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private Owner owner;

//    @ManyToMany(mappedBy = "cars")
//    private Set<Owner> owners;


    public Car() {
    }

    public Car(String brand, String model, String color, String registerNumber, int year, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.year = year;
        this.price = price;
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

/*
    Database columns are named according to class filed naming by default.
    If we want to use other naming convention, we can use the @column annotation.
    With @Column annotation, we can also define the column's length, and whether the column is nullable.

 */