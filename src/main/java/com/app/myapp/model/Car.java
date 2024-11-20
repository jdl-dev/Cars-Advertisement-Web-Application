package com.app.myapp.model;

import com.app.myapp.model.validation.annotations.ValidAmountOfSeats;
import com.app.myapp.model.validation.annotations.ValidDateOfAddingTheAdd;
import com.app.myapp.model.validation.annotations.ValidDescription;
import com.app.myapp.model.validation.annotations.ValidDisplacement;
import com.app.myapp.model.validation.annotations.ValidDoorNumbers;
import com.app.myapp.model.validation.annotations.ValidEnumMembersOfCarClass;
import com.app.myapp.model.validation.annotations.ValidMileage;
import com.app.myapp.model.validation.annotations.ValidPower;
import com.app.myapp.model.validation.annotations.ValidPrice;
import com.app.myapp.model.validation.annotations.ValidVin;
import com.app.myapp.model.validation.annotations.ValidYearOfProduction;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ValidPrice(min = 1, max = 100000000)
    private int price;

    @ValidMileage(min = 0, max = 30000000)
    private int mileage;

    @ValidDisplacement(min = 1, max = 10000)
    private int displacement;

    @ValidPower(min = 1, max = 5000)
    private int power;

    @ValidDescription(defaultDescription = "", maxDescriptionLength = 2500)
    private String description;

    @ValidDateOfAddingTheAdd
    private LocalDateTime dateOfAddingTheAdd;

    @ValidYearOfProduction(min = 1850, max = 9999)
    private Year yearOfProduction;

    @ValidDoorNumbers(min = 1, max = 12)
    private int doorNumber;

    @ValidAmountOfSeats(min = 2, max = 100)
    private int amountOfSeats;

    @ValidVin(regex = "\b[(A-H|J-N|P|R-Z|0-9)]{17}\b")
    private String vin;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = ColorPalette.class)
    private ColorPalette color;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = State.class)
    private State state;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Brand.class)
    private Brand brand;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Petrol.class)
    private Petrol petrol;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Gearbox.class)
    private Gearbox gearbox;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Bodytype.class)
    private Bodytype bodytype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfAddingTheAdd() {
        return dateOfAddingTheAdd;
    }

    public void setDateOfAddingTheAdd(LocalDateTime dateOfAddingTheAdd) {
        this.dateOfAddingTheAdd = dateOfAddingTheAdd;
    }

    public Year getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Year yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(int doorNumber) {
        this.doorNumber = doorNumber;
    }

    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public ColorPalette getColor() {
        return color;
    }

    public void setColor(ColorPalette color) {
        this.color = color;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Petrol getPetrol() {
        return petrol;
    }

    public void setPetrol(Petrol petrol) {
        this.petrol = petrol;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Bodytype getBodytype() {
        return bodytype;
    }

    public void setBodytype(Bodytype bodytype) {
        this.bodytype = bodytype;
    }
}