package com.app.myapp.dto.searchrangedtomembers;

public class DisplacementRangeDto {
    private int minDisplacement;
    private int maxDisplacement;

    public DisplacementRangeDto(int minDisplacement, int maxDisplacement) {
        this.minDisplacement = minDisplacement;
        this.maxDisplacement = maxDisplacement;
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