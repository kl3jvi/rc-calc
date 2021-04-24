package com.kl3jvi.rcccalculator.utils;

import android.graphics.Color;

import com.kl3jvi.rcccalculator.adapters.ColorDetails;

import java.util.ArrayList;

public class ArrayInitialiser {
    
    public static void initArrays(ArrayList<ColorDetails>... arrays){

        arrays[0].add(new ColorDetails("Brown","1", Color.parseColor("#6b3d00")));
        arrays[0].add(new ColorDetails("Red", "2",Color.parseColor("#d40000")));
        arrays[0].add(new ColorDetails("Orange", "3",Color.parseColor("#FFA500")));
        arrays[0].add(new ColorDetails("Yellow", "4",Color.parseColor("#FFFF00")));
        arrays[0].add(new ColorDetails("Green", "5",Color.parseColor("#008000")));
        arrays[0].add(new ColorDetails("Blue", "6",Color.parseColor("#0000FF")));
        arrays[0].add(new ColorDetails("Violet", "7",Color.parseColor("#EE82EE")));
        arrays[0].add(new ColorDetails("Grey", "8",Color.parseColor("#808080")));
        arrays[0].add(new ColorDetails("White", "9",Color.parseColor("#FFFFFF")));

        arrays[1].add(new ColorDetails("Black","0",Color.parseColor("#000000")));
        arrays[1].add(new ColorDetails("Brown","1",Color.parseColor("#6b3d00")));
        arrays[1].add(new ColorDetails("Red", "2",Color.parseColor("#d40000")));
        arrays[1].add(new ColorDetails("Orange", "3",Color.parseColor("#FFA500")));
        arrays[1].add(new ColorDetails("Yellow", "4",Color.parseColor("#FFFF00")));
        arrays[1].add(new ColorDetails("Green", "5",Color.parseColor("#008000")));
        arrays[1].add(new ColorDetails("Blue", "6",Color.parseColor("#0000FF")));
        arrays[1].add(new ColorDetails("Violet", "7",Color.parseColor("#EE82EE")));
        arrays[1].add(new ColorDetails("Grey", "8",Color.parseColor("#808080")));
        arrays[1].add(new ColorDetails("White", "9",Color.parseColor("#FFFFFF")));

        arrays[2].add(new ColorDetails("Black","1",Color.parseColor("#000000")));
        arrays[2].add(new ColorDetails("Brown","10",Color.parseColor("#6b3d00")));
        arrays[2].add(new ColorDetails("Red","100",Color.parseColor("#d40000")));
        arrays[2].add(new ColorDetails("Orange","1k",Color.parseColor("#FFA500")));
        arrays[2].add(new ColorDetails("Yellow","10k",Color.parseColor("#FFFF00")));
        arrays[2].add(new ColorDetails("Green","100k",Color.parseColor("#008000")));
        arrays[2].add(new ColorDetails("Blue","1M",Color.parseColor("#0000FF")));
        arrays[2].add(new ColorDetails("Violet","10M",Color.parseColor("#EE82EE")));
        arrays[2].add(new ColorDetails("Grey","100M",Color.parseColor("#808080")));
        arrays[2].add(new ColorDetails("White","1G",Color.parseColor("#FFFFFF")));
        arrays[2].add(new ColorDetails("Gold","0.1",Color.parseColor("#b8860b")));
        arrays[2].add(new ColorDetails("Silver","0.01",Color.parseColor("#b6b6b6")));

        arrays[3].add(new ColorDetails("Brown","±1%",Color.parseColor("#6b3d00")));
        arrays[3].add(new ColorDetails("Red","±2%",Color.parseColor("#d40000")));
        arrays[3].add(new ColorDetails("Orange","±0.05%",Color.parseColor("#FFA500")));
        arrays[3].add(new ColorDetails("Yellow","±0.02%",Color.parseColor("#FFFF00")));
        arrays[3].add(new ColorDetails("Green","±0.5%",Color.parseColor("#008000")));
        arrays[3].add(new ColorDetails("Blue","±0.25%",Color.parseColor("#0000FF")));
        arrays[3].add(new ColorDetails("Violet","±0.1%",Color.parseColor("#EE82EE")));
        arrays[3].add(new ColorDetails("Grey","±0.01%",Color.parseColor("#808080")));
        arrays[3].add(new ColorDetails("Gold","±5%",Color.parseColor("#b8860b")));
        arrays[3].add(new ColorDetails("Silver","±10%",Color.parseColor("#b6b6b6")));
        arrays[3].add(new ColorDetails("None","±20%",Color.parseColor("#d5b597")));

        arrays[4].add(new ColorDetails("Black","250ppm/°C",Color.parseColor("#000000")));
        arrays[4].add(new ColorDetails("Brown","100ppm/°C",Color.parseColor("#6b3d00")));
        arrays[4].add(new ColorDetails("Red","50ppm/°C",Color.parseColor("#d40000")));
        arrays[4].add(new ColorDetails("Orange","15ppm/°C",Color.parseColor("#FFA500")));
        arrays[4].add(new ColorDetails("Yellow","25ppm/°C",Color.parseColor("#FFFF00")));
        arrays[4].add(new ColorDetails("Green","20ppm/°C",Color.parseColor("#008000")));
        arrays[4].add(new ColorDetails("Blue","10ppm/°C",Color.parseColor("#0000FF")));
        arrays[4].add(new ColorDetails("Violet","5ppm/°C",Color.parseColor("#EE82EE")));
        arrays[4].add(new ColorDetails("Grey","1ppm/°C",Color.parseColor("#808080")));
    }
}
