package com.app.myapp.mapper;

import com.app.myapp.dto.car_dtos.CarCreateDto;
import com.app.myapp.dto.car_dtos.CarResponseDto;
import com.app.myapp.dto.car_dtos.CarUpdateDto;
import com.app.myapp.model.model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {

    public Car carCreateDtoEntity(CarCreateDto carCreateDto) {
        return Car.builder()
                .price(carCreateDto.getPrice())
                .mileage(carCreateDto.getMileage())
                .displacement(carCreateDto.getDisplacement())
                .power(carCreateDto.getPower())
                .description(carCreateDto.getDescription())
                .dateOfAddingTheAdd(carCreateDto.getDateOfAddingTheAdd())
                .yearOfProduction(carCreateDto.getYearOfProduction())
                .doorNumber(carCreateDto.getDoorNumber())
                .amountOfSeats(carCreateDto.getAmountOfSeats())
                .vin(carCreateDto.getVin())
                .color(carCreateDto.getColor())
                .state(carCreateDto.getState())
                .brand(carCreateDto.getBrand())
                .petrol(carCreateDto.getPetrol())
                .gearbox(carCreateDto.getGearbox())
                .bodytype(carCreateDto.getBodytype())
                .user(carCreateDto.getUser())
                .build();
    }

    public Car carUpdateDtoEntity(CarUpdateDto carUpdateDto) {
        return Car.builder()
                .price(carUpdateDto.getPrice())
                .mileage(carUpdateDto.getMileage())
                .displacement(carUpdateDto.getDisplacement())
                .power(carUpdateDto.getPower())
                .description(carUpdateDto.getDescription())
                .dateOfAddingTheAdd(carUpdateDto.getDateOfAddingTheAdd())
                .dateOfUpdatingTheAdd(carUpdateDto.getDateOfUpdatingTheAdd())
                .yearOfProduction(carUpdateDto.getYearOfProduction())
                .doorNumber(carUpdateDto.getDoorNumber())
                .amountOfSeats(carUpdateDto.getAmountOfSeats())
                .vin(carUpdateDto.getVin())
                .color(carUpdateDto.getColor())
                .state(carUpdateDto.getState())
                .brand(carUpdateDto.getBrand())
                .petrol(carUpdateDto.getPetrol())
                .gearbox(carUpdateDto.getGearbox())
                .bodytype(carUpdateDto.getBodytype())
                .user(carUpdateDto.getUser())
                .build();
    }

    public CarResponseDto carEntityToResponseDto(Car car) {
        return CarResponseDto
                .builder()
                .id(car.getId())
                .price(car.getPrice())
                .mileage(car.getMileage())
                .displacement(car.getDisplacement())
                .power(car.getPower())
                .description(car.getDescription())
                .dateOfAddingTheAdd(car.getDateOfAddingTheAdd())
                .dateOfUpdatingTheAdd(car.getDateOfUpdatingTheAdd())
                .yearOfProduction(car.getYearOfProduction())
                .doorNumber(car.getDoorNumber())
                .amountOfSeats(car.getAmountOfSeats())
                .vin(car.getVin())
                .color(car.getColor())
                .state(car.getState())
                .brand(car.getBrand())
                .petrol(car.getPetrol())
                .gearbox(car.getGearbox())
                .bodytype(car.getBodytype())
                .user(car.getUser())
                .build();
    }
}