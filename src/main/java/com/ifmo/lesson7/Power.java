package com.ifmo.lesson7;

public class Power implements Operation{
    @Override
    public int calculate(int a, int b){return (int) Math.pow(a,b);}
}
