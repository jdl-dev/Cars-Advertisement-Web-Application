package com.app.myapp.controller;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarController {
    CarDto addCar(CarDto carDto);

    List<CarDto> addManyCars(List<CarDto> carDtoList);

    List<CarDto> getAllCars();

    Page<CarDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int pageSize, String sortBy, String order);

    CarDto updateCar(long id, CarDto carDto);

    CarDto deleteCar(long id);
}
