package com.app.myapp.model.model.setup;

import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.Car;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;
import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BaseConstraintViolationTestSetup {
    protected Validator validator;
    protected Car car;

    @BeforeEach
    void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        assertNotNull(validator);
    }

    @BeforeEach
    void setUpValidCar1() {
        car = new Car();
        car.setId(1L);
        car.setPrice(15000);
        car.setMileage(50000);
        car.setBrand(Brand.TOYOTA);
        car.setPetrol(Petrol.PETROL);
        car.setGearbox(Gearbox.AUTOMATIC);
        car.setBodytype(Bodytype.SUV);
        car.setDisplacement(2000);
        car.setPower(150);
        car.setDescription("A well-maintained SUV with low mileage.");
        car.setDateOfAddingTheAdd(LocalDateTime.now());
        car.setYearOfProduction(Year.of(2020));
        car.setDoorNumber(5);
        car.setAmountOfSeats(5);
        car.setColor(ColorPalette.BLACK);
        car.setVin("1HGCM82633A123456");
        car.setState(State.USED);
    }
}