package com.app.myapp.service.car_service;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {

    //CREATE
    CarDto saveCar(CarDto carDto);

    List<CarDto> addManyCars(List<CarDto> carDtoList);

    //READ
    CarDto getCarById(long id);

    List<CarDto> getAllCars();

    // List<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int size);
    Page<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int size, String sortBy, String order);

    //UPDATE
    CarDto updateCar(long id, CarDto carDto);

    //DELETE
    CarDto deleteCar(long id);
}
