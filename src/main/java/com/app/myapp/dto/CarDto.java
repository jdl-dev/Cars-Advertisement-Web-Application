package com.app.myapp.dto;

import com.app.myapp.model.model.User;
import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import com.app.myapp.validation.payloads.Severity;
import com.app.myapp.validation.validation.description_validation.ValidDescriptionForbiddenWords;
import com.app.myapp.validation.validation.year_production_validation.ValidYearOfProduction;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @NotNull(message = "Price must be given")
    @Min(
            value = 1,
            message = "{price.min}",
            payload = Severity.Error.class)
    @Max(
            value = 99999999,
            message = "{price.max}",
            payload = Severity.Error.class)
    private int price;

    @NotNull(message = "Mileage must be given")
    @Min(
            value = 0,
            message = "{mileage.min}",
            payload = Severity.Error.class)
    @Max(
            value = 15000000,
            message = "{mileage.max}",
            payload = Severity.Error.class)
    private int mileage;

    @NotNull(message = "Displacement must be given")
    @Min(
            value = 1,
            message = "{displacement.min}",
            payload = Severity.Error.class)
    @Max(
            value = 10000,
            message = "{displacement.max}",
            payload = Severity.Error.class)
    private int displacement;

    @NotNull(message = "Power must be given")
    @Min(
            value = 1,
            message = "{power.min}",
            payload = Severity.Error.class)
    @Max(
            value = 5000,
            message = "{power.max}",
            payload = Severity.Error.class)
    private int power;

    @NotNull(message = "Description must be given")
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

    @CreationTimestamp
    private LocalDateTime dateOfAddingTheAdd;

    @UpdateTimestamp
    private LocalDateTime dateOfUpdatingTheAdd;

    @NotNull(message = "Year must be given")
    @ValidYearOfProduction(minProductionYear = 1850, maxProductionYear = 9999)
    private Year yearOfProduction;

    @NotNull(message = "Door number must be given")
    @Min(
            value = 1,
            message = "{doorNumber.min}",
            payload = Severity.Error.class)
    @Max(
            value = 20,
            message = "{doorNumber.max}",
            payload = Severity.Error.class)
    private int doorNumber;

    @NotNull(message = "Amount of seats must be given")
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

    @NotNull
    private ColorPalette color;

    @NotNull
    private State state;

    @NotNull
    private Brand brand;

    @NotNull
    private Petrol petrol;

    @NotNull
    private Gearbox gearbox;

    @NotNull
    private Bodytype bodytype;

    @NotNull
    private User user;

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

        this.dateOfAddingTheAdd = dateOfAddingTheAdd.truncatedTo(ChronoUnit.SECONDS);
    }

    public LocalDateTime getDateOfUpdatingTheAdd() {
        return dateOfUpdatingTheAdd;
    }

    public void setDateOfUpdatingTheAdd(LocalDateTime dateOfUpdatingTheAdd) {
        if (dateOfUpdatingTheAdd != null)
            this.dateOfUpdatingTheAdd = dateOfUpdatingTheAdd.truncatedTo(ChronoUnit.SECONDS);
        else
            this.dateOfUpdatingTheAdd = null;
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

    public @NotNull User getUser() {
        return user;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "price=" + price +
                ", mileage=" + mileage +
                ", displacement=" + displacement +
                ", power=" + power +
                ", description='" + description + '\'' +
                ", dateOfAddingTheAdd=" + dateOfAddingTheAdd +
                ", dateOfUpdatingTheAdd=" + dateOfUpdatingTheAdd +
                ", yearOfProduction=" + yearOfProduction +
                ", doorNumber=" + doorNumber +
                ", amountOfSeats=" + amountOfSeats +
                ", vin='" + vin + '\'' +
                ", color=" + color +
                ", state=" + state +
                ", brand=" + brand +
                ", petrol=" + petrol +
                ", gearbox=" + gearbox +
                ", bodytype=" + bodytype +
                ", user=" + user +
                '}';
    }
}