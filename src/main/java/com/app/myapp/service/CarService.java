package com.app.myapp.service;

import com.app.myapp.model.dto.CarDto;
import com.app.myapp.model.model.Car;

import java.util.List;

public interface CarService {

    //CREATE
    Car saveCar(CarDto carDto);

    //READ
    List<Car> getAllCarsFromDB();

    List<Car> getAllCarsFromTheGivenRange(CarDto carDto);

    //UPDATE
    Car updateCar(int id, CarDto carDto);

    //DELETE
    Car deleteCar(int id);
}
