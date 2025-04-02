package org.example;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        System.out.println("Welcome to KayadCodes Bank!");

        BankAccount aimansBankAccount = new BankAccount("12345", 140000.00);

        myBank.addBankAccount(aimansBankAccount);

        System.out.println(myBank.largestBalance());

        myBank.deposit("12345", 12000.00);

        System.out.println(myBank.getBankAccount("12345"));

        myBank.withdraw("12345", 10000.00);

        System.out.println(myBank.getBankAccount("12345"));

        System.out.println("Thank you for your business!");


    }
}