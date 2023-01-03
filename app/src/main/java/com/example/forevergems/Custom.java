package com.example.forevergems;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Bundle;

public class Custom extends AppCompatActivity {
    private EditText basePriceInput;
    private EditText materialFactorInput;
    private EditText quantityFactorInput;
    private TextView priceOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        basePriceInput = findViewById(R.id.base_price_input);
        materialFactorInput = findViewById(R.id.material_factor_input);
        quantityFactorInput = findViewById(R.id.color_factor_input);
        priceOutput = findViewById(R.id.price_output);
        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double basePrice = Double.parseDouble(basePriceInput.getText().toString());
                double materialFactor = Double.parseDouble(materialFactorInput.getText().toString());
                double quantityFactor = Double.parseDouble(quantityFactorInput.getText().toString());
                double price = basePrice * materialFactor * quantityFactor;
                priceOutput.setText(String.format("Price: ₱%.2f", price));
            }
        });
        Button resetButton = findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basePriceInput.setText("");
                materialFactorInput.setText("");
                quantityFactorInput.setText("");
                priceOutput.setText("Price: ₱0.00");
            }
        });
    }
}