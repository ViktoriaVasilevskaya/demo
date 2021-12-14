package com.ifmo.multi;

public class MainBank {
    static Bank bank;

    public static void main (String [] args) throws InterruptedException {
        bank = new Bank();
        Thread new_thread = new Thread(bank);
        new_thread.start();
        new_thread.join();
        System.out.println("Перевод выполнен");
    }


}
