package com.app.myapp.dto;

import com.app.myapp.dto.searchrangedtomembers.DisplacementRangeDto;
import com.app.myapp.dto.searchrangedtomembers.DoorsRangeDto;
import com.app.myapp.dto.searchrangedtomembers.MileageRangeDto;
import com.app.myapp.dto.searchrangedtomembers.PowerRangeDto;
import com.app.myapp.dto.searchrangedtomembers.PriceRangeDto;
import com.app.myapp.dto.searchrangedtomembers.SeatsRangeDto;
import com.app.myapp.dto.searchrangedtomembers.YearOfProductionRangeDto;
import com.app.myapp.model.model.carmembers.Bodytype;
import com.app.myapp.model.model.carmembers.Brand;
import com.app.myapp.model.model.carmembers.ColorPalette;
import com.app.myapp.model.model.carmembers.Gearbox;
import com.app.myapp.model.model.carmembers.Petrol;
import com.app.myapp.model.model.carmembers.State;
import com.app.myapp.validation.validation.searchrangedto.validvaluesrange.ValidValuesRange;

import java.util.List;

public class SearchRangeDto {

    @ValidValuesRange(min = 1, max = 99999999, minField = "minPrice", maxField = "maxPrice")
    private PriceRangeDto priceRangeDto;
    private MileageRangeDto mileageRangeDto;
    private DisplacementRangeDto displacementRangeDto;
    private PowerRangeDto powerRangeDto;
    private YearOfProductionRangeDto yearOfProductionRangeDto;
    private DoorsRangeDto doorsRangeDto;
    private SeatsRangeDto seatsRangeDto;
    private List<ColorPalette> colors;
    private List<State> states;
    private List<Brand> brands;
    private List<Petrol> petrolTypes;
    private List<Gearbox> gearboxTypes;
    private List<Bodytype> bodytypeList;

    public PriceRangeDto getPriceRangeDto() {
        return priceRangeDto;
    }

    public void setPriceRangeDto(PriceRangeDto priceRangeDto) {
        this.priceRangeDto = priceRangeDto;
    }

    public MileageRangeDto getMileageRangeDto() {
        return mileageRangeDto;
    }

    public void setMileageRangeDto(MileageRangeDto mileageRangeDto) {
        this.mileageRangeDto = mileageRangeDto;
    }

    public DisplacementRangeDto getDisplacementRangeDto() {
        return displacementRangeDto;
    }

    public void setDisplacementRangeDto(DisplacementRangeDto displacementRangeDto) {
        this.displacementRangeDto = displacementRangeDto;
    }

    public PowerRangeDto getPowerRangeDto() {
        return powerRangeDto;
    }

    public void setPowerRangeDto(PowerRangeDto powerRangeDto) {
        this.powerRangeDto = powerRangeDto;
    }

    public YearOfProductionRangeDto getYearOfProductionRangeDto() {
        return yearOfProductionRangeDto;
    }

    public void setYearOfProductionRangeDto(YearOfProductionRangeDto yearOfProductionRangeDto) {
        this.yearOfProductionRangeDto = yearOfProductionRangeDto;
    }

    public DoorsRangeDto getDoorsRangeDto() {
        return doorsRangeDto;
    }

    public void setDoorsRangeDto(DoorsRangeDto doorsRangeDto) {
        this.doorsRangeDto = doorsRangeDto;
    }

    public SeatsRangeDto getSeatsRangeDto() {
        return seatsRangeDto;
    }

    public void setSeatsRangeDto(SeatsRangeDto seatsRangeDto) {
        this.seatsRangeDto = seatsRangeDto;
    }

    public List<ColorPalette> getColors() {
        return colors;
    }

    public void setColors(List<ColorPalette> colors) {
        this.colors = colors;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    public List<Petrol> getPetrolTypes() {
        return petrolTypes;
    }

    public void setPetrolTypes(List<Petrol> petrolTypes) {
        this.petrolTypes = petrolTypes;
    }

    public List<Gearbox> getGearboxTypes() {
        return gearboxTypes;
    }

    public void setGearboxTypes(List<Gearbox> gearboxTypes) {
        this.gearboxTypes = gearboxTypes;
    }

    public List<Bodytype> getBodytypeList() {
        return bodytypeList;
    }

    public void setBodytypeList(List<Bodytype> bodytypeList) {
        this.bodytypeList = bodytypeList;
    }
}