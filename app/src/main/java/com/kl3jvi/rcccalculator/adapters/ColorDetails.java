package com.kl3jvi.rcccalculator.adapters;

public class ColorDetails {
    private String colorName;
    private String quantity;
    private int color;

    public ColorDetails(String colorName, String quantity, int color) {
        this.colorName = colorName;
        this.quantity = quantity;
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
