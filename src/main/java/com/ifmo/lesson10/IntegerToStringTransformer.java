package com.ifmo.lesson10;

public class IntegerToStringTransformer implements Transformer<Integer, String>{

    @Override
    public String transform(Integer integer) {
        return String.valueOf(integer);
    }
}
