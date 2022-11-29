package com.arsenii.task9;

import static com.arsenii.task9.BankConstants.MAX_VALUE;
import static com.arsenii.task9.BankConstants.MIN_VALUE;

public class IncrementThread implements Runnable {
    private final Bank bank;

    public IncrementThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        synchronized (bank) {
            for (int i = MIN_VALUE; i < MAX_VALUE; i++) {
                bank.setAccount(bank.getAccount() + 2);
            }
            System.out.println("Increment thread: " + bank.getAccount());
        }
    }
}
