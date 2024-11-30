package com.app.myapp.dto.searchrangedtomembers;

public class DoorsRangeDto {
    private int minDoorNumber;
    private int maxDoorNumber;

    public DoorsRangeDto(int minDoorNumber, int maxDoorNumber) {
        this.minDoorNumber = minDoorNumber;
        this.maxDoorNumber = maxDoorNumber;
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