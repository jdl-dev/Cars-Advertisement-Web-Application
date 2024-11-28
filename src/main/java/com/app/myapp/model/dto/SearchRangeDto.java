package com.app.myapp.model.dto;

import com.app.myapp.model.model.modelmembers.Bodytype;
import com.app.myapp.model.model.modelmembers.Brand;
import com.app.myapp.model.model.modelmembers.ColorPalette;
import com.app.myapp.model.model.modelmembers.Gearbox;
import com.app.myapp.model.model.modelmembers.Petrol;
import com.app.myapp.model.model.modelmembers.State;

import java.time.Year;
import java.util.List;

public class SearchRangeDto {
    private int minPrice;
    private int maxPrice;
    private int minMileage;
    private int maxMileage;
    private int minDisplacement;
    private int maxDisplacement;
    private int minPower;
    private int maxPower;
    private Year minYearOfProduction;
    private Year maxYearOfProduction;
    private int minDoorNumber;
    private int maxDoorNumber;
    private int minAmountOfSeats;
    private int maxAmountOfSeats;
    private List<ColorPalette> colors;
    private List<State> states;
    private List<Brand> brands;
    private List<Petrol> petrolTypes;
    private List<Gearbox> gearboxTypes;
    private List<Bodytype> bodytypeList;

}
