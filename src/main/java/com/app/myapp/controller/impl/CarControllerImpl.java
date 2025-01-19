package com.app.myapp.controller.impl;

import com.app.myapp.controller.CarController;
import com.app.myapp.dto.CarDto;
import com.app.myapp.dto.SearchRangeDto;
import com.app.myapp.service.car_service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarControllerImpl implements CarController {

    private final CarService carService;

    @Autowired
    public CarControllerImpl(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/addCar")
    public CarDto addCar(@Valid @RequestBody CarDto carDto) {
        return carService.addCar(carDto);
    }

    @PostMapping("/addManyCars")
    public List<CarDto> addManyCars(@RequestBody List<@Valid CarDto> carDtoList) {
        return carService.addManyCars(carDtoList);
    }


    @GetMapping("/allCars")
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/filteredCars")
    public Page<CarDto> getAllCarsFromTheGivenRange(@Valid @RequestBody(required = false) SearchRangeDto searchRangeDto,
                                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "35", required = false) int size,
                                                    @RequestParam(value = "sortBy", defaultValue = "price", required = false) String sortBy,
                                                    @RequestParam(value = "order", defaultValue = "asc", required = false) String order) {
        return carService.getAllCarsFromTheGivenRange(searchRangeDto, page, size, sortBy, order);
    }

    @PutMapping("/{id}")
    public CarDto updateCar(@PathVariable long id, @Valid @RequestBody CarDto carDto) {
        return carService.updateCar(id, carDto);
    }

    @DeleteMapping("/{id}")
    public CarDto deleteCar(@PathVariable long id) {
        return carService.deleteCar(id);
    }

    //each time MethodArgumentNotValidException thrown, this exception will be handled inside this method
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        var errors = new HashMap<String, String>(); //name and message

        e.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();


                    errors.put(fieldName, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}