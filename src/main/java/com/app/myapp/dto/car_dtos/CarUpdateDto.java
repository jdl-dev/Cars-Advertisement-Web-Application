package com.app.myapp.dto.car_dtos;

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
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.Year;

@Getter
@ToString
public class CarUpdateDto {
    @Min(
            value = 1,
            message = "{price.min}",
            payload = Severity.Error.class)
    @Max(
            value = 99999999,
            message = "{price.max}",
            payload = Severity.Error.class)
    private Integer price;

    @Min(
            value = 0,
            message = "{mileage.min}",
            payload = Severity.Error.class)
    @Max(
            value = 15000000,
            message = "{mileage.max}",
            payload = Severity.Error.class)
    private Integer mileage;

    @Min(
            value = 1,
            message = "{displacement.min}",
            payload = Severity.Error.class)
    @Max(
            value = 10000,
            message = "{displacement.max}",
            payload = Severity.Error.class)
    private Integer displacement;

    @Min(
            value = 1,
            message = "{power.min}",
            payload = Severity.Error.class)
    @Max(
            value = 5000,
            message = "{power.max}",
            payload = Severity.Error.class)
    private Integer power;

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

    @NotNull
    private LocalDateTime dateOfUpdatingTheAdd;

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
    private Integer doorNumber;

    @Min(
            value = 1,
            message = "{amountOfSeats.min}",
            payload = Severity.Error.class)
    @Max(
            value = 100,
            message = "{amountOfSeats.max}",
            payload = Severity.Error.class)
    private Integer amountOfSeats;

    @Pattern(
            regexp = "^[A-HJ-NPR-Z0-9]{17}$",
            message = "{vin.incorrect}",
            payload = Severity.Error.class)
    private String vin;

    private ColorPalette color;
    private State state;
    private Brand brand;
    private Petrol petrol;
    private Gearbox gearbox;
    private Bodytype bodytype;
}