package com.ifmo.lesson5;

public class Oval extends Circle{
    protected double b;

    public Oval (double a, double b){
        super(a);
        this.b = b;
    }
    @Override
    public double area() {
        return Math.PI * a * b;
    }
}
