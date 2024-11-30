package com.app.myapp.dto.searchrangedtomembers;

public class PowerRangeDto {
    private int minPower = 1;
    private int maxPower = 5000;

    public PowerRangeDto() {
    }

    public int getMinPower() {
        return minPower;
    }

    public void setMinPower(int minPower) {
        this.minPower = minPower;
    }

    public int getMaxPower() {
        return maxPower;
    }

    public void setMaxPower(int maxPower) {
        this.maxPower = maxPower;
    }
}