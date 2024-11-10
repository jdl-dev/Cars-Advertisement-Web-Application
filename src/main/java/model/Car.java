package model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import model.validation.annoations.ValidAmountOfSeats;
import model.validation.annoations.ValidDateOfAddingTheAdd;
import model.validation.annoations.ValidDescription;
import model.validation.annoations.ValidDisplacement;
import model.validation.annoations.ValidDoorNumbers;
import model.validation.annoations.ValidEnumMembersOfCarClass;
import model.validation.annoations.ValidMileage;
import model.validation.annoations.ValidPower;
import model.validation.annoations.ValidPrice;
import model.validation.annoations.ValidVin;
import model.validation.annoations.ValidYearOfProduction;

import java.awt.*;
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
    @ValidEnumMembersOfCarClass(enumClass = Gearbos.class)
    private Gearbos gearbox;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Bodytype.class)
    private Bodytype bodytype;

    @ValidDisplacement
    private int displacement;

    @ValidPower
    private int power;

    @ValidDescription
    private String description;

    @ValidDateOfAddingTheAdd
    private LocalDateTime dateOfAddingTheAdd;

    @ValidYearOfProduction
    private Year yearOfProduction;

    @ValidDoorNumbers
    private int doorNumber;

    @ValidAmountOfSeats
    private int amountOfSeats;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = ColorPalette.class)
    private ColorPalette color;

    @ValidVin
    private String vin;

    @Enumerated(value = EnumType.STRING)
    @ValidEnumMembersOfCarClass(enumClass = Condition.class)
    private Condition condition;
}
