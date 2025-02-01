package com.app.myapp.service.car_service.service;

import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {
    CarResponseDto saveCar(CarCreateDto createdCarDto);

    List<CarResponseDto> addManyCars(List<CarCreateDto> createdCarDtos);

    CarResponseDto getCarById(long id);

    List<CarResponseDto> getAllCars();

    Page<CarResponseDto> getAllCarsFromTheGivenRange(SearchRangeDto searchRangeDto, int page, int size, String sortBy, String order);

    CarResponseDto updateCar(long id, CarUpdateDto updateCar);

    CarResponseDto deleteCar(long id);
}
