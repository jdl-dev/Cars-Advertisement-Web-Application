package com.app.myapp.mapper;

import com.app.myapp.dto.CarDto;
import com.app.myapp.model.model.Car;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarMapper {

    public Car toEntity(@NotNull CarDto carDto) {
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
        car.setUser(carDto.getUser());

        return car;
    }

    public CarDto toDto(@NotNull Car car) {
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
        carDto.setUser(car.getUser());

        return carDto;
    }
}
