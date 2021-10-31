package com.ifmo.lesson5;

public class Rectangle extends Square{
    protected double b;

    public Rectangle (double a, double b){
        super (a);
        this.b = b;
    }
    @Override
    public double area(){
        return a * b;
    }
}
