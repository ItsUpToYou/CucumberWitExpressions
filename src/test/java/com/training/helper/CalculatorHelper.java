package com.training.helper;


public class CalculatorHelper {

    public int sum(int a, int b) {
        return a + b;
    }

    public double sum(double a, double b) {
        return a + b;
    }



    public <T extends Number>T sum(T x, T y) {
        if (x instanceof Double) {
            return (T)  (Double)(x.doubleValue() + y.doubleValue());
        } else if (x instanceof Integer) {
            return (T) (Integer) (x.intValue() + y.intValue());
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }



}
