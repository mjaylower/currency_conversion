package com.example.mlower.currency_conversion;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    double conversionRate = .049;
    double currencyEntered=0.0;
    double convertedCurrency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText conversion = findViewById (R.id.amount_entered);
        final RadioButton usdToPeso = findViewById(R.id.currency_usd_to_peso);
        final RadioButton pesoToUsd = findViewById(R.id.currency_peso_to_usd);
        Button convert = findViewById(R.id.btn_convert);
            convert.setOnClickListener (new View.OnClickListener (){
                final TextView result = findViewById(R.id.textResult);

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                currencyEntered = Double.parseDouble (conversion.getText().toString ());

                DecimalFormat currency = new DecimalFormat ("###,###.00");

                if (usdToPeso.isChecked ()) {
                    if (currencyEntered <= 10000.00) {
                        convertedCurrency = currencyEntered / conversionRate;
                        result.setText ("Result: " + currency.format (convertedCurrency) + " Pesos.");
                    } else {
                        Toast.makeText (MainActivity.this, "Currency must be less than $10,000.00", Toast.LENGTH_LONG).show ();
                    }
                }
                if (pesoToUsd.isChecked ()) {
                    if (currencyEntered <= 203870) {
                        convertedCurrency = conversionRate * currencyEntered;
                        result.setText ("Result: $" + currency.format (convertedCurrency) + " USD.");
                    } else {
                        Toast.makeText (MainActivity.this, "Currency must be less than 203870 Peso's", Toast.LENGTH_LONG).show ();
                    }
                }
            }
                            });
        }
    }
