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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText incomeEdit;
    private EditText basicPayEdit;
    private CheckBox seniorCitizenChkBox;
    private CheckBox metroChkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeEdit = getIncomeEditText();
        basicPayEdit = getBasicPayEditText();

        seniorCitizenChkBox = findViewById(R.id.seniorCitizen);
        metroChkBox = findViewById(R.id.metro);
    }

    private EditText getIncomeEditText(){
        EditText editText = findViewById(R.id.income);
        editText.addTextChangedListener(new MoneyText(editText));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus){
                    double value = getDoubleFromEditText(incomeEdit);
                    if(value > 0){
                        Log.e(this.getClass().getSimpleName(), "formatting value " + value);

                        double dValue = new BigDecimal(value/48).setScale(3, RoundingMode.HALF_UP).doubleValue();
                        basicPayEdit.setText(Double.toString(dValue));
                    }else{
                        basicPayEdit.setText(Double.toString(0));
                    }
                }
            }
        });

        return editText;
    }

    private EditText getBasicPayEditText(){
        EditText editText = findViewById(R.id.basicPay);
        editText.addTextChangedListener(new MoneyText(editText));
        return editText;
    }

    public void runCalculation(View view){
        Log.d("MainActivity", "Calculation Button clicked!");
        if(TextUtils.isEmpty(incomeEdit.getText())){
            Toast toast=Toast.makeText(getApplicationContext(),"Fill income",Toast.LENGTH_SHORT);
            toast.show();
        }else if(TextUtils.isEmpty(basicPayEdit.getText())) {
            Toast toast = Toast.makeText(getApplicationContext(), "Fill Basic pay", Toast.LENGTH_SHORT);
            toast.show();
        }else {

            Intent intent = new Intent(this, ReportActivity.class);
            intent.putExtra("income", getDoubleFromEditText(incomeEdit));
            intent.putExtra("basicPay", getDoubleFromEditText(basicPayEdit));
            intent.putExtra("seniorCitizen", seniorCitizenChkBox.isChecked());
            intent.putExtra("metro", metroChkBox.isChecked());
            startActivity(intent);
        }
    }

    public double getDoubleFromEditText(EditText editText){

        double outDouble = 0;

        try{
            String inpStr = editText.getText().toString();
            inpStr = inpStr.replace(",","");
            outDouble = Double.parseDouble(inpStr);

        }catch (Exception e){
            Log.e(e.getClass().getSimpleName(),"getIntFromEditText()", e);
        }

        return outDouble;
    }

}
