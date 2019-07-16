package com.knowyourtax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.knowyourtax.common.MoneyText;

public class ReportActivity extends AppCompatActivity {

    private EditText incomeEdit;
    private EditText basicPayEdit;
    private CheckBox seniorCitizenChkBox;
    private CheckBox metroChkBox;
    private TableLayout salarySplitTableLayout;

    private int income;
    private int basicPay;
    private boolean seniorCitizen;
    private boolean metro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        try{

            incomeEdit = findViewById(R.id.income);
            incomeEdit.addTextChangedListener(new MoneyText(incomeEdit));

            basicPayEdit = findViewById(R.id.basicPay);
            basicPayEdit.addTextChangedListener(new MoneyText(basicPayEdit));

            seniorCitizenChkBox = findViewById(R.id.seniorCitizen);
            metroChkBox = findViewById(R.id.metro);
            salarySplitTableLayout = (TableLayout) findViewById(R.id.salarySplit);

            Intent intent = getIntent();
            Log.d("ReportActivity","Report activity called");
            income = intent.getIntExtra("income", 0);
            basicPay = intent.getIntExtra("basicPay", 0);
            seniorCitizen = intent.getExtras().getBoolean("seniorCitizen");
            metro = intent.getExtras().getBoolean("metro");
            Log.d("ReportActivity","Report activity created");


            incomeEdit.setText(String.valueOf(income));
            basicPayEdit.setText(String.valueOf(basicPay));
            seniorCitizenChkBox.setChecked(seniorCitizen);
            metroChkBox.setChecked(metro);

            populateSalarySplit(salarySplitTableLayout);

        }catch (Exception e){
            Log.e(e.getClass().getSimpleName(),"getIntFromEditText()", e);
        }

    }

    private void populateSalarySplit(TableLayout tableLayout){
        tableLayout.removeAllViewsInLayout();

        TableRow headerRow = new TableRow(this);

        headerRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        headerRow.addView(getHeaderView("Component"));
        headerRow.addView(getHeaderView("Monthly"));
        headerRow.addView(getHeaderView("Yearly"));

        tableLayout.addView(headerRow);

        final View vline = new View(this);
        vline.setLayoutParams(new
                TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
        vline.setBackgroundColor(Color.BLUE);
        tableLayout.addView(vline); // add line below heading


        TableRow dataRow = new TableRow(this);

        dataRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        dataRow.addView(getHeaderView("Income Tax"));
        dataRow.addView(getHeaderView("100"));
        dataRow.addView(getHeaderView("1200"));

        tableLayout.addView(dataRow);

        final View vline1 = new View(this);
        vline1.setLayoutParams(new
                TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        vline1.setBackgroundColor(Color.WHITE);
        tableLayout.addView(vline1);  // add line below each row

    }

    private View getHeaderView(String headerText){
        TextView textView = new TextView(this);
        textView.setText(headerText);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(15);
        return textView;
    }

    private View getDataView(String dataText){
        TextView textView =new TextView(this);
        textView.setText(dataText);
        textView.setTextColor(Color.RED);
        textView.setTextSize(15);
        return textView;
    }
}
