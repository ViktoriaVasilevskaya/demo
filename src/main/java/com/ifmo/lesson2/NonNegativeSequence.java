package com.ifmo.lesson2;

public class NonNegativeSequence {
    /*
    Создайте программу, выводящую на экран все неотрицательные элементы
    последовательности 90 85 80 75 70 65 60 ….
     */
    public static void main(String[] args) {
        int k = 90;
        System.out.println(k);
        while(k != 0){
            k -= 5;
            System.out.println(k);
        }
    }
}
