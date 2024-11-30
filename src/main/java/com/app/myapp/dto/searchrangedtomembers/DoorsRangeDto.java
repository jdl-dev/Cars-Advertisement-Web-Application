package com.app.myapp.dto.searchrangedtomembers;

public class DoorsRangeDto {
    private int minDoorNumber = 1;
    private int maxDoorNumber = 20;

    public DoorsRangeDto() {
    }

    public int getMinDoorNumber() {
        return minDoorNumber;
    }

    public void setMinDoorNumber(int minDoorNumber) {
        this.minDoorNumber = minDoorNumber;
    }

    public int getMaxDoorNumber() {
        return maxDoorNumber;
    }

    public void setMaxDoorNumber(int maxDoorNumber) {
        this.maxDoorNumber = maxDoorNumber;
    }
}