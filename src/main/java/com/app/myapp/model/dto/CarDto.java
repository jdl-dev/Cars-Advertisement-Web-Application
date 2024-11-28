package com.app.myapp.model.dto;

import com.app.myapp.model.model.modelmembers.Bodytype;
import com.app.myapp.model.model.modelmembers.Brand;
import com.app.myapp.model.model.modelmembers.ColorPalette;
import com.app.myapp.model.model.modelmembers.Gearbox;
import com.app.myapp.model.model.modelmembers.Petrol;
import com.app.myapp.model.model.modelmembers.State;
import com.app.myapp.validation.payloads.Severity;
import com.app.myapp.validation.validation.descriptionvalidation.ValidDescriptionForbiddenWords;
import com.app.myapp.validation.validation.enumvalidation.ValidEnumMemberPattern;
import com.app.myapp.validation.validation.yearproductionvalidation.ValidYearOfProduction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.time.Year;

public class CarDto {
    private Long id;

    @Min(
            value = 1,
            message = "{price.min}",
            payload = Severity.Error.class)
    @Max(
            value = 99999999,
            message = "{price.max}",
            payload = Severity.Error.class)
    private int price;

    @Min(
            value = 0,
            message = "{mileage.min}",
            payload = Severity.Error.class)
    @Max(
            value = 15000000,
            message = "{mileage.max}",
            payload = Severity.Error.class)
    private int mileage;

    @Min(
            value = 1,
            message = "{displacement.min}",
            payload = Severity.Error.class)
    @Max(
            value = 10000,
            message = "{displacement.max}",
            payload = Severity.Error.class)
    private int displacement;

    @Min(
            value = 1,
            message = "{power.min}",
            payload = Severity.Error.class)
    @Max(
            value = 5000,
            message = "{power.max}",
            payload = Severity.Error.class)
    private int power;

    @Size(
            min = 0,
            max = 5000,
            message = "{description.max}",
            payload = Severity.Error.class)
    @ValidDescriptionForbiddenWords(
            forbiddenWords = "forbidden_words.txt",
            message = "{description.forbiddenWords}",
            payload = Severity.Error.class)
    private String description = "";

    private LocalDateTime dateOfAddingTheAdd;

    @NotNull
    @ValidYearOfProduction(minProductionYear = 1850, maxProductionYear = 9999)
    private Year yearOfProduction;

    @Min(
            value = 1,
            message = "{doorNumber.min}",
            payload = Severity.Error.class)
    @Max(
            value = 20,
            message = "{doorNumber.max}",
            payload = Severity.Error.class)
    private int doorNumber;

    @Min(
            value = 1,
            message = "{amountOfSeats.min}",
            payload = Severity.Error.class)
    @Max(
            value = 100,
            message = "{amountOfSeats.max}",
            payload = Severity.Error.class)
    private int amountOfSeats;

    @Pattern(
            regexp = "^[A-HJ-NPR-Z0-9]{17}$",
            message = "{vin.incorrect}",
            payload = Severity.Error.class)
    private String vin;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "WHITE|BLACK|GRAY|SILVER|BLUE|RED|BROWN|GREEN|ORANGE|BEIGE|PURPLE|GOLD|YELLOW",
            message = "{color.colorIsNotCorrect}",
            payload = Severity.Error.class)
    private ColorPalette color;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "NEW|USED",
            message = "{state.stateIsNotCorrect}",
            payload = Severity.Error.class)
    private State state;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "BMW|AUDI|VOLKSWAGEN|FORD|MERCEDES_BENZ|OPEL|TOYOTA|SKODA|RENAULT|PEUGEOT",
            message = "{brand.brandIsNotCorrect}",
            payload = Severity.Error.class)
    private Brand brand;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "PETROL|PETROL_AND_CNG|PETROL_AND_LPG|DIESEL|ELECTRIC|ETHANOL|HYBRID|HYBRID_PLUG_IN|HYDROGEN",
            message = "{petrol.petrolIsNotCorrect}",
            payload = Severity.Error.class)
    private Petrol petrol;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "AUTOMATIC|MANUAL",
            message = "{gearbox.gearboxIsNotCorrect}",
            payload = Severity.Error.class)
    private Gearbox gearbox;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    @ValidEnumMemberPattern(
            regexp = "SMALL_CARS|CITY_CAR|COUPE|CABRIOLET|STATION_WAGON|COMPACT|MINIVAN|SEDAN|SUV",
            message = "{bodytype.bodyTypeIsNotCorrect}",
            payload = Severity.Error.class)
    private Bodytype bodytype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Min(
            value = 1,
            message = "{price.min}",
            payload = Severity.Error.class)
    @Max(
            value = 99999999,
            message = "{price.max}",
            payload = Severity.Error.class)
    public int getPrice() {
        return price;
    }

    public void setPrice(@Min(
            value = 1,
            message = "{price.min}",
            payload = Severity.Error.class) @Max(
            value = 99999999,
            message = "{price.max}",
            payload = Severity.Error.class) int price) {
        this.price = price;
    }

    @Min(
            value = 0,
            message = "{mileage.min}",
            payload = Severity.Error.class)
    @Max(
            value = 15000000,
            message = "{mileage.max}",
            payload = Severity.Error.class)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(@Min(
            value = 0,
            message = "{mileage.min}",
            payload = Severity.Error.class) @Max(
            value = 15000000,
            message = "{mileage.max}",
            payload = Severity.Error.class) int mileage) {
        this.mileage = mileage;
    }

    @Min(
            value = 1,
            message = "{displacement.min}",
            payload = Severity.Error.class)
    @Max(
            value = 10000,
            message = "{displacement.max}",
            payload = Severity.Error.class)
    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(@Min(
            value = 1,
            message = "{displacement.min}",
            payload = Severity.Error.class) @Max(
            value = 10000,
            message = "{displacement.max}",
            payload = Severity.Error.class) int displacement) {
        this.displacement = displacement;
    }

    @Min(
            value = 1,
            message = "{power.min}",
            payload = Severity.Error.class)
    @Max(
            value = 5000,
            message = "{power.max}",
            payload = Severity.Error.class)
    public int getPower() {
        return power;
    }

    public void setPower(@Min(
            value = 1,
            message = "{power.min}",
            payload = Severity.Error.class) @Max(
            value = 5000,
            message = "{power.max}",
            payload = Severity.Error.class) int power) {
        this.power = power;
    }

    public @Size(
            min = 0,
            max = 5000,
            message = "{description.max}",
            payload = Severity.Error.class) String getDescription() {
        return description;
    }

    public void setDescription(@Size(
            min = 0,
            max = 5000,
            message = "{description.max}",
            payload = Severity.Error.class) String description) {
        this.description = description;
    }

    public LocalDateTime getDateOfAddingTheAdd() {
        return dateOfAddingTheAdd;
    }

    public void setDateOfAddingTheAdd(LocalDateTime dateOfAddingTheAdd) {
        this.dateOfAddingTheAdd = dateOfAddingTheAdd;
    }

    public @NotNull Year getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(@NotNull Year yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Min(
            value = 1,
            message = "{doorNumber.min}",
            payload = Severity.Error.class)
    @Max(
            value = 20,
            message = "{doorNumber.max}",
            payload = Severity.Error.class)
    public int getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(@Min(
            value = 1,
            message = "{doorNumber.min}",
            payload = Severity.Error.class) @Max(
            value = 20,
            message = "{doorNumber.max}",
            payload = Severity.Error.class) int doorNumber) {
        this.doorNumber = doorNumber;
    }

    @Min(
            value = 1,
            message = "{amountOfSeats.min}",
            payload = Severity.Error.class)
    @Max(
            value = 100,
            message = "{amountOfSeats.max}",
            payload = Severity.Error.class)
    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(@Min(
            value = 1,
            message = "{amountOfSeats.min}",
            payload = Severity.Error.class) @Max(
            value = 100,
            message = "{amountOfSeats.max}",
            payload = Severity.Error.class) int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    public @Pattern(
            regexp = "^[A-HJ-NPR-Z0-9]{17}$",
            message = "{vin.incorrect}",
            payload = Severity.Error.class) String getVin() {
        return vin;
    }

    public void setVin(@Pattern(
            regexp = "^[A-HJ-NPR-Z0-9]{17}$",
            message = "{vin.incorrect}",
            payload = Severity.Error.class) String vin) {
        this.vin = vin;
    }

    public @NotNull ColorPalette getColor() {
        return color;
    }

    public void setColor(@NotNull ColorPalette color) {
        this.color = color;
    }

    public @NotNull State getState() {
        return state;
    }

    public void setState(@NotNull State state) {
        this.state = state;
    }

    public @NotNull Brand getBrand() {
        return brand;
    }

    public void setBrand(@NotNull Brand brand) {
        this.brand = brand;
    }

    public @NotNull Petrol getPetrol() {
        return petrol;
    }

    public void setPetrol(@NotNull Petrol petrol) {
        this.petrol = petrol;
    }

    public @NotNull Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(@NotNull Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public @NotNull Bodytype getBodytype() {
        return bodytype;
    }

    public void setBodytype(@NotNull Bodytype bodytype) {
        this.bodytype = bodytype;
    }
}
