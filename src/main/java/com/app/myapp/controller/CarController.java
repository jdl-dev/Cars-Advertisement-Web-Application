package com.app.myapp.controller;

import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarController {
    CarResponseDto saveCar(CarCreateDto createdCarDto);

    List<CarResponseDto> addManyCars(List<CarCreateDto> createdCarsDtos);

    List<CarResponseDto> getAllCars();

    Page<CarResponseDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int pageSize, String sortBy, String order);

    CarResponseDto updateCar(long id, CarUpdateDto updatedCar);

    CarResponseDto deleteCar(long id);
}