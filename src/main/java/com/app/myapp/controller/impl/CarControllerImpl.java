package com.app.myapp.controller.impl;

import com.app.myapp.controller.CarController;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import com.app.myapp.service.car_service.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarControllerImpl implements CarController {

    private final CarService carService;

    @Autowired
    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @Override
    @PostMapping("/addCar")
    public CarResponseDto saveCar(@RequestBody CarCreateDto createdCarDto) {
        return carService
                .saveCar(createdCarDto);
    }

    @Override
    @PostMapping("/addManyCars")
    public List<CarResponseDto> addManyCars(@RequestBody List<CarCreateDto> createdCarDtos) {
        return carService
                .addManyCars(createdCarDtos);
    }

    @Override
    @GetMapping("/allCars")
    public List<CarResponseDto> getAllCars() {
        return carService
                .getAllCars();
    }

    @Override
    @PostMapping("/filteredCars")
    public Page<CarResponseDto> getAllCarsFromTheGivenRange(
            @RequestBody(required = false) SearchRangeDto searchRangeDto,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "35", required = false) int size,
            @RequestParam(value = "sortBy", defaultValue = "price", required = false) String sortBy,
            @RequestParam(value = "order", defaultValue = "asc", required = false) String order) {
        return carService
                .getAllCarsFromTheGivenRange(searchRangeDto, page, size, sortBy, order);
    }

    @Override
    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable long id, @RequestBody CarUpdateDto updatedCar) {
        return carService
                .updateCar(id, updatedCar);
    }

    @Override
    @DeleteMapping("/{id}")
    public CarResponseDto deleteCar(@PathVariable long id) {
        return carService
                .deleteCar(id);
    }
}