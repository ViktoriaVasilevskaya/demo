package com.ifmo.lesson3;

import java.util.Random;
import java.util.Arrays;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        System.out.println(Arrays.toString(randomNumbers));
        //System.out.println(isIncreasingSequence);

    }

    public static int[] randomNumbers() {
        int[] arr = new int[4];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(89) + 10;
        }
        return arr;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        for (int i = 0; i < 4; i++) {
            if (randomNumbers[i] >= randomNumbers[i + 1]) {
                System.out.println("Массив не возрастающий");
                break;
                if (randomNumbers[i] >= randomNumbers[i + 1]) {
                    System.out.println("Массив не строго возрастающий");
                }
            }
        }
    } return false;
}
