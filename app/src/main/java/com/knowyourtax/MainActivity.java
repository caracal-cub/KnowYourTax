package com.knowyourtax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.knowyourtax.common.MoneyText;

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
        income.addTextChangedListener(new MoneyText(income));

        basicPay = findViewById(R.id.basicPay);
        basicPay.addTextChangedListener(new MoneyText(basicPay));

        seniorCitizen = findViewById(R.id.seniorCitizen);
        metro = findViewById(R.id.metro);

    }

    public void runCalculation(View view){
        Log.d("MainActivity", "Calculation Button clicked!");
        if(TextUtils.isEmpty(income.getText())){
            Toast toast=Toast.makeText(getApplicationContext(),"Fill income",Toast.LENGTH_SHORT);
            toast.show();
        }else if(TextUtils.isEmpty(basicPay.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(), "Fill Basic pay", Toast.LENGTH_SHORT);
            toast.show();
        }else {

            Intent intent = new Intent(this, ReportActivity.class);
            intent.putExtra("income", getIntFromEditText(income));
            intent.putExtra("basicPay", getIntFromEditText(basicPay));
            intent.putExtra("seniorCitizen", seniorCitizen.isChecked());
            intent.putExtra("metro", metro.isChecked());
            startActivity(intent);
        }
    }

    public int getIntFromEditText(EditText editText){

        int outInt = 0;

        try{
            String inpStr = editText.getText().toString();
            inpStr = inpStr.replace(",","");
            outInt = Integer.parseInt(inpStr);

        }catch (Exception e){
            Log.e(e.getClass().getSimpleName(),"getIntFromEditText()", e);
        }

        return outInt;
    }
}
