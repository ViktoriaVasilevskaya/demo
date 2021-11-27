package com.ifmo.lesson10;

public class TransformerMain {
    public static void main (String [] args){
        Integer input = 100;
        Transformer<Integer, String> transformer = new IntegerToStringTransformer() ;


        String output = transformer.transform(input);

        System.out.println(output);

    }
}
