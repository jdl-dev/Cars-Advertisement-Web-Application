package com.app.myapp.dto.searchrangedtomembers;

import java.time.Year;

public class YearOfProductionRangeDto {
    private Year minYearOfProduction = Year.of(1850);
    private Year maxYearOfProduction = Year.now();

    public YearOfProductionRangeDto() {
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