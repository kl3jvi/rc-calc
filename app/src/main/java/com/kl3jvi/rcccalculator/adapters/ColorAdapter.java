package com.kl3jvi.rcccalculator.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.kl3jvi.rcccalculator.R;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import java.util.ArrayList;


public class ColorAdapter extends ArrayAdapter<ColorDetails> {
    private final Context mcontext;

    public ColorAdapter(Context context,int resouceId, int textviewId, ArrayList<ColorDetails> list){
        super(context,resouceId,textviewId, list);
        mcontext = context;
        notifyDataSetChanged();
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        String colorName = getItem(position).getColorName();
        String quantity = getItem(position).getQuantity();
        int color = getItem(position).getColor();

        ColorDetails colorDetails = new ColorDetails(colorName, quantity, color);
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.band_spinner_row, parent, false);
        }

        TextView colorNameText = convertView.findViewById(R.id.colorName);
        TextView quantityText = convertView.findViewById(R.id.quantity);
        ImageView colorTint = convertView.findViewById(R.id.colorTint);

        colorNameText.setText(colorName);
        quantityText.setText(quantity);
//        colorTint.setColorFilter(ContextCompat.getColor(mcontext, R.color.purple_200), android.graphics.PorterDuff.Mode.SRC_IN);
        return convertView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        String colorName = getItem(position).getColorName();
        String quantity = getItem(position).getQuantity();
        int color = getItem(position).getColor();

        ColorDetails colorDetails = new ColorDetails(colorName, quantity, color);
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.band_spinner_row, parent, false);
        }

        TextView colorNameText = convertView.findViewById(R.id.colorName);
        TextView quantityText = convertView.findViewById(R.id.quantity);
        ImageView colorTint = convertView.findViewById(R.id.colorTint);

        colorTint.setColorFilter(mcontext.getResources().getColor(R.color.purple_200));

        colorNameText.setText(colorName);
        quantityText.setText(quantity);
//        colorTint.setColorFilter(color);
        return convertView;
    }
}
