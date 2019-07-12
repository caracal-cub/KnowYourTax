package com.knowyourtax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ReportActivity extends AppCompatActivity {

    private int income;
    private int basicPay;
    private boolean seniorCitizen;
    private boolean metro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Intent intent = getIntent();
        income = Integer.parseInt(intent.getStringExtra("income"));
        basicPay = Integer.parseInt(intent.getStringExtra("basicPay"));
        seniorCitizen = intent.getExtras().getBoolean("seniorCitizen");
        metro = intent.getExtras().getBoolean("metro");

    }
}
