package com.ifmo.lesson3;

import java.util.Random;
import java.util.Arrays;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers));

        int evens = evens(randomNumbers);
        System.out.println(evens);
    }

    public static int[] randomNumbers() {
        int [] arr = new int [15];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr [i] = random.nextInt(9);
        }
        return arr;
    }

    private static int evens(int[] arr) {
        int n = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                n++;
            }
        }
        return n;
    }
}
