package com.app.myapp.dto;

import com.app.myapp.dto.search_range_dto_members.DisplacementRangeDto;
import com.app.myapp.dto.search_range_dto_members.DoorsRangeDto;
import com.app.myapp.dto.search_range_dto_members.MileageRangeDto;
import com.app.myapp.dto.search_range_dto_members.PowerRangeDto;
import com.app.myapp.dto.search_range_dto_members.PriceRangeDto;
import com.app.myapp.dto.search_range_dto_members.SeatsRangeDto;
import com.app.myapp.dto.search_range_dto_members.YearOfProductionRangeDto;
import com.app.myapp.model.model.car_members.Bodytype;
import com.app.myapp.model.model.car_members.Brand;
import com.app.myapp.model.model.car_members.ColorPalette;
import com.app.myapp.model.model.car_members.Gearbox;
import com.app.myapp.model.model.car_members.Petrol;
import com.app.myapp.model.model.car_members.State;
import com.app.myapp.validation.payloads.Severity;
import com.app.myapp.validation.validation.valid_values_range.ValidValuesRange;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchRangeDto {

    @ValidValuesRange(min = 1, max = 99999999, minField = "minPrice", maxField = "maxPrice", payload = Severity.Info.class)
    private PriceRangeDto priceRangeDto = new PriceRangeDto();

    @ValidValuesRange(min = 0, max = 15000000, minField = "minMileage", maxField = "maxMileage", payload = Severity.Info.class)
    private MileageRangeDto mileageRangeDto = new MileageRangeDto();

    @ValidValuesRange(min = 1, max = 10000, minField = "minDisplacement", maxField = "maxDisplacement", payload = Severity.Info.class)
    private DisplacementRangeDto displacementRangeDto = new DisplacementRangeDto();

    @ValidValuesRange(min = 1, max = 5000, minField = "minPower", maxField = "maxPower", payload = Severity.Info.class)
    private PowerRangeDto powerRangeDto = new PowerRangeDto();

    @ValidValuesRange(min = 1850, max = 9999, minField = "minYearOfProduction", maxField = "maxYearOfProduction", payload = Severity.Info.class)
    private YearOfProductionRangeDto yearOfProductionRangeDto = new YearOfProductionRangeDto();

    @ValidValuesRange(min = 1, max = 20, minField = "minDoorNumber", maxField = "maxDoorNumber", payload = Severity.Info.class)
    private DoorsRangeDto doorsRangeDto = new DoorsRangeDto();

    @ValidValuesRange(min = 1, max = 100, minField = "minAmountOfSeats", maxField = "maxAmountOfSeats", payload = Severity.Info.class)
    private SeatsRangeDto seatsRangeDto = new SeatsRangeDto();

    @NotNull
    private List<ColorPalette> colors = List.of(ColorPalette.values());

    @NotNull
    private List<State> states = List.of(State.values());

    @NotNull
    private List<Brand> brands = List.of(Brand.values());

    @NotNull
    private List<Petrol> petrolTypes = List.of(Petrol.values());

    @NotNull
    private List<Gearbox> gearboxTypes = List.of(Gearbox.values());

    @NotNull
    private List<Bodytype> bodytypeList = List.of(Bodytype.values());

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        SearchRangeDto that = (SearchRangeDto) object;
        return Objects.equals(priceRangeDto, that.priceRangeDto) && Objects.equals(mileageRangeDto, that.mileageRangeDto) && Objects.equals(displacementRangeDto, that.displacementRangeDto) && Objects.equals(powerRangeDto, that.powerRangeDto) && Objects.equals(yearOfProductionRangeDto, that.yearOfProductionRangeDto) && Objects.equals(doorsRangeDto, that.doorsRangeDto) && Objects.equals(seatsRangeDto, that.seatsRangeDto) && Objects.equals(colors, that.colors) && Objects.equals(states, that.states) && Objects.equals(brands, that.brands) && Objects.equals(petrolTypes, that.petrolTypes) && Objects.equals(gearboxTypes, that.gearboxTypes) && Objects.equals(bodytypeList, that.bodytypeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(priceRangeDto, mileageRangeDto, displacementRangeDto, powerRangeDto, yearOfProductionRangeDto, doorsRangeDto, seatsRangeDto, colors, states, brands, petrolTypes, gearboxTypes, bodytypeList);
    }

    @Override
    public String toString() {
        return "SearchRangeDto{" +
                "priceRangeDto=" + priceRangeDto +
                ", mileageRangeDto=" + mileageRangeDto +
                ", displacementRangeDto=" + displacementRangeDto +
                ", powerRangeDto=" + powerRangeDto +
                ", yearOfProductionRangeDto=" + yearOfProductionRangeDto +
                ", doorsRangeDto=" + doorsRangeDto +
                ", seatsRangeDto=" + seatsRangeDto +
                ", colors=" + colors +
                ", states=" + states +
                ", brands=" + brands +
                ", petrolTypes=" + petrolTypes +
                ", gearboxTypes=" + gearboxTypes +
                ", bodytypeList=" + bodytypeList +
                '}';
    }
}