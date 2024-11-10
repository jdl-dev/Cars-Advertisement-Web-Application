package model;

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
    private int price;
    private int mileage;
    @Enumerated(value = EnumType.STRING)
    private Brand brand;
    @Enumerated(value = EnumType.STRING)
    private Petrol petrol;
    @Enumerated(value = EnumType.STRING)
    private Gearbos gearbox;
    @Enumerated(value = EnumType.STRING)
    private Bodytype bodytype;
    private int displacement;
    private int power;
    private String description;
    private LocalDateTime dateOfAddingTheAdd;
    private Year yearOfProduction;
    private int doorNumber;
    private int amountOfSeats;
    @Enumerated(value = EnumType.STRING)
    private ColorPalette color;
    private String vin;
    @Enumerated(value = EnumType.STRING)
    private Condition condition;
}
