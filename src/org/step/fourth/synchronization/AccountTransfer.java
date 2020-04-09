package org.step.fourth.synchronization;

import org.step.fourth.synchronization.exceptions.InsufficientFundsException;
import org.step.fourth.synchronization.exceptions.LockWaitingException;

import java.util.concurrent.TimeUnit;

public class AccountTransfer {

    private static final int WAIT_SEC = 1;

    public static void transfer(Account firstAccount, Account secondAccount, int amount) throws InterruptedException {
        if (firstAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Not enough money");
        }
        /*
        Возможно получить DeadLock
         */
//        synchronized (firstAccount) {
//            Thread.sleep(100);
//            synchronized (secondAccount) {
//                firstAccount.withdraw(amount);
//                secondAccount.deposit(amount);
//            }
//        }
        if (firstAccount.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (secondAccount.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        firstAccount.withdraw(amount);
                        secondAccount.deposit(amount);
                    } finally {
                        secondAccount.getLock().unlock();
                    }
                } else {
                    throw new LockWaitingException("");
                }
            } finally {
                firstAccount.getLock().unlock();
            }
        } else {
            throw new LockWaitingException("Can't lock now, resource is busy");
        }
    }
}
