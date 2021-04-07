package com.coderman.cardatabase.web;

import com.coderman.cardatabase.domain.Car;
import com.coderman.cardatabase.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // -> identifies that this class will be the controller of the RESTful web service.
public class CarController {

    @Autowired
    private CarRepository carRepository;

    // this method returns all the car objects, which are the marshalled to JSON objects by Jackson Library
//    @RequestMapping("/cars")
//    public Iterable<Car> getCars(){
//        return carRepository.findAll();
//    }
}
