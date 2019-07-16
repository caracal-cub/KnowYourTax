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

    private EditText incomeEdit;
    private EditText basicPayEdit;
    private CheckBox seniorCitizenChkBox;
    private CheckBox metroChkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incomeEdit = findViewById(R.id.income);
        incomeEdit.addTextChangedListener(new MoneyText(incomeEdit));

        basicPayEdit = findViewById(R.id.basicPay);
        basicPayEdit.addTextChangedListener(new MoneyText(basicPayEdit));

        seniorCitizenChkBox = findViewById(R.id.seniorCitizen);
        metroChkBox = findViewById(R.id.metro);

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
            intent.putExtra("income", getIntFromEditText(incomeEdit));
            intent.putExtra("basicPay", getIntFromEditText(basicPayEdit));
            intent.putExtra("seniorCitizen", seniorCitizenChkBox.isChecked());
            intent.putExtra("metro", metroChkBox.isChecked());
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
