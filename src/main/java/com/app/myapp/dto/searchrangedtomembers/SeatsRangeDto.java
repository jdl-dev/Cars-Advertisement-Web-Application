package com.app.myapp.dto.searchrangedtomembers;

public class SeatsRangeDto {
    private int minAmountOfSeats;
    private int maxAmountOfSeats;

    public SeatsRangeDto(int minAmountOfSeats, int maxAmountOfSeats) {
        this.minAmountOfSeats = minAmountOfSeats;
        this.maxAmountOfSeats = maxAmountOfSeats;
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