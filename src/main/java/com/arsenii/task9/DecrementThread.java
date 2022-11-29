package com.arsenii.task9;

import static com.arsenii.task9.BankConstants.MAX_VALUE;
import static com.arsenii.task9.BankConstants.MIN_VALUE;

public class DecrementThread implements Runnable {
    private final Bank bank;

    public DecrementThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        synchronized (bank) {
            for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
                bank.setAccount(bank.getAccount() - 1);
            }
            System.out.println("Decrement thread: " + bank.getAccount());
        }
    }
}
