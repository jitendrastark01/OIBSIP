package com.example.unit_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputValue = findViewById(R.id.inputValue);
        Spinner fromUnit = findViewById(R.id.fromUnit);
        Spinner toUnit = findViewById(R.id.toUnit);
        Button convertButton = findViewById(R.id.convertButton);
        TextView resultView = findViewById(R.id.resultView);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = fromUnit.getSelectedItem().toString();
                String to = toUnit.getSelectedItem().toString();
                double input = Double.parseDouble(inputValue.getText().toString());
                double result = convertUnits(input, from, to);
                resultView.setText(String.valueOf(result));
            }
        });
    }

    private double convertUnits(double input, String from, String to) {
        switch (from) {
            case "Centimeters":
                if (to.equals("Meters")) return input / 100;
                break;
            case "Meters":
                if (to.equals("Centimeters")) return input * 100;
                break;
            case "Grams":
                if (to.equals("Kilograms")) return input / 1000;
                break;
            case "Kilograms":
                if (to.equals("Grams")) return input * 1000;
                break;
        }
        return input; // Default case (no conversion)
    }
}
