package com.kl3jvi.rcccalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinBands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = findViewById(R.id.imageView);
//        imageView.setImageResource(R.drawable.resistor_4_band);

        spinBands = findViewById(R.id.spinBands);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getResources()
                .getStringArray(R.array.number_bands));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinBands.setAdapter(adapter);

        spinBands.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
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