package com.ifmo.lesson5;

public class Circle extends Shape{
    protected double a;

    public Circle(double a){this.a = a; }

    @Override
    public double area() {
        return Math.PI * a * a;
    }
}
