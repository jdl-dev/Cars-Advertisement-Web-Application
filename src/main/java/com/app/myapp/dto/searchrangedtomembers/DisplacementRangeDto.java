package com.app.myapp.dto.searchrangedtomembers;

public class DisplacementRangeDto {
    private int minDisplacement = 1;
    private int maxDisplacement = 10000;

    public DisplacementRangeDto() {
    }

    public int getMinDisplacement() {
        return minDisplacement;
    }

    public void setMinDisplacement(int minDisplacement) {
        this.minDisplacement = minDisplacement;
    }

    public int getMaxDisplacement() {
        return maxDisplacement;
    }

    public void setMaxDisplacement(int maxDisplacement) {
        this.maxDisplacement = maxDisplacement;
    }
}