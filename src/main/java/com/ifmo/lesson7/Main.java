package com.ifmo.lesson7;

import java.lang.module.ModuleFinder;

public class Main {

    public static void main(String[] args) {
     Accumulator acc = new Accumulator(0, new Plus());
     acc.accumulate (2);
     acc.accumulate(5);
     acc.getValue();

     Accumulator acc1 = new Accumulator(0, new Minus());
     acc1.accumulate (2);
     acc1.accumulate(5);
     acc1.getValue();

     Accumulator acc2 = new Accumulator(1, new Multiply());
     acc2.accumulate (2);
     acc2.accumulate(5);
     acc2.getValue();

     Accumulator acc3 = new Accumulator(1,new Divide());
     acc3.accumulate(2);
     acc3.accumulate(6);
     acc3.getValue();

     Accumulator acc4 = new Accumulator(2,new Mod());
     acc4.accumulate(3);
     acc4.accumulate(5);
     acc4.getValue();

     Accumulator acc5 = new Accumulator(1,new Power());
     acc5.accumulate(2);
     acc5.accumulate(6);
     acc5.getValue();

     Accumulator acc6 = new Accumulator(1,new SquareRoot());
     acc6.accumulate(2);
     acc6.accumulate(6);
     acc6.getValue();
         }
}
