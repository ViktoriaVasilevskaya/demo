package com.ifmo.lesson3;

import java.util.Arrays;
public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();

        System.out.println (Arrays.toString(unevenArray));

        for (int i = unevenArray.length; i >= 0 ; i--) {
            System.out.print(unevenArray[i]);
        }
    }

    public static int[] unevenArray() {
        int n = 0;
        for (int i = 1; i <= 99; i++) {
            if (i % 2 != 0){
                n++;
            }
        }
        int [] arr = new int [n];
        for (int i = 1; i <= 99; i++) {
            int k = 0;
            if (i % 2 != 0){
                arr [k] = i;
                k++;
            }
        }
        return arr;
    }
}
