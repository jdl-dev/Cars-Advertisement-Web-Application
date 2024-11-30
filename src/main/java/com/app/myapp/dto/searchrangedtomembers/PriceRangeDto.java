package com.app.myapp.dto.searchrangedtomembers;

public class PriceRangeDto {
    private int minPrice = 1;
    private int maxPrice = 99999999;

    public PriceRangeDto() {
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }
}