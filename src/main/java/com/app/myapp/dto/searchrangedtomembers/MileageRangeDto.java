package com.app.myapp.dto.searchrangedtomembers;

public class MileageRangeDto {
    private int minMileage = 0;
    private int maxMileage = 15000000;

    public MileageRangeDto() {
    }

    public int getMinMileage() {
        return minMileage;
    }

    public void setMinMileage(int minMileage) {
        this.minMileage = minMileage;
    }

    public int getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(int maxMileage) {
        this.maxMileage = maxMileage;
    }
}