package com.app.myapp.dto.searchrangedtomembers;

public class SeatsRangeDto {
    private int minAmountOfSeats = 1;
    private int maxAmountOfSeats = 100;

    public SeatsRangeDto() {
    }

    public int getMinAmountOfSeats() {
        return minAmountOfSeats;
    }

    public void setMinAmountOfSeats(int minAmountOfSeats) {
        this.minAmountOfSeats = minAmountOfSeats;
    }

    public int getMaxAmountOfSeats() {
        return maxAmountOfSeats;
    }

    public void setMaxAmountOfSeats(int maxAmountOfSeats) {
        this.maxAmountOfSeats = maxAmountOfSeats;
    }
}