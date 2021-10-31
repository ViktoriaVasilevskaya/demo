package com.ifmo.lesson5;

public class Triangle extends Shape{
    protected double a;
    protected double h;

    public Triangle(double a, double h){
        this.a = a;
        this.h = h;
    }
    @Override
    public double area() {
        return 0.5 * a * h;
    }
}
