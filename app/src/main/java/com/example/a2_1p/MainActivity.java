package com.example.a2_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //declaring the options for our drop down menu
    String[] spinnerOptions = {"Metres","Celsius","Kilograms"};
    //declaring all our views as global variables
    Spinner dropDownMenu;
    TextView numberForConversion;
    TextView Unit1;
    TextView Unit2;
    TextView Unit3;
    TextView Conversion1;
    TextView Conversion2;
    TextView Conversion3;
    ImageButton Temperature;
    ImageButton Weight;
    ImageButton Distance;
    //declaring the choice variable for our drop down menu
    int choice = 0;
    double number = 0;


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finding all the views by ID
        dropDownMenu = findViewById(R.id.spinner);
        numberForConversion = findViewById(R.id.NumberForConversion);
        Temperature = findViewById(R.id.Temperature);
        Weight = findViewById(R.id.Weight);
        Distance = findViewById(R.id.Distance);
        Unit1 = findViewById(R.id.Unit1);
        Unit2 = findViewById(R.id.Unit2);
        Unit3 = findViewById(R.id.Unit3);
        Conversion1 = findViewById(R.id.Conversion1);
        Conversion2 = findViewById(R.id.Conversion2);
        Conversion3 = findViewById(R.id.Conversion3);
        //setting the conversion and unit text views to an empty string
        Unit1.setText("");
        Unit2.setText("");
        Unit3.setText("");
        Conversion1.setText("");
        Conversion2.setText("");
        Conversion3.setText("");
        //setting up the decimal formatter so our values round to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        //adapter for our spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //creating all the on click listeners for our three buttons
        //using an else bracket to send a toast for our error message if the user clicks the wrong button
        //also using a try catch block to prevent the app from crashing when the user clicks a button without entering anything
        Distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (choice == 0) {
                        Unit1.setText("Centimetre");
                        Unit2.setText("Foot");
                        Unit3.setText("Inch");
                        number = Double.parseDouble(numberForConversion.getText().toString());
                        double Centimetre = number * 100;
                        double Foot = number / 0.3048;
                        double Inch = number / 0.0254;
                        Conversion1.setText(df.format(Centimetre));
                        Conversion2.setText(df.format(Foot));
                        Conversion3.setText(df.format(Inch));
                    } else {
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception NumberFormatException)
                {
                }
            }
        });
        Temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (choice == 1)
                    {
                        Unit1.setText("Fahrenheit");
                        Unit2.setText("Kelvin");
                        Unit3.setText("");
                        number = Double.parseDouble(numberForConversion.getText().toString());
                        double Fahrenheit = (number*1.8)+32;
                        double Kelvin = (number + 273.15);
                        Conversion1.setText(df.format(Fahrenheit));
                        Conversion2.setText(df.format(Kelvin));
                        Conversion3.setText("");
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception NumberFormatException)
                {
                }
            }
        });
        Weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (choice == 2)
                    {
                        Unit1.setText("Grams");
                        Unit2.setText("Ounce(Oz)");
                        Unit3.setText("Pound(lb)");
                        number = Double.parseDouble(numberForConversion.getText().toString());
                        double Grams = number*1000;
                        double Ounce = number * 35.27396194958;
                        double Pound = number * 2.2;
                        Conversion1.setText(df.format(Grams));
                        Conversion2.setText(df.format(Ounce));
                        Conversion3.setText(df.format(Pound));
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception NumberFormatException)
                {
                }
            }
        });
        dropDownMenu.setAdapter(adapter);
        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}