package com.app.myapp.service;

import com.app.myapp.model.model.Car;
import com.app.myapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> saveAll(List<Car> cars) {
        return carRepository.saveAll(cars);
    }
}