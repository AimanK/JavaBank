package org.example;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class BankAccount {

    /**
     *  First we will need to define the two attributes for this class
     *  1.) An account number
     *  2.) A balance for that account (initialized to 0.00)
     */

    private long accountNumber;
    private double balance;
    private int pin; // 4-digit unique PIN
    private static final HashSet<Integer> usedPINs = new HashSet<>();

    public BankAccount(long accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public BankAccount(long accountNumber, int pin)
    {
        this.accountNumber = accountNumber;
        this.pin = pin;
        balance = 0.00;
    }

    public BankAccount(int pin)
    {
        this.accountNumber = setAccountNumber();
        setPin(pin);
        balance = 0.00;
    }

    public long getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getPin()
    {
        return pin;
    }

    public void setPin(int pin)
    {
        if (pin < 1000 || pin > 9999)
        {
            throw new IllegalArgumentException("PIN must be a 4-digit number.");
        }

        if (usedPINs.contains(pin))
        {
            throw new IllegalArgumentException("PIN is already in use. Please choose another.");
        }

        usedPINs.add(pin);
        this.pin = pin;
    }

    public long setAccountNumber()
    {
        Random random = new Random();
        return Math.abs(random.nextLong());
    }


    public double deposit(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

        this.balance = this.balance + amount;
        return this.balance;
    }

    public double withdraw(double amount)
    {
        if (amount <= 0)
        {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }



        this.balance = this.balance - amount;

        return this.balance;
    }

}
