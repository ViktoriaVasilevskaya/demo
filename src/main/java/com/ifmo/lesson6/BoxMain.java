package com.ifmo.lesson6;

public class BoxMain {
    public static void main (String [] args){
        Box box1 = new Box("string");
        Box box2 = new Box (10.9);

        String myString = (String) box1.getValue(); // скобки позволяют привести более широкий тип к узкому

        GenericBox<String> stringBox = new GenericBox<String>("my string");
        GenericBox<Integer> intBox = new GenericBox<Integer>(10050);
        GenericBox<Double> dblBox = new GenericBox<Double>(100.0);
        String v = stringBox.getValue();
        int i = intBox.getValue();


    }
    private static void printValue(GenericBox<? extends Number>box){ //

    }
    private static void printValue(Number n){

    }
}
