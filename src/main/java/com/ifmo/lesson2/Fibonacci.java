package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        int x = 1, y = 1, z = 0;
        System.out.println (x);
        System.out.println (y);
        for (int i = 3; i < 11; i++) {
            z = x + y;
            x = y;
            y = z;
            System.out.println(z + "");
        }
    }
}
