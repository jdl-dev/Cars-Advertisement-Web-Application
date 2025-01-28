package com.app.myapp.dto.search_range_dto_members;

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

    @Override
    public String toString() {
        return "DoorsRangeDto{" +
                "minDoorNumber=" + minDoorNumber +
                ", maxDoorNumber=" + maxDoorNumber +
                '}';
    }
}