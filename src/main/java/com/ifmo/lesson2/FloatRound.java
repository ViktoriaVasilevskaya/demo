package com.ifmo.lesson2;

public class FloatRound {
    /*
    В переменной n хранится вещественное число с ненулевой дробной частью.
    Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
     */
    public static void main(String[] args) {
        float n = 8.7F;

        float rounded = round(n);

        System.out.println(rounded);
    }

    public static float round(float n) {
        int round = Math.round(n);
        return round;
    }
}
