package com.app.myapp.model;

import com.app.myapp.model.validation.annoations.ValidEnumMembersOfCarClass;
import com.app.myapp.model.validation.annoations.ValidMileage;
import com.app.myapp.model.validation.annoations.ValidPrice;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ValidPrice
    private int price;

    @ValidMileage
    private int mileage;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Brand.class)
    private Brand brand;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Petrol.class)
    private Petrol petrol;

    @Enumerated(value = EnumType.STRING)
    //@ValidEnumMembersOfCarClass(enumClass = Gearbos.class)
    private Gearbos gearbox;

    @Enumerated(value = EnumType.STRING)
    //@ValidEnumMembersOfCarClass(enumClass = Bodytype.class)
    private Bodytype bodytype;

    //@ValidDisplacement
    private int displacement;

    //@ValidPower
    private int power;

    //@ValidDescription
    private String description;

    // @ValidDateOfAddingTheAdd
    private LocalDateTime dateOfAddingTheAdd;

    //@ValidYearOfProduction
    private Year yearOfProduction;

    //@ValidDoorNumbers
    private int doorNumber;

    //@ValidAmountOfSeats
    private int amountOfSeats;

    @Enumerated(value = EnumType.STRING)
    //@ValidEnumMembersOfCarClass(enumClass = ColorPalette.class)
    private ColorPalette color;

    //@ValidVin
    private String vin;

    @Enumerated(value = EnumType.STRING)
    //@ValidEnumMembersOfCarClass(enumClass = Condition.class)
    private State state;

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

    public Gearbos getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbos gearbox) {
        this.gearbox = gearbox;
    }

    public Bodytype getBodytype() {
        return bodytype;
    }

    public void setBodytype(Bodytype bodytype) {
        this.bodytype = bodytype;
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

    public ColorPalette getColor() {
        return color;
    }

    public void setColor(ColorPalette color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}