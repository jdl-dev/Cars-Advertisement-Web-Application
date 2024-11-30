package com.app.myapp.mapper;

import com.app.myapp.dto.CarDto;
import com.app.myapp.model.model.Car;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CarMapper {

    public static Car toEntity(@NotNull CarDto carDto) {
        Car car = new Car();

        car.setPrice(carDto.getPrice());
        car.setMileage(carDto.getMileage());
        car.setDisplacement(carDto.getDisplacement());
        car.setPower(carDto.getPower());
        car.setDescription(carDto.getDescription());
        car.setDateOfAddingTheAdd(LocalDateTime.now());
        car.setYearOfProduction(carDto.getYearOfProduction());
        car.setDoorNumber(carDto.getDoorNumber());
        car.setAmountOfSeats(carDto.getAmountOfSeats());
        car.setVin(carDto.getVin());
        car.setColor(carDto.getColor());
        car.setState(carDto.getState());
        car.setBrand(carDto.getBrand());
        car.setPetrol(carDto.getPetrol());
        car.setGearbox(carDto.getGearbox());
        car.setBodytype(carDto.getBodytype());

        return car;
    }

    public static CarDto toDto(@NotNull Car car) {
        CarDto carDto = new CarDto();

        carDto.setPrice(car.getPrice());
        carDto.setMileage(car.getMileage());
        carDto.setDisplacement(car.getDisplacement());
        carDto.setPower(car.getPower());
        carDto.setDescription(car.getDescription());
        carDto.setDateOfAddingTheAdd(car.getDateOfAddingTheAdd());
        carDto.setYearOfProduction(car.getYearOfProduction());
        carDto.setDoorNumber(car.getDoorNumber());
        carDto.setAmountOfSeats(car.getAmountOfSeats());
        carDto.setVin(car.getVin());
        carDto.setColor(car.getColor());
        carDto.setState(car.getState());
        carDto.setBrand(car.getBrand());
        carDto.setPetrol(car.getPetrol());
        carDto.setGearbox(car.getGearbox());
        carDto.setBodytype(car.getBodytype());

        return carDto;
    }
}
