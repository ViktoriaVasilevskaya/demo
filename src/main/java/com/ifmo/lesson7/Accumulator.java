package com.ifmo.lesson7;

public class Accumulator {
    private int value;
    private Operation op;

    public Accumulator(int startValue, Operation op) {
        this.value = startValue;
        this.op = op;
    }

    public void accumulate(int a) {
        value = op.calculate(a, value);

    }

    public int getValue() {
        return value;
    }

}
