package com.kl3jvi.rcccalculator;

import static com.kl3jvi.rcccalculator.utils.ArrayInitialiser.initArrays;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kl3jvi.rcccalculator.adapters.ColorAdapter;
import com.kl3jvi.rcccalculator.adapters.ColorDetails;
import com.sdsmdg.harjot.vectormaster.VectorMasterDrawable;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spinBands, spin_band1, spin_band2, spin_band3, multiplier_band, tolerance_band, temperature_band;
    private ImageView imageView;
    private ArrayList<ColorDetails> firstBandArray, elseBandArray, mttArray, toleranceArray, temperatureArray;
    private ColorAdapter firstAdapter, elseAdapter, mttAdapter, toleranceAdapter;
    private LinearLayout firstBandLayout, secondBandLayout, thirdBandLayout, multiplierLayout, toleranceLayout, temperatureLayout;
    private ColorAdapter temperatureAdapter;

    private VectorMasterDrawable resistor_4, resistor_5, resistor_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstBandArray = new ArrayList<>();
        elseBandArray = new ArrayList<>();
        mttArray = new ArrayList<>();
        toleranceArray = new ArrayList<>();
        temperatureArray = new ArrayList<>();

        imageView = findViewById(R.id.imageView);
        spinBands = findViewById(R.id.spinBands);

        // Spinner that listens to band changes --> put on a method for ease;
        // Changes from 4 to 5 to 6 bands;
        spinnerListener(spinBands);

        // Initialisation of the spinner views
        spin_band1 = findViewById(R.id.band1);
        spin_band2 = findViewById(R.id.band2);
        spin_band3 = findViewById(R.id.band3);
        multiplier_band = findViewById(R.id.multiplier);
        tolerance_band = findViewById(R.id.tolerance);
        temperature_band = findViewById(R.id.temperature);

        // Initialisation of the layouts;
        firstBandLayout = findViewById(R.id.firstBandLayout);
        secondBandLayout = findViewById(R.id.secondBandLayout);
        thirdBandLayout = findViewById(R.id.thirdBandLayout);
        multiplierLayout = findViewById(R.id.multiplierLayout);
        toleranceLayout = findViewById(R.id.toleranceLayout);
        temperatureLayout = findViewById(R.id.temperatureLayout);

        // Initialise and fill arrays;
        initArrays(firstBandArray, elseBandArray, mttArray, toleranceArray, temperatureArray);

        firstAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, firstBandArray);
        elseAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, elseBandArray);
        mttAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, mttArray);
        toleranceAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, toleranceArray);
        temperatureAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, temperatureArray);

        spin_band1.setAdapter(firstAdapter);
        spin_band1_listener(spin_band1);

        spin_band2.setAdapter(elseAdapter);
        spin_band2_listener(spin_band2);

        spin_band3.setAdapter(elseAdapter);
        spin_band3_listener(spin_band3);

        multiplier_band.setAdapter(mttAdapter);
        multiplier_band_listener(multiplier_band);

        tolerance_band.setAdapter(toleranceAdapter);
        temperature_band.setAdapter(temperatureAdapter);

        resistor_4 = new VectorMasterDrawable(this, R.drawable.resistor_4_band);
        resistor_5 = new VectorMasterDrawable(this, R.drawable.resistor_5_band);
        resistor_6 = new VectorMasterDrawable(this, R.drawable.resistor_6_band);

    }

    private void multiplier_band_listener(Spinner multiplier_band) {
        multiplier_band.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = mttArray.get(position).getDrawable();

                PathModel res5_band3 = resistor_5.getPathModelByName("bm");
                PathModel res6_band3 = resistor_6.getPathModelByName("bm");

                res5_band3.setFillColor(color);
                res6_band3.setFillColor(color);

                resistor_5.update();
                resistor_6.update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spin_band3_listener(Spinner spin_band3) {
        spin_band3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = elseBandArray.get(position).getDrawable();

                PathModel res5_band3 = resistor_5.getPathModelByName("b3");
                PathModel res6_band3 = resistor_6.getPathModelByName("b3");

                res5_band3.setFillColor(color);
                res6_band3.setFillColor(color);

                resistor_5.update();
                resistor_6.update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spin_band2_listener(Spinner spin_band2) {
        spin_band2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = elseBandArray.get(position).getDrawable();
                PathModel res4_band2 = resistor_4.getPathModelByName("b2");
                PathModel res5_band2 = resistor_5.getPathModelByName("b2");
                PathModel res6_band2 = resistor_6.getPathModelByName("b2");

                res4_band2.setFillColor(color);
                res5_band2.setFillColor(color);
                res6_band2.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void spin_band1_listener(Spinner spin_band1) {
        spin_band1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = firstBandArray.get(position).getDrawable();
                PathModel res4_band1 = resistor_4.getPathModelByName("b1");
                PathModel res5_band1 = resistor_5.getPathModelByName("b1");
                PathModel res6_band1 = resistor_6.getPathModelByName("b1");

                res4_band1.setFillColor(color);
                res5_band1.setFillColor(color);
                res6_band1.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void spinnerListener(@NonNull Spinner spinBands) {
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
                        imageView.setImageDrawable(resistor_4);
                        thirdBandLayout.setVisibility(View.GONE);
                        temperatureLayout.setVisibility(View.GONE);
                        break;
                    case 1:
                        imageView.setImageDrawable(resistor_5);
                        thirdBandLayout.setVisibility(View.VISIBLE);
                        temperatureLayout.setVisibility(View.GONE);
                        break;
                    case 2:
                        imageView.setImageDrawable(resistor_6);
                        thirdBandLayout.setVisibility(View.VISIBLE);
                        temperatureLayout.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}