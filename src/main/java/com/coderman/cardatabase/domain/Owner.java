package com.coderman.cardatabase.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ownerid;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    @JsonIgnore
    private List<Car> cars;


//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "car_owner", joinColumns = {@JoinColumn(name = "ownerid")}, inverseJoinColumns = {@JoinColumn(name = "id")})
//    private Set<Car> cars = new HashSet<Car>(0);


    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

/*
    This class has a one to many relationship with the Car table!The owner can own multiple cars, but a car can have only one owner!


    One to Many relationsship can be added by using @ManyToOne and @oneToMany annotations.
     In  the car entity class, which contains a foreign key, you will define the relationship with the @manyToone.We should also add getters and setter for this field
     It is recommended that we use Fetch.LAZY for all associations. For toMany relationships, that is the default value, but
     the toOne relationships, we should define the it. FetchType defines the strategy for fetching data from the database
     the value can be either EAGER or LAZY.
        LAZY -> when the owner is fetched from the database, all the cars associated with the owner will be fetched when needed.
        EAGER -> the cars will eb fetched immediately with the owner.


     CascadeType.ALL ->this attribute setting means that if the owner is deleted, the cars linked to that owner are deleted as well.
     MappedBy -> this attribute tell us that the Car class has the owner field which is the foreign key for this relationship
 */