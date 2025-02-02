package com.app.myapp.dto.car_dtos;

import com.app.myapp.model.model.User;
import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class CarResponseDto {
    private long id;
    private int price;
    private int mileage;
    private int displacement;
    private int power;
    private String description;
    private LocalDateTime dateOfAddingTheAdd;
    private LocalDateTime dateOfUpdatingTheAdd;
    private Year yearOfProduction;
    private int doorNumber;
    private int amountOfSeats;
    private String vin;
    private ColorPalette color;
    private State state;
    private Brand brand;
    private Petrol petrol;
    private Gearbox gearbox;
    private Bodytype bodytype;
    private User user;
}