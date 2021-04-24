package com.kl3jvi.rcccalculator.adapters;

public class ColorDetails {
    private String colorName;
    private String quantity;
    private int drawable;

    public ColorDetails(String colorName, String quantity, int drawable) {
        this.colorName = colorName;
        this.quantity = quantity;
        this.drawable = drawable;
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

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
