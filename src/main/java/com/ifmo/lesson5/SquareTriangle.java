package com.ifmo.lesson5;

public class SquareTriangle extends Triangle{
    public SquareTriangle(double a, double h) {
        super(a, h);
    }
    @Override
    public double area(){return 0.5 * a * h;}
}
