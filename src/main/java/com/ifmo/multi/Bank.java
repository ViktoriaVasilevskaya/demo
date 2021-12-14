package com.ifmo.multi;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank implements Runnable {

    //создать конструктор
    //создать и запустить поток

    public void transferMoney (long srcAccId, long dstAccId, double amount){
        try{
            if(accMap.get(srcAccId).getAmount() != 0){
                double previousScr = accMap.get(srcAccId).getAmount();
                double previousDst = accMap.get(dstAccId).getAmount();
                accMap.put(srcAccId, accMap.get(srcAccId).setAmount(previousScr - amount));
                accMap.put(dstAccId, accMap.get(dstAccId).setAmount(previousDst + amount));
            }
        }catch (RuntimeException e){
            System.out.println("We caught RuntimeException here: " + e.getMessage());
        }
    }

    private ConcurrentMap<Long, Account<>> accMap = new ConcurrentHashMap<>() {
    };
    @Override
    public void run() {
        //если счета не заблокированы, произвести перевод, иначе выдать сообщение о состоянии счетов
    }
}
