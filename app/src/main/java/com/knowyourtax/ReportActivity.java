package com.knowyourtax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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
        Log.d("ReportActivity","Report activity called");
//        income = Integer.parseInt(intent.getStringExtra("income"));
//        basicPay = Integer.parseInt(intent.getStringExtra("basicPay"));
//        seniorCitizen = intent.getExtras().getBoolean("seniorCitizen");
//        metro = intent.getExtras().getBoolean("metro");
        Log.d("ReportActivity","Report activity created");
    }
}
