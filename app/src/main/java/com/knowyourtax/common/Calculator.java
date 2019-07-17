package com.knowyourtax.common;

public class Calculator {

    private double income;
    private double basicPay;
    private int monthlyTax;
    private int yearlyTax;

    public static double getBasicPayFromIncome(double income){
        if(income >0){
            return income/48;
        }else{
            return 0;
        }
    }


}
