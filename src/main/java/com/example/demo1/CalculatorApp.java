package com.example.demo1;

public class CalculatorApp {

    public double add(double i1,double i2){
        return i1+i2 ;
    }

    public double multiply(double i1,double i2){
        return i1*i2 ;
    }

    public double divide(double i1,double i2){
        if (i1 > i2 && i2!=0)
            return i1/i2 ;
        else if (i2 >= i1 && i1!=0) {
            return i2/i1;
        }
        else {
            return 0;
        }
    }

    public double substract(double i1,double i2){
        if (i1 > i2)
            return i1-i2 ;
        else {
            return i2-i1;
        }
    }
}
