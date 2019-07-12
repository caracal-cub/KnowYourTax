package com.knowyourtax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText income;
    private EditText basicPay;
    private CheckBox seniorCitizen;
    private CheckBox metro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        income = findViewById(R.id.income);
        basicPay = findViewById(R.id.basicPay);
        seniorCitizen = findViewById(R.id.seniorCitizen);
        metro = findViewById(R.id.metro);

    }

    public void runCalculation(View view){
        Log.d("MainActivity", "Calculation Button clicked!");
        Intent intent = new Intent(this, ReportActivity.class);
        intent.putExtra("income",income.getText());
        intent.putExtra("basicPay", income.getText());
        intent.putExtra("seniorCitizen",seniorCitizen.isChecked());
        intent.putExtra("metro",metro.isChecked());
        startActivity(intent);
    }
}
