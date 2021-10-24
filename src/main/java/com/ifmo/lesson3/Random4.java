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
        boolean k = isIncreasingSequence(randomNumbers);
        System.out.println(k);

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
        boolean n = true;
        for (int i = 1; i <= randomNumbers().length; i++) {
            if (randomNumbers[i-1] >= randomNumbers[i]) {
                n = false;
                break;
            }else{
                n = true;
            }
        }return n;
    }
}
