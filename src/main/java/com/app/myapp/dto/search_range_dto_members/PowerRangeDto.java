package com.app.myapp.dto.search_range_dto_members;

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

    @Override
    public String toString() {
        return "PowerRangeDto{" +
                "minPower=" + minPower +
                ", maxPower=" + maxPower +
                '}';
    }
}