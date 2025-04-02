package org.example;

public class BankAccount {

    /**
     *  First we will need to define the two attributes for this class
     *  1.) An account number
     *  2.) A balance for that account (initialized to 0.00)
     */

    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
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

    @Override
    public String toString() {
        return String.format("Account Number: %s, Balance: $%,.2f", accountNumber, balance);
    }

}
