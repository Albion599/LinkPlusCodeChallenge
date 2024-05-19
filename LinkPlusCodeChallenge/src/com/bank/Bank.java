package com.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {
    private String bankName;
    private List<Account> accounts;
    private List<Transaction> transactions;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFee;
    private double transactionPercentFee;

    public Bank(String bankName, double transactionFlatFee, double transactionPercentFee) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.totalTransactionFeeAmount = 0.0;
        this.totalTransferAmount = 0.0;
        this.transactionFlatFee = transactionFlatFee;
        this.transactionPercentFee = transactionPercentFee;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Optional<Account> getAccount(String accountId) {
        return accounts.stream().filter(account -> account.getAccountId().equals(accountId)).findFirst();
    }

    public void performTransaction(String fromAccountId, String toAccountId, double amount, boolean useFlatFee, String reason) throws Exception {
        Optional<Account> fromAccountOpt = getAccount(fromAccountId);
        Optional<Account> toAccountOpt = getAccount(toAccountId);

        if (!fromAccountOpt.isPresent() || !toAccountOpt.isPresent()) {
            throw new Exception("Account not found");
        }

        Account fromAccount = fromAccountOpt.get();
        Account toAccount = toAccountOpt.get();

        double fee = useFlatFee ? transactionFlatFee : amount * transactionPercentFee / 100;

        if (fromAccount.withdraw(amount + fee)) {
            toAccount.deposit(amount);
            totalTransactionFeeAmount += fee;
            totalTransferAmount += amount;
            transactions.add(new Transaction(amount, fromAccountId, toAccountId, reason));
        } else {
            throw new Exception("Not enough funds");
        }
    }

    public void withdraw(String accountId, double amount) throws Exception {
        Optional<Account> accountOpt = getAccount(accountId);

        if (!accountOpt.isPresent()) {
            throw new Exception("Account not found");
        }

        Account account = accountOpt.get();

        if (!account.withdraw(amount)) {
            throw new Exception("Not enough funds");
        }
    }

    public void deposit(String accountId, double amount) throws Exception {
        Optional<Account> accountOpt = getAccount(accountId);

        if (!accountOpt.isPresent()) {
            throw new Exception("Account not found");
        }

        Account account = accountOpt.get();
        account.deposit(amount);
    }

    public List<Transaction> getTransactionsForAccount(String accountId) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getOriginatingAccountId().equals(accountId) || transaction.getResultingAccountId().equals(accountId)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }

    public double getAccountBalance(String accountId) throws Exception {
        Optional<Account> accountOpt = getAccount(accountId);

        if (!accountOpt.isPresent()) {
            throw new Exception("Account not found");
        }

        return accountOpt.get().getBalance();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }
}
