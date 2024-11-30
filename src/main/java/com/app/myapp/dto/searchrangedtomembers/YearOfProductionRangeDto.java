package com.app.myapp.dto.searchrangedtomembers;

import java.time.Year;

public class YearOfProductionRangeDto {
    private Year minYearOfProduction;
    private Year maxYearOfProduction;

    public YearOfProductionRangeDto(Year minYearOfProduction, Year maxYearOfProduction) {
        this.minYearOfProduction = minYearOfProduction;
        this.maxYearOfProduction = maxYearOfProduction;
    }

    public Year getMinYearOfProduction() {
        return minYearOfProduction;
    }

    public void setMinYearOfProduction(Year minYearOfProduction) {
        this.minYearOfProduction = minYearOfProduction;
    }

    public Year getMaxYearOfProduction() {
        return maxYearOfProduction;
    }

    public void setMaxYearOfProduction(Year maxYearOfProduction) {
        this.maxYearOfProduction = maxYearOfProduction;
    }
}