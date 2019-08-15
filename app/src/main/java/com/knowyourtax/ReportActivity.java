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
import com.knowyourtax.model.TaxComponentModel;

import java.util.Observable;
import java.util.Observer;

public class ReportActivity extends AppCompatActivity implements Observer {

    private EditText incomeEdit;
    private EditText basicPayEdit;
    private EditText hRAEdit;
    private CheckBox seniorCitizenChkBox;
    private CheckBox metroChkBox;
    private TableLayout salarySplitTableLayout;

    private double income;
    private double basicPay;
    private boolean seniorCitizen;
    private boolean metro;

    private TaxComponentModel taxCompModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        try{

            incomeEdit = findViewById(R.id.income);
            incomeEdit.addTextChangedListener(new MoneyText(incomeEdit));

            basicPayEdit = findViewById(R.id.basicPay);
            basicPayEdit.addTextChangedListener(new MoneyText(basicPayEdit));

            hRAEdit = findViewById(R.id.HRA);
            hRAEdit.addTextChangedListener(new MoneyText(hRAEdit));

            seniorCitizenChkBox = findViewById(R.id.seniorCitizen);
            metroChkBox = findViewById(R.id.metro);
            salarySplitTableLayout = (TableLayout) findViewById(R.id.salarySplit);

            Intent intent = getIntent();
            Log.d("ReportActivity","Report activity called");
            income = intent.getDoubleExtra("income", 0);
            basicPay = intent.getDoubleExtra("basicPay", 0);
            seniorCitizen = intent.getExtras().getBoolean("seniorCitizen");
            metro = intent.getExtras().getBoolean("metro");
            Log.d("ReportActivity","Report activity created");


            incomeEdit.setText(String.valueOf(income));
            basicPayEdit.setText(String.valueOf(basicPay));


            seniorCitizenChkBox.setChecked(seniorCitizen);
            metroChkBox.setChecked(metro);

            Bundle bundle = (Bundle) intent.getBundleExtra("bundle");
            taxCompModel = (TaxComponentModel) bundle.get("model");
            hRAEdit.setText(String.valueOf(taxCompModel.getDoubleHRAReceived()));

            populateSalarySplit(salarySplitTableLayout);

        }catch (Exception e){
            Log.e(e.getClass().getSimpleName(),"getIntFromEditText()", e);
        }

    }

    private void populateSalarySplit(TableLayout tableLayout){
       /* tableLayout.removeAllViewsInLayout();

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

        dataRow.addView(getDataView("Income Tax"));
        dataRow.addView(getDataView("100"));
        dataRow.addView(getDataView("1200"));

        tableLayout.addView(dataRow);

        final View vline1 = new View(this);
        vline1.setLayoutParams(new
                TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 1));
        vline1.setBackgroundColor(Color.WHITE);
        tableLayout.addView(vline1);  // add line below each row*/



        TableRow tableRow = (TableRow) tableLayout.getChildAt(5);
        /*TextView textView = new TextView(this);
        textView.setText(String.valueOf(income));
        tableRow.addView(textView, 2);*/
        View view = (TextView) tableRow.getChildAt(2);
        ((TextView) view).setText(String.valueOf(income));
        /*tableRow.addView(view, 2);*/

        TextView textView = null;

        textView = findViewById(R.id.basicPayMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleBasicPay()));
        textView = findViewById(R.id.basicPayYearly);
        textView.setText(String.valueOf(taxCompModel.getDoubleBasicPay()*12));

        textView = findViewById(R.id.SECVIA80CMonthly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80CMonthly()));
        textView = findViewById(R.id.SECVIA80CYearly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80CMonthly() * 12));

        textView = findViewById(R.id.SECVIA80DMonthly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80DMonthly()));
        textView = findViewById(R.id.SECVIA80DYearly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80DMonthly() * 12));

        //SECVIA80DDBSCMonthly - left unchanged
        textView = findViewById(R.id.SECVIA80DDBSCMonthly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80DDBSCMonthly()));
        textView = findViewById(R.id.SECVIA80DDBSCYearly);
        textView.setText(String.valueOf(taxCompModel.getSECVIA80DDBSCMonthly() * 12));

        //U/S 10
        textView = findViewById(R.id.US10sMonthly);
        textView.setText(String.valueOf(taxCompModel.getUS10sMonthly()));
        textView = findViewById(R.id.US10sYearly);
        textView.setText(String.valueOf(taxCompModel.getUS10sMonthly() * 12));

        //Gratuity
        textView = findViewById(R.id.gratuityMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleGratuity()));
        textView = findViewById(R.id.gratuityYearly);
        textView.setText(String.valueOf(taxCompModel.getDoubleGratuity() * 12));

        //Tel & Med Reimburse
        textView = findViewById(R.id.telMedreimbMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleTelMedReimbursement()));
        textView = findViewById(R.id.telMedreimbYearly);
        textView.setText(String.valueOf(taxCompModel.getDoubleTelMedReimbursement() * 12));

        //Prof tax
        /*textView = findViewById(R.id.profTaxMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleProfTax()));
        textView = findViewById(R.id.profTaxYearly);
        textView.setText(String.valueOf(taxCompModel.getDoubleProfTax() * 12));*/

        //Nettaxable
        textView = findViewById(R.id.netTaxMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleNetTaxableAmt()));
        textView = findViewById(R.id.netTaxMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleNetTaxableAmt() * 12));

        //TaxPayable
        textView = findViewById(R.id.taxPayableMonthly);
        textView.setText(String.valueOf(taxCompModel.getDoubleTaxPayable()));
        textView = findViewById(R.id.taxPayableYearly);
        textView.setText(String.valueOf(taxCompModel.getDoubleTaxPayable() * 12));

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

    @Override
    public void update(Observable observable, Object o) {
        //this.onCreate();
        incomeEdit.setText("10,001");

    }
}
