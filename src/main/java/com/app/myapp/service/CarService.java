package com.app.myapp.service;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.model.model.Car;

import java.util.List;

public interface CarService {

    //CREATE
    Car addCar(CarDto carDto);

    List<Car> addManyCars(List<CarDto> carDtoList);

    //READ
    List<Car> getAllCarsFromDB();


    List<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto);

    /*
    //UPDATE
    Car updateCar(int id, CarDto carDto);

    //DELETE
    Car deleteCar(int id);
     */
}
