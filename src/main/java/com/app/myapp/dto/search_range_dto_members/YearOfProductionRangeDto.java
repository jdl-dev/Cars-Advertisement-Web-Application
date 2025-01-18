package com.app.myapp.dto.search_range_dto_members;

import java.time.Year;

public class YearOfProductionRangeDto {
    private int minYearOfProduction = 1850;
    private int maxYearOfProduction = Integer.parseInt(Year.now().toString());

    public YearOfProductionRangeDto() {
    }

    public int getMinYearOfProduction() {
        return minYearOfProduction;
    }

    public void setMinYearOfProduction(int minYearOfProduction) {
        this.minYearOfProduction = minYearOfProduction;
    }

    public int getMaxYearOfProduction() {
        return maxYearOfProduction;
    }

    public void setMaxYearOfProduction(int maxYearOfProduction) {
        this.maxYearOfProduction = maxYearOfProduction;
    }

    @Override
    public String toString() {
        return "YearOfProductionRangeDto{" +
                "minYearOfProduction=" + minYearOfProduction +
                ", maxYearOfProduction=" + maxYearOfProduction +
                '}';
    }
}