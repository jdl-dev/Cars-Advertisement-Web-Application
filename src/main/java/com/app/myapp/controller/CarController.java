package com.app.myapp.controller;

import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.model.model.Car;
import com.app.myapp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/addCar")
    public Car addCar(@Valid @RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @PostMapping("/addManyCars")
    public List<Car> addManyCars(@RequestBody List<@Valid CarDto> carDtoList) {
        return carService.addManyCars(carDtoList);
    }

    @GetMapping("/allCars")
    public List<Car> getAllCars(Model model) {
        return carService.getAllCarsFromDB();
    }

    @GetMapping("/filteredCars")
    public List<CarDto> getAllCarsFromTheGivenRange(@Valid @RequestBody SearchRangeDto searchRangeDto) {
        return carService.getAllCarsFromTheGivenRange(searchRangeDto);
    }
    /*
        @GetMapping("/filteredCars")
    public List<CarDto> getAllCarsWithGivenRange(SearchRangeDto searchRangeDto, Model model, BindingResultUtils bindingResultUtils) {

    }
     */
}