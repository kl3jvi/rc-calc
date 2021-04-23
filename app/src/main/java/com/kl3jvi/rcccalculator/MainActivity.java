package com.kl3jvi.rcccalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.kl3jvi.rcccalculator.adapters.ColorAdapter;
import com.kl3jvi.rcccalculator.adapters.ColorDetails;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinBands,spin_band1;
    private ImageView imageView;
    private ArrayList<ColorDetails> colorDetails;
    private ColorAdapter colorAdapter;
    private ArrayAdapter<ColorDetails> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        spinBands = findViewById(R.id.spinBands);
//        initList();

        // Spinner that listens to band changes --> put on a method for ease;
        spinnerListener(spinBands);

        spin_band1 = findViewById(R.id.band1);
        colorDetails = new ArrayList<>();



        colorDetails.add(new ColorDetails("Black", "0", 1));
        colorDetails.add(new ColorDetails("Red", "1", 1));
        colorDetails.add(new ColorDetails("Yellow", "2", 1));

        colorAdapter = new ColorAdapter(this,R.layout.band_spinner_row,R.id.colorName,colorDetails);
        spin_band1.setAdapter(colorAdapter);



    }



    public void spinnerListener(Spinner spinBands) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.number_bands));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBands.setAdapter(adapter);
        spinBands.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        imageView.setImageResource(R.drawable.resistor_4_band);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.resistor_5_band);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.resistor_6_band);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}