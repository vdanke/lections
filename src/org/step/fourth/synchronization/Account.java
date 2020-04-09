package org.step.fourth.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account extends Thread {

    @Override
    public void run() {
        super.run();
    }

    /*
        Можно использовать volatile переменную
         */
    private int balance;
    /*
    Создаем Lock для захвата ресурсов на трансфер
     */
    private Lock lock;

    public Account(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }
}
