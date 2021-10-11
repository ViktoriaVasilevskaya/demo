package com.ifmo.lesson2;

import java.util.Scanner;

public class DigitsSum {
    /*
    Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
    его цифр (заранее не известно сколько цифр будет в числе).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int digitSum = digitSum(k);

        System.out.println(digitSum);
    }

    public static int digitSum(int k) {
        int sum = 0;
        while (k != 0) {
            sum += (k % 10);
            k /= 10;
        }

        return sum;
    }
}

