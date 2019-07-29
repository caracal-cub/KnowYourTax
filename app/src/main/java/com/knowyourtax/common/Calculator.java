package com.knowyourtax.common;

public class Calculator {

    private double income;
    private double basicPay;
    private double incomeTax;
    private double profTax;
    private double gratuity;
    private double providentFund;
    private double EPF_EPS;
    private double medicalBills;
    private double conveyance;
    private double HRA;
    private double otherDeductions;
    private double medicalInsurance;

    public double getMedicalInsurance() {
        return medicalInsurance;
    }

    public void setMedicalInsurance(double medicalInsurance) {
        this.medicalInsurance = medicalInsurance;
    }

    public double getTaxSavingInvestments() {
        return taxSavingInvestments;
    }

    public void setTaxSavingInvestments(double taxSavingInvestments) {
        this.taxSavingInvestments = taxSavingInvestments;
    }

    private double taxSavingInvestments;

    public double getMedicalBills() {
        return medicalBills;
    }

    public void setMedicalBills(double medicalBills) {
        this.medicalBills = medicalBills;
    }

    public double getConveyance() {
        return conveyance;
    }

    public void setConveyance(double conveyance) {
        this.conveyance = conveyance;
    }

    public double getHRA() {
        return HRA;
    }

    public void setHRA(double HRA) {
        this.HRA = HRA;
    }

    public double getOtherDeductions() {
        return otherDeductions;
    }

    public void setOtherDeductions(double otherDeductions) {
        this.otherDeductions = otherDeductions;
    }


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

    public void resetCalculations(){
        profTax = 0;
        gratuity= 0;
    }

    public double getTaxableIncome(){
        double taxableIncome = 0;
        taxableIncome = getGrossSalary() - getProvidentFund() - getConveyance() - getHRA()
                - getProfTax() - getMedicalBills() - getMedicalInsurance() - getTaxSavingInvestments() - getOtherDeductions();
        return taxableIncome;
    }

    public double getGrossSalary(){
        double grossSalary = 0;
        grossSalary = getIncome() - getEPF_EPS() - getGratuity();
        return grossSalary;
    }

}
