package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;
public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();

        System.out.println(Arrays.toString (randomNumbers1));
        System.out.println(Arrays.toString (randomNumbers2));

        int average1 = average(randomNumbers1);

        int average2 = average(randomNumbers2);

        if(average1 > average2){
            System.out.println("Среднее арифметическое первого массива больше");
        }else if (average1 < average2){
            System.out.println("Среднее арифметическое второго массива больше");
        }else{
            System.out.println("Средние арифметические двух массивов равны");
        }
    }

    public static int[] randomNumbers() {
        int [] arr = new int [5];

        Random random = new Random();
        for (int i = 0; i < 5 ; i++) {
            arr [i] = random.nextInt(6);
        }
        return arr;
    }

    public static int average(int[] randomNumbers) {
        int k = 0;
        for (int randomNumber: randomNumbers) {
            k = k +  randomNumber;
        }
        return k / 5;
    }
}
