package com.app.myapp.dto.searchrangedtomembers;

public class PowerRangeDto {
    private int minPower;
    private int maxPower;

    public PowerRangeDto(int minPower, int maxPower) {
        this.minPower = minPower;
        this.maxPower = maxPower;
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