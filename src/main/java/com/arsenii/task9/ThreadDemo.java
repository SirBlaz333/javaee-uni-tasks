package com.arsenii.task9;

public class ThreadDemo {
    public static void main(String[] args) {
        final Bank bank = new Bank(0);
        IncrementThread incrementThread = new IncrementThread(bank);
        DecrementThread decrementThread = new DecrementThread(bank);
        Thread inc = new Thread(incrementThread);
        Thread dec = new Thread(decrementThread);
        inc.start();
        dec.start();
    }
}
