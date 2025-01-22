package com.app.myapp.model.model;

import com.app.myapp.model.model.converter.LocalDateTimeToStringConverter;
import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int price;
    private int mileage;
    private int displacement;
    private int power;
    private String description;
    @Convert(converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime dateOfAddingTheAdd;
    @Convert(converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime dateOfUpdatingTheAdd;
    private Year yearOfProduction;
    private int doorNumber;
    private int amountOfSeats;
    private String vin;
    @Enumerated(EnumType.STRING)
    private ColorPalette color;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Enumerated(EnumType.STRING)
    private Petrol petrol;
    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;
    @Enumerated(EnumType.STRING)
    private Bodytype bodytype;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

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

    public LocalDateTime getDateOfUpdatingTheAdd() {
        return dateOfUpdatingTheAdd;
    }

    public void setDateOfUpdatingTheAdd(LocalDateTime dateOfUpdatingTheAdd) {
        if (dateOfUpdatingTheAdd != null)
            this.dateOfUpdatingTheAdd = dateOfUpdatingTheAdd.truncatedTo(ChronoUnit.SECONDS);
        else
            this.dateOfUpdatingTheAdd = null;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Car car)) return false;
        return getPrice() == car.getPrice() && getMileage() == car.getMileage() && getDisplacement() == car.getDisplacement() && getPower() == car.getPower() && getDoorNumber() == car.getDoorNumber() && getAmountOfSeats() == car.getAmountOfSeats() && Objects.equals(getDescription(), car.getDescription()) && Objects.equals(getDateOfAddingTheAdd(), car.getDateOfAddingTheAdd()) && Objects.equals(getDateOfUpdatingTheAdd(), car.getDateOfUpdatingTheAdd()) && Objects.equals(getYearOfProduction(), car.getYearOfProduction()) && Objects.equals(getVin(), car.getVin()) && getColor() == car.getColor() && getState() == car.getState() && getBrand() == car.getBrand() && getPetrol() == car.getPetrol() && getGearbox() == car.getGearbox() && getBodytype() == car.getBodytype() && Objects.equals(getUser(), car.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrice(), getMileage(), getDisplacement(), getPower(), getDescription(), getDateOfAddingTheAdd(), getDateOfUpdatingTheAdd(), getYearOfProduction(), getDoorNumber(), getAmountOfSeats(), getVin(), getColor(), getState(), getBrand(), getPetrol(), getGearbox(), getBodytype(), getUser());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", price=" + price +
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