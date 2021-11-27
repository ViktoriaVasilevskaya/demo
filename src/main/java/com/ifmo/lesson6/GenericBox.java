package com.ifmo.lesson6;

public class GenericBox<T>{ //тип Т
    private T value;
    public GenericBox(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


}
