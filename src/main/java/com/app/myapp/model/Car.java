package com.app.myapp.model;

import com.app.myapp.model.payloads.Severity;
import com.app.myapp.model.validation.ValidDateOfAddingTheAdd;
import com.app.myapp.model.validation.ValidEnumMembersOfCarClass;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.Year;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "{price.min}", payload = Severity.Error.class)
    @Max(value = 99999999, message = "{price.max}", payload = Severity.Error.class)
    private int price;

    @Min(value = 0, message = "{mileage.min}", payload = Severity.Error.class)
    @Max(value = 15000000, message = "{mileage.max}", payload = Severity.Error.class)
    private int mileage;

    @Min(value = 1, message = "{displacement.min}", payload = Severity.Error.class)
    @Max(value = 10000, message = "{displacement.max}", payload = Severity.Error.class)
    private int displacement;

    @Min(value = 1, message = "{power.min}", payload = Severity.Error.class)
    @Max(value = 5000, message = "{power.max}", payload = Severity.Error.class)
    private int power;

    @Size(min = 0, max = 5000, message = "Description can have at most {description.max}")
    private String description = "";

    @ValidDateOfAddingTheAdd
    private LocalDateTime dateOfAddingTheAdd;

    @Min(1850)
    @Max(9999)
    private Year yearOfProduction;

    @Min(1)
    @Max(12)
    private int doorNumber;

    @Min(1)
    @Max(100)
    private int amountOfSeats;

    @Pattern(regexp = "\b[(A-H|J-N|P|R-Z|0-9)]{17}\b")
    private String vin;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMembersOfCarClass(enumClass = ColorPalette.class)
    private ColorPalette color;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMembersOfCarClass(enumClass = State.class)
    private State state;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMembersOfCarClass(enumClass = Brand.class)
    private Brand brand;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMembersOfCarClass(enumClass = Petrol.class)
    private Petrol petrol;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMembersOfCarClass(enumClass = Gearbox.class)
    private Gearbox gearbox;

    @Enumerated(value = EnumType.STRING)
    @NotNull
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