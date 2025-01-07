package org.example;

import java.util.ArrayList;

public class Bank {

    private ArrayList<BankAccount> bankAccountsList;

    public Bank()
    {
        bankAccountsList = new ArrayList<>();
    }

    public void addBankAccount(BankAccount bankAccount)
    {
        bankAccountsList.add(bankAccount);
    }

    public void removeBankAccount(BankAccount bankAccount)
    {
        bankAccountsList.remove(bankAccount);
    }

    public double totalBankBalance()
    {
        double current = 0;

        for (BankAccount acct : bankAccountsList)
        {
            current = current + acct.getBalance();
        }

        return current;
    }

    public double largestBalance()
    {
        if (bankAccountsList.isEmpty()) {
            System.out.println("ERROR: NO BANK ACCOUNTS");
            return Double.NaN; // Indicate an invalid result
        }

        double current = Double.NEGATIVE_INFINITY;

            for (BankAccount acct : bankAccountsList)
            {
                if (acct.getBalance() > current)
                {
                    current = acct.getBalance();
                }
            }

        return current;

    }

    public BankAccount getBankAccount(long accountNumber, int pin)
    {
        for (BankAccount acct : bankAccountsList)
        {
            if (acct.getAccountNumber() == accountNumber && acct.getPin() == pin)
            {
                return acct;
            }
        }

        return null; // if account not found
    }


    public double deposit(long accountNumber, int pin, double amount)
    {
        BankAccount acct = getBankAccount(accountNumber, pin);

        if (acct != null)
        {
            if (amount <= 0) {
                System.out.println("ERROR: Deposit amount must be positive.");
                return acct.getBalance();
            }
            else
            {
                return acct.deposit(amount);
            }
        }

        System.out.println("ERROR: ACCOUNT NOT FOUND");
        return -1;
    }

    public double withdraw(long accountNumber, int pin, double amount)
    {
        BankAccount acct = getBankAccount(accountNumber, pin);

        if (acct != null)
        {
            if (amount <= 0)
            {
                System.out.println("Error: Withdraw amount must be a positive amount");
                return acct.withdraw(amount);
            }
            if (acct.getBalance() < amount)
            {
                System.out.println("Error: Insufficient funds.");
                return acct.getBalance();
            }
            else
            {
                return acct.withdraw(amount);
            }
        }

        System.out.println("ERROR: ACCOUNT NOT FOUND");
        return -1;
    }

}
