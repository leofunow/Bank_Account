package com.company;

public class Main {
    // волотильность - изменчивость
    public static void main(String[] args) {
        Bank bank = new Bank();
        new Thread(bank.getMoney).start();
        new Thread(bank.lostMoney).start();
        new Thread(bank.PrintAccount).start();
    }
}
