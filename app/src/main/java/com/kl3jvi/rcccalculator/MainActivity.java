package com.kl3jvi.rcccalculator;

import static com.kl3jvi.rcccalculator.utils.Calculator.initArrays;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kl3jvi.rcccalculator.adapters.ColorAdapter;
import com.kl3jvi.rcccalculator.adapters.ColorDetails;
import com.kl3jvi.rcccalculator.utils.Calculator;
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
    private TextView result, resultTolerance, resultTemperature;
    private VectorMasterDrawable resistor_4, resistor_5, resistor_6;
    private double[] fourBandSelections, fiveBandSelections, sixBandSelections;
    private AutoCompleteTextView td;
    private int state = 4;
    private ArrayAdapter<String> adapter, ohmSizesAdapter;


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

        td = findViewById(R.id.drp);


        // Spinner that listens to band changes --> put on a method for ease;
        // Changes from 4 to 5 to 6 bands;
        spinnerListener(td);

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
        result = findViewById(R.id.result);
        resultTolerance = findViewById(R.id.resultTolerance);
        resultTemperature = findViewById(R.id.resultTemperature);
        resultTemperature.setVisibility(View.GONE);


        // Initialise and fill arrays;
        initArrays(firstBandArray, elseBandArray, mttArray, toleranceArray, temperatureArray);

        firstAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, firstBandArray);
        elseAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, elseBandArray);
        mttAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, mttArray);
        toleranceAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, toleranceArray);
        temperatureAdapter = new ColorAdapter(this, R.layout.band_spinner_row, R.id.colorName, temperatureArray);

        spin_band1.setAdapter(firstAdapter);
        spin_band1_listener(spin_band1);
        spin_band1.setSelection(0);

        spin_band2.setAdapter(elseAdapter);
        spin_band2_listener(spin_band2);
        spin_band2.setSelection(0);

        spin_band3.setAdapter(elseAdapter);
        spin_band3_listener(spin_band3);
        spin_band3.setSelection(0);

        multiplier_band.setAdapter(mttAdapter);
        multiplier_band_listener(multiplier_band);
        multiplier_band.setSelection(0);

        tolerance_band.setAdapter(toleranceAdapter);
        tolerance_band_listener(tolerance_band);
        tolerance_band.setSelection(0);

        temperature_band.setAdapter(temperatureAdapter);
        temperature_band_listener(temperature_band);
        temperature_band.setSelection(0);

        resistor_4 = new VectorMasterDrawable(this, R.drawable.resistor_4_band);
        resistor_5 = new VectorMasterDrawable(this, R.drawable.resistor_5_band);
        resistor_6 = new VectorMasterDrawable(this, R.drawable.resistor_6_band);

        imageView.setImageDrawable(resistor_4);
        thirdBandLayout.setVisibility(View.GONE);
        temperatureLayout.setVisibility(View.GONE);

        fourBandSelections = new double[3];
        fiveBandSelections = new double[4];
        sixBandSelections = new double[5];

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int itemId = item.getItemId();
        if (itemId == R.id.search) {
            showDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void temperature_band_listener(Spinner temperature_band) {
        temperature_band.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = temperatureArray.get(position).getDrawable();
                String temperature = temperatureArray.get(position).getQuantity();

                PathModel res6_band6 = resistor_6.getPathModelByName("bc");
                res6_band6.setFillColor(color);

                resistor_6.update();
                resultTemperature.setText(" @" + temperature);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void tolerance_band_listener(Spinner tolerance_band) {
        tolerance_band.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = toleranceArray.get(position).getDrawable();
                String tolerance = toleranceArray.get(position).getQuantity();
                PathModel res3_band5 = resistor_4.getPathModelByName("bt");
                PathModel res5_band5 = resistor_5.getPathModelByName("bt");
                PathModel res6_band5 = resistor_6.getPathModelByName("bt");

                res3_band5.setFillColor(color);
                res5_band5.setFillColor(color);
                res6_band5.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();
                resultTolerance.setText("Ω " + tolerance);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void multiplier_band_listener(Spinner multiplier_band) {
        multiplier_band.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = mttArray.get(position).getDrawable();
                double no = mttArray.get(position).getNumber();
                fourBandSelections[2] = no;
                fiveBandSelections[3] = no;

                PathModel res3_band4 = resistor_4.getPathModelByName("bm");
                PathModel res5_band4 = resistor_5.getPathModelByName("bm");
                PathModel res6_band4 = resistor_6.getPathModelByName("bm");

                res3_band4.setFillColor(color);
                res5_band4.setFillColor(color);
                res6_band4.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();

                if (state == 4) {
                    double result4band = Calculator.calculate4Band(fourBandSelections[0], fourBandSelections[1], fourBandSelections[2]);
                    result.setText(Calculator.getRoughNumber(result4band));
                } else {
                    double result5band = Calculator.calculate5Band(fiveBandSelections[0], fiveBandSelections[1], fiveBandSelections[2], fiveBandSelections[3]);
                    result.setText(Calculator.getRoughNumber(result5band));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    private void spin_band3_listener(Spinner spin_band3) {
        spin_band3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int color = elseBandArray.get(position).getDrawable();
                double no = elseBandArray.get(position).getNumber();


                fiveBandSelections[2] = no;

                PathModel res5_band3 = resistor_5.getPathModelByName("b3");
                PathModel res6_band3 = resistor_6.getPathModelByName("b3");

                res5_band3.setFillColor(color);
                res6_band3.setFillColor(color);

                resistor_5.update();
                resistor_6.update();

                if (state != 4) {
                    double resultati5band = Calculator.calculate5Band(fiveBandSelections[0], fiveBandSelections[1], fiveBandSelections[2], fiveBandSelections[3]);
                    result.setText(Calculator.getRoughNumber(resultati5band));
                }
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
                double no = elseBandArray.get(position).getNumber();
                fourBandSelections[1] = no;
                fiveBandSelections[1] = no;

                Log.e("Number", no + "");
                PathModel res4_band2 = resistor_4.getPathModelByName("b2");
                PathModel res5_band2 = resistor_5.getPathModelByName("b2");
                PathModel res6_band2 = resistor_6.getPathModelByName("b2");

                res4_band2.setFillColor(color);
                res5_band2.setFillColor(color);
                res6_band2.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();

                if (state == 4) {
                    double resultati4band = Calculator.calculate4Band(fourBandSelections[0], fourBandSelections[1], fourBandSelections[2]);
                    result.setText(Calculator.getRoughNumber(resultati4band));
                } else {
                    double resultati5band = Calculator.calculate5Band(fiveBandSelections[0], fiveBandSelections[1], fiveBandSelections[2], fiveBandSelections[3]);
                    result.setText(Calculator.getRoughNumber(resultati5band));
                }
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
                double no = firstBandArray.get(position).getNumber();
                fourBandSelections[0] = no;
                fiveBandSelections[0] = no;
                sixBandSelections[0] = no;


                PathModel res4_band1 = resistor_4.getPathModelByName("b1");
                PathModel res5_band1 = resistor_5.getPathModelByName("b1");
                PathModel res6_band1 = resistor_6.getPathModelByName("b1");

                res4_band1.setFillColor(color);
                res5_band1.setFillColor(color);
                res6_band1.setFillColor(color);

                resistor_4.update();
                resistor_5.update();
                resistor_6.update();

                if (state == 4) {
                    double resultati4band = Calculator.calculate4Band(fourBandSelections[0], fourBandSelections[1], fourBandSelections[2]);
                    result.setText(Calculator.getRoughNumber(resultati4band));
                } else {
                    double resultati5band = Calculator.calculate5Band(fiveBandSelections[0], fiveBandSelections[1], fiveBandSelections[2], fiveBandSelections[3]);
                    result.setText(Calculator.getRoughNumber(resultati5band));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void spinnerListener(@NonNull AutoCompleteTextView spinBands) {
        adapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.number_bands));
        spinBands.setAdapter(adapter);
        td.setText(adapter.getItem(0), false);

        spinBands.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    imageView.setImageDrawable(resistor_4);
                    thirdBandLayout.setVisibility(View.GONE);
                    temperatureLayout.setVisibility(View.GONE);
                    resultTemperature.setVisibility(View.GONE);
                    state = 4;
                    break;
                case 1:
                    imageView.setImageDrawable(resistor_5);
                    thirdBandLayout.setVisibility(View.VISIBLE);
                    temperatureLayout.setVisibility(View.GONE);
                    resultTemperature.setVisibility(View.GONE);
                    state = 5;
                    break;
                case 2:
                    imageView.setImageDrawable(resistor_6);
                    thirdBandLayout.setVisibility(View.VISIBLE);
                    temperatureLayout.setVisibility(View.VISIBLE);
                    resultTemperature.setVisibility(View.VISIBLE);
                    state = 6;
                    break;
            }
        });
    }


    @SuppressLint("ClickableViewAccessibility")
    private void showDialog() {
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.search_dialog, null);

        ohmSizesAdapter = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources()
                .getStringArray(R.array.ohm_size));


        EditText size = dialogView.findViewById(R.id.resistanceSize);
        Spinner ohmSize = dialogView.findViewById(R.id.ohmSize);
        Spinner temp = dialogView.findViewById(R.id.tempSpinner);
        Spinner toleranceSpinner = dialogView.findViewById(R.id.toleranceSpinner);
        TextView tempText = dialogView.findViewById(R.id.kk);
        Spinner bandSp = dialogView.findViewById(R.id.bandSp);

        bandSp.setAdapter(adapter);
        ohmSize.setAdapter(ohmSizesAdapter);
        toleranceSpinner.setAdapter(toleranceAdapter);
        temp.setAdapter(temperatureAdapter);

        bandSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0 || position == 1) {
                    temp.setVisibility(View.GONE);
                    tempText.setVisibility(View.GONE);
                } else {
                    tempText.setVisibility(View.VISIBLE);
                    temp.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Search Resistor")
                .setView(dialogView)
                .setPositiveButton("Search", (dialogInterface, i) -> {
                    int[] number = Calculator.test(size.getText().toString());

                    spin_band1.setSelection(number[0]-1);
                    spin_band2.setSelection(number[1]);
                    tolerance_band.setSelection(toleranceSpinner.getSelectedItemPosition());

                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();

//
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("Search Resistor");
//
//
//        Spinner ohmSize = dialogView.findViewById(R.id.ohmSize);
//        Spinner temp = dialogView.findViewById(R.id.tempSpinner);
//        Spinner toleranceSpinner = dialogView.findViewById(R.id.toleranceSpinner);
//        TextView tempText = dialogView.findViewById(R.id.kk);
//        Spinner bandSp = dialogView.findViewById(R.id.bandSp);
//
//        ohmSizesAdapter = new ArrayAdapter<>(MainActivity.this,
//                android.R.layout.simple_list_item_1, getResources()
//                .getStringArray(R.array.ohm_size));
//
//
//        bandSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0 || position == 1) {
//                    temp.setVisibility(View.GONE);
//                    tempText.setVisibility(View.GONE);
//                } else {
//                    tempText.setVisibility(View.VISIBLE);
//                    temp.setVisibility(View.VISIBLE);
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        bandSp.setAdapter(adapter);
//        ohmSize.setAdapter(ohmSizesAdapter);
//        toleranceSpinner.setAdapter(toleranceAdapter);
//        temp.setAdapter(temperatureAdapter);
//
//
//        AlertDialog dialog = builder.create();
//
//        builder.setIcon(R.drawable.resistor_4_band);
//        builder.setPositiveButton("Search", (dialog1, which) -> {
//            int[] number = Calculator.test(size.getText().toString());
//            spin_band1.setSelection(number[0]);
//            spin_band2.setSelection(number[1]);
//
//        });
//        builder.setView(dialogView);
//        dialog.show();

    }


}