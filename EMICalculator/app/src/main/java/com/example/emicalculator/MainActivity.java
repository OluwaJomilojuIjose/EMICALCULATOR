package com.example.emicalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText mortgageAmount = findViewById(R.id.etMortgageAmount);
        EditText interestRate = findViewById(R.id.etInterestRate);
        EditText tenure = findViewById(R.id.etTenure);
        Button calculateButton = findViewById(R.id.btnCalculate);
        TextView result = findViewById(R.id.tvResult);

        calculateButton.setOnClickListener(v -> {
            double P = Double.parseDouble(mortgageAmount.getText().toString());
            double annualRate = Double.parseDouble(interestRate.getText().toString());
            int n = Integer.parseInt(tenure.getText().toString());

            double r = (annualRate / 100) / 12;
            double EMI = (P * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);

            result.setText("Your monthly EMI is: " + String.format("%.2f", EMI));
        });
    }
}
