package com.ifmo.multi;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {
    private ConcurrentMap<Long, Account> accMap = new ConcurrentHashMap<Long, Account>();
    private final AtomicLong atomicLong = new AtomicLong(1);


    public Account CreateAccount() {
        Account new_Acc = accMap.get(atomicLong.longValue());
        if (new_Acc == null) {
            new_Acc = new Account(1L, 100, atomicLong.getAndIncrement(), false);
            accMap.put(new_Acc.getUserId(), new_Acc);
        }
        return new_Acc;
    }

    public double getAmount(long accId) {
        double current_amount = accMap.get(accId).getAmount();
        return current_amount;
    }

    public void blockAccount(long accId) {
        boolean state = isAccounBlocked(accId);
        if (state == false) {
            accMap.get(accId).setBlocked(true);
            System.out.println("blocked successfully");
        } else {
            System.out.println("This account is already blocked");
        }
    }

    public void unblockAccount(long accId) {
        boolean state = isAccounBlocked(accId);
        if (state == true) {
            accMap.get(accId).setBlocked(false);
            System.out.println("unblocked successfully");
        } else {
            System.out.println("This account is already unblocked");
        }
    }

    public boolean isAccounBlocked(long accId) {
        boolean isBlocked = accMap.get(accId).isBlocked();
        return isBlocked;
    }

    public void ChangeAmount(long accId, double amount) {
        double current_amount = getAmount(accId);
        double new_amount = current_amount + amount;
        accMap.get(accId).setAmount(new_amount);
    }

    public void transferMoney(long srcAccId, long dstAccId, double amount) {
        try {
            synchronized (accMap.get(srcAccId)) {
                if (!isAccounBlocked(srcAccId) && !isAccounBlocked(dstAccId)) {
                    if (getAmount(srcAccId) >= amount) {
                        double new_srcAmount = getAmount(srcAccId) - amount;
                        double new_dstAmount = getAmount(dstAccId) + amount;
                        accMap.get(srcAccId).setAmount(new_srcAmount);
                        ChangeAmount(dstAccId, amount);
                    } else {
                        System.out.println("account has insufficient funds!");
                    }
                } else {
                    System.out.println("BLOCKED! transfer is not available!");
                }
            }

        } catch (RuntimeException e) {
            System.out.println("We caught RuntimeException here: " + e.getMessage());
        }
    }
}
