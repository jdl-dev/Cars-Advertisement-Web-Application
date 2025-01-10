package com.app.myapp.service;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;

import java.util.List;

public interface CarService {

    //CREATE
    CarDto addCar(CarDto carDto);

    List<CarDto> addManyCars(List<CarDto> carDtoList);

    //READ
    List<CarDto> getAllCars();

    List<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto);


    //UPDATE
    CarDto updateCar(long id, CarDto carDto);

    //DELETE
    CarDto deleteCar(long id);

}
