package com.ifmo.lesson2;

import java.util.Scanner;

public class Factorial {
    /*
     Создайте программу, вычисляющую факториал натурального числа n, которое
     пользователь введёт с клавиатуры.
     */
    public static void main(String[] args) {
        System.out.println("Введие число");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {

            int n = scanner.nextInt();

            long factorial = factorial(n);

            System.out.println(factorial);
        } else {
            System.out.println ("Ошибка");
        }
    }

    public static long factorial(int n) {
        long x = 1;
            for (int i = n; i > 0; i--) {
                x *= i;
            }
            return x;

        
    }
}
