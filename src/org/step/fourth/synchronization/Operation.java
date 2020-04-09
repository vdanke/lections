package org.step.fourth.synchronization;

import org.step.fourth.util.ThreadSupportUtil;

import static org.step.fourth.synchronization.AccountTransfer.transfer;

public class Operation {

    public static void main(String[] args) throws InterruptedException {
        final Account firstAccount = new Account(1000);
        final Account secondAccount = new Account(2000);

        Runnable runnable = () -> {
            ThreadSupportUtil threadSupportUtil = new ThreadSupportUtil();
            threadSupportUtil.cycleThreadRunner("Running", 400);
        };

        Account account = new Account(10);
        account.start();

        Thread firstThread = new Thread(runnable);
        Thread secondThread = new Thread(runnable);

        new Thread(() -> {
            try {
                transfer(firstAccount, secondAccount, 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        transfer(secondAccount, firstAccount, 300);
    }
}
