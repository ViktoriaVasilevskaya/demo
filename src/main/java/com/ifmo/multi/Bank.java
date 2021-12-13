package com.ifmo.multi;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank implements Runnable {
    public static void main(String [] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable()){
            @Override
            public void run() {


        });
        thread.start();
        thread.join();
    }

    public void transferMoney (long srcAccId, long dstAccId, double amount){
        try{
            if(accMap.get(srcAccId) != null){
                double previousScr = accMap.get(srcAccId);
                double previousDst = accMap.get(dstAccId);
                accMap.put(srcAccId, previousScr - amount);
                accMap.put(dstAccId, previousDst + amount);

            }
            catch (RuntimeException e){
                System.out.println("We caught RuntimeException here: " + e.getMessage());

            }
        }

    }

    private ConcurrentMap<Long, Account<>> accMap = new ConcurrentHashMap<>() {
    };


}
