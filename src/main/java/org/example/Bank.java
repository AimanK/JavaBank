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

    public BankAccount getBankAccount(String accountNumber)
    {
        for (int i = 0; i < bankAccountsList.size(); i++)
        {
            if (bankAccountsList.get(i).getAccountNumber().equals(accountNumber))
            {
                return bankAccountsList.get(i);
            }
        }

        return null;
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

    public BankAccount largestBalance()
    {
        if (bankAccountsList.isEmpty()) {
            System.out.println("ERROR: NO BANK ACCOUNTS");
            return null; // Indicate an invalid result
        }

        BankAccount largestAcct = bankAccountsList.get(0);

            for (BankAccount acct : bankAccountsList)
            {
                if (acct.getBalance() > largestAcct.getBalance())
                {
                    largestAcct = acct;
                }
            }

        return largestAcct;

    }


    public double deposit(String accountNumber, double amount)
    {
        BankAccount acct = getBankAccount(accountNumber);

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

    public double withdraw(String accountNumber, double amount)
    {
        BankAccount acct = getBankAccount(accountNumber);

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

    public ArrayList<BankAccount> returnAccountsWithMinBalance(double min)
    {
        ArrayList<BankAccount> list = new ArrayList<>();

        for (int i = 0; i < bankAccountsList.size(); i++)
        {
            if (bankAccountsList.get(i).getBalance() >= min)
            {
                list.add(bankAccountsList.get(i));
            }
        }

        return list;
    }

}
