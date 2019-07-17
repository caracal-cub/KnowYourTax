package com.knowyourtax.common;

public class Calculator {

    private double income;
    private double basicPay;
    private double incomeTax;
    private double profTax;
    private double gratuity;
    private double providentFund;
    private double EPF_EPS;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public double getProfTax() {
        return profTax;
    }

    public void setProfTax(double profTax) {
        this.profTax = profTax;
    }

    public double getGratuity() {
        return gratuity;
    }

    public void setGratuity(double gratuity) {
        this.gratuity = gratuity;
    }

    public double getProvidentFund() {
        return providentFund;
    }

    public void setProvidentFund(double providentFund) {
        this.providentFund = providentFund;
    }

    public double getEPF_EPS() {
        return EPF_EPS;
    }

    public void setEPF_EPS(double EPF_EPS) {
        this.EPF_EPS = EPF_EPS;
    }

    public static double getBasicPayFromIncome(double income){
        if(income >0){
            return income/48;
        }else{
            return 0;
        }
    }


}
