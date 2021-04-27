package com.kl3jvi.rcccalculator.utils;

import android.graphics.Color;

import com.kl3jvi.rcccalculator.adapters.ColorDetails;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ArrayInitialiser {

    public static void initArrays(ArrayList<ColorDetails>... arrays) {

        arrays[0].add(new ColorDetails("Brown", "1", 1, Color.parseColor("#6b3d00")));
        arrays[0].add(new ColorDetails("Red", "2", 2, Color.parseColor("#d40000")));
        arrays[0].add(new ColorDetails("Orange", "3", 3, Color.parseColor("#FFA500")));
        arrays[0].add(new ColorDetails("Yellow", "4", 4, Color.parseColor("#FFFF00")));
        arrays[0].add(new ColorDetails("Green", "5", 5, Color.parseColor("#008000")));
        arrays[0].add(new ColorDetails("Blue", "6", 6, Color.parseColor("#0000FF")));
        arrays[0].add(new ColorDetails("Violet", "7", 7, Color.parseColor("#EE82EE")));
        arrays[0].add(new ColorDetails("Grey", "8", 8, Color.parseColor("#808080")));
        arrays[0].add(new ColorDetails("White", "9", 9, Color.parseColor("#FFFFFF")));

        arrays[1].add(new ColorDetails("Black", "0", 0, Color.parseColor("#000000")));
        arrays[1].add(new ColorDetails("Brown", "1", 1, Color.parseColor("#6b3d00")));
        arrays[1].add(new ColorDetails("Red", "2", 2, Color.parseColor("#d40000")));
        arrays[1].add(new ColorDetails("Orange", "3", 3, Color.parseColor("#FFA500")));
        arrays[1].add(new ColorDetails("Yellow", "4", 4, Color.parseColor("#FFFF00")));
        arrays[1].add(new ColorDetails("Green", "5", 5, Color.parseColor("#008000")));
        arrays[1].add(new ColorDetails("Blue", "6", 6, Color.parseColor("#0000FF")));
        arrays[1].add(new ColorDetails("Violet", "7", 7, Color.parseColor("#EE82EE")));
        arrays[1].add(new ColorDetails("Grey", "8", 8, Color.parseColor("#808080")));
        arrays[1].add(new ColorDetails("White", "9", 9, Color.parseColor("#FFFFFF")));

        arrays[2].add(new ColorDetails("Black", "10⁰", 1, Color.parseColor("#000000")));
        arrays[2].add(new ColorDetails("Brown", "10¹", 10, Color.parseColor("#6b3d00")));
        arrays[2].add(new ColorDetails("Red", "10²", 100, Color.parseColor("#d40000")));
        arrays[2].add(new ColorDetails("Orange", "10³", 1000, Color.parseColor("#FFA500")));
        arrays[2].add(new ColorDetails("Yellow", "10⁴", 10000, Color.parseColor("#FFFF00")));
        arrays[2].add(new ColorDetails("Green", "10⁵", 100000, Color.parseColor("#008000")));
        arrays[2].add(new ColorDetails("Blue", "10⁶", 1000000, Color.parseColor("#0000FF")));
        arrays[2].add(new ColorDetails("Violet", "10⁷", 1000000, Color.parseColor("#EE82EE")));
        arrays[2].add(new ColorDetails("Grey", "10⁸", 100000000, Color.parseColor("#808080")));
        arrays[2].add(new ColorDetails("White", "10⁹", 1000000000, Color.parseColor("#FFFFFF")));
        arrays[2].add(new ColorDetails("Gold", "10⁻¹", 0.1, Color.parseColor("#b8860b")));
        arrays[2].add(new ColorDetails("Silver", "10⁻²", 0.01, Color.parseColor("#b6b6b6")));

        arrays[3].add(new ColorDetails("Brown", "±1%", 0, Color.parseColor("#6b3d00")));
        arrays[3].add(new ColorDetails("Red", "±2%", 0, Color.parseColor("#d40000")));
        arrays[3].add(new ColorDetails("Orange", "±0.05%", 0, Color.parseColor("#FFA500")));
        arrays[3].add(new ColorDetails("Yellow", "±0.02%", 0, Color.parseColor("#FFFF00")));
        arrays[3].add(new ColorDetails("Green", "±0.5%", 0, Color.parseColor("#008000")));
        arrays[3].add(new ColorDetails("Blue", "±0.25%", 0, Color.parseColor("#0000FF")));
        arrays[3].add(new ColorDetails("Violet", "±0.1%", 0, Color.parseColor("#EE82EE")));
        arrays[3].add(new ColorDetails("Grey", "±0.01%", 0, Color.parseColor("#808080")));
        arrays[3].add(new ColorDetails("Gold", "±5%", 0, Color.parseColor("#b8860b")));
        arrays[3].add(new ColorDetails("Silver", "±10%", 0, Color.parseColor("#b6b6b6")));
        arrays[3].add(new ColorDetails("None", "±20%", 0, Color.parseColor("#d5b597")));

        arrays[4].add(new ColorDetails("Black", "250ppm/°C", 0, Color.parseColor("#000000")));
        arrays[4].add(new ColorDetails("Brown", "100ppm/°C", 0, Color.parseColor("#6b3d00")));
        arrays[4].add(new ColorDetails("Red", "50ppm/°C", 0, Color.parseColor("#d40000")));
        arrays[4].add(new ColorDetails("Orange", "15ppm/°C", 0, Color.parseColor("#FFA500")));
        arrays[4].add(new ColorDetails("Yellow", "25ppm/°C", 0, Color.parseColor("#FFFF00")));
        arrays[4].add(new ColorDetails("Green", "20ppm/°C", 0, Color.parseColor("#008000")));
        arrays[4].add(new ColorDetails("Blue", "10ppm/°C", 0, Color.parseColor("#0000FF")));
        arrays[4].add(new ColorDetails("Violet", "5ppm/°C", 0, Color.parseColor("#EE82EE")));
        arrays[4].add(new ColorDetails("Grey", "1ppm/°C", 0, Color.parseColor("#808080")));
    }

    public static String getRoughNumber(long value) {
        if (value <= 999) {
            return String.valueOf(value);
        }
        final String[] units = new String[]{"", "K", "M", "G", "P"};
        int digitGroups = (int) (Math.log10(value) / Math.log10(1000));
        return new DecimalFormat("#,##0.#").format(value / Math.pow(1000, digitGroups)) + "" + units[digitGroups];
    }

    public static int calculate4Band(int band1,int band2,int multiplicator){
        return ((band1*10)+band2) * multiplicator;
    }
}
