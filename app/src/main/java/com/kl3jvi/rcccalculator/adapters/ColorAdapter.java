package com.kl3jvi.rcccalculator.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kl3jvi.rcccalculator.R;

import java.util.ArrayList;


public class ColorAdapter extends ArrayAdapter<ColorDetails> {
    private final Context mcontext;

    public ColorAdapter(Context context, int resouceId, int textviewId, ArrayList<ColorDetails> list) {
        super(context, resouceId, textviewId, list);
        mcontext = context;
        notifyDataSetChanged();
    }


    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        String colorName = getItem(position).getColorName();
        String quantity = getItem(position).getQuantity();
        int color = getItem(position).getDrawable();
        double number = getItem(position).getNumber();

        ColorDetails colorDetails = new ColorDetails(colorName, quantity, number, color);

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.band_spinner_row, parent, false);
        }

        TextView colorNameText = convertView.findViewById(R.id.colorName);
        TextView quantityText = convertView.findViewById(R.id.quantity);
        ImageView colorTint = convertView.findViewById(R.id.colorTint);

        Drawable background = colorTint.getBackground();
        ColorDetails currentItem = getItem(position);
        if (currentItem != null) {
            colorNameText.setText(colorName);
            quantityText.setText(quantity);
            background.setTint(color);
        }

        return convertView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String colorName = getItem(position).getColorName();
        String quantity = getItem(position).getQuantity();
        int color = getItem(position).getDrawable();
        double number = getItem(position).getNumber();

        ColorDetails colorDetails = new ColorDetails(colorName, quantity, number, color);
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.band_spinner_row, parent, false);
        }

        TextView colorNameText = convertView.findViewById(R.id.colorName);
        TextView quantityText = convertView.findViewById(R.id.quantity);
        ImageView colorTint = convertView.findViewById(R.id.colorTint);


        Drawable background = colorTint.getBackground();

        ColorDetails currentItem = getItem(position);
        if (currentItem != null) {
            colorNameText.setText(colorName);
            quantityText.setText(quantity);
            background.setTint(color);
        }

        return convertView;
    }
}
