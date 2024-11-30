package com.app.myapp.dto.searchrangedtomembers;

public class MileageRangeDto {
    private int minMileage;
    private int maxMileage;

    public MileageRangeDto(int minMileage, int maxMileage) {
        this.minMileage = minMileage;
        this.maxMileage = maxMileage;
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