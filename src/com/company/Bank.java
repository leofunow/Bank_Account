package com.company;

import java.util.Random;

public class Bank {
    private volatile int account = 100;
    private volatile boolean flag = true;
    Runnable getMoney = new Runnable() {
        @Override
        public void run() {
            while (flag) {
                try {
                    Random random = new Random();
                    account += Math.abs(random.nextInt()) % 1000;
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Runnable lostMoney = () -> {
        while (flag) {
            try {
                Random random = new Random();
                int moneylost = Math.abs(random.nextInt()) % 1000;
                if (moneylost <= account) {
                    account -= moneylost;
                } else {
                    System.out.println("Not enough money");
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable PrintAccount  = () ->{
        while (flag) {
            try {
                System.out.println(account);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
