package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;
public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers));

        int[] replacedWithZeros = replaceWithZeros(randomNumbers);

        System.out.println(Arrays.toString(replacedWithZeros));
    }

    public static int[] randomNumbers() {
        int [] arr = new int [8];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr [i] = random.nextInt(9)+1;
        }
        return arr;
    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        for (int i = 0; i < randomNumbers.length; i++) {
            if (i % 2 != 0){
                randomNumbers [i] = 0;
            }
        }
        return randomNumbers;
    }
}
