package com.ifmo.lesson3;
import java.util.Arrays;
import java.util.Random;
public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers));

        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);

        System.out.println(max);
        System.out.println(maxLastIndex);

    }

    public static int[] randomNumbers() {
        int [] arr = new int [12];
        Random random = new Random ();
        for (int i = 0; i < arr.length ; i++) {
            arr [i] = random.nextInt(30)-15;
        }
        return arr;
    }

    public static int max(int[] randomNumbers) {
        int max = randomNumbers[0];
        for (int i:randomNumbers) {
            if (i > max){
                max = i;
            }
        } return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        int k = 0;
        for (int i = 0; i < randomNumbers.length; i++) {
            if(randomNumbers [i] == max){
                return k = i;
            }
        }
        return k;
    }
}
