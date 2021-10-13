package com.ifmo.lesson2;

import java.util.Scanner;

public class Dividers {
    /*
    Выведите на экран все положительные делители натурального числа, введённого
    пользователем с клавиатуры.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//
        int k = scanner.nextInt();
        for (int i = 1; i <= k; i++) {
            int x = k % i;
            if (x == 0) {
                System.out.println(i + "");
            }

        }

    }
}
