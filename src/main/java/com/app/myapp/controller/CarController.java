package com.app.myapp.controller;

import com.app.myapp.model.Car;
import com.app.myapp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public Car save(@Valid @RequestBody Car car) {
        return carService.save(car);
    }

    @PostMapping("/addManyCars")
    public List<Car> saveManyCars(@RequestBody List<Car> cars) {
        return carService.saveAll(cars);
    }
}