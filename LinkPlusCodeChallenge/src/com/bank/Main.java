package com.bank;

import java.util.Scanner;

public class Main {
    private static Bank bank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter bank name:");
        String bankName = scanner.nextLine();

        System.out.println("Enter transaction flat fee:");
        double flatFee = scanner.nextDouble();

        System.out.println("Enter transaction percent fee:");
        double percentFee = scanner.nextDouble();

        bank = new Bank(bankName, flatFee, percentFee);

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Perform Transaction");
            System.out.println("5. Check Account Balance");
            System.out.println("6. View Transactions for Account");
            System.out.println("7. View All Accounts");
            System.out.println("8. Check Total Transaction Fee Amount");
            System.out.println("9. Check Total Transfer Amount");
            System.out.println("10. Exit");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        createAccount(scanner);
                        break;
                    case 2:
                        deposit(scanner);
                        break;
                    case 3:
                        withdraw(scanner);
                        break;
                    case
                            4:
                        performTransaction(scanner);
                        break;
                    case 5:
                        checkAccountBalance(scanner);
                        break;
                    case 6:
                        viewTransactions(scanner);
                        break;
                    case 7:
                        viewAllAccounts();
                        break;
                    case 8:
                        checkTotalTransactionFeeAmount();
                        break;
                    case 9:
                        checkTotalTransferAmount();
                        break;
                    case 10:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        scanner.nextLine();  // consume newline
        System.out.println("Enter account ID:");
        String accountId = scanner.nextLine();

        System.out.println("Enter user name:");
        String userName = scanner.nextLine();

        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();

        System.out.println("Select account type (1 for Checking, 2 for Savings):");
        int accountType = scanner.nextInt();
        scanner.nextLine();  // consume newline

        Account account;
        switch (accountType) {
            case 1:
                account = new CheckingAccount(accountId, userName, initialBalance);
                break;
            case 2:
                account = new SavingsAccount(accountId, userName, initialBalance);
                break;
            default:
                System.out.println("Invalid account type. Account not created.");
                return;
        }

        bank.addAccount(account);
        System.out.println("Account created successfully.");
    }

    private static void deposit(Scanner scanner) throws Exception {
        scanner.nextLine();  // consume newline
        System.out.println("Enter account ID:");
        String accountId = scanner.nextLine();

        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();

        bank.deposit(accountId, amount);
        System.out.println("Deposit successful.");
    }

    private static void withdraw(Scanner scanner) throws Exception {
        scanner.nextLine();  // consume newline
        System.out.println("Enter account ID:");
        String accountId = scanner.nextLine();

        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();

        bank.withdraw(accountId, amount);
        System.out.println("Withdrawal successful.");
    }

    private static void performTransaction(Scanner scanner) throws Exception {
        scanner.nextLine();  // consume newline
        System.out.println("Enter originating account ID:");
        String fromAccountId = scanner.nextLine();

        System.out.println("Enter resulting account ID:");
        String toAccountId = scanner.nextLine();

        System.out.println("Enter amount to transfer:");
        double amount = scanner.nextDouble();

        System.out.println("Use flat fee? (true/false):");
        boolean useFlatFee = scanner.nextBoolean();

        scanner.nextLine();  // consume newline
        System.out.println("Enter transaction reason:");
        String reason = scanner.nextLine();

        bank.performTransaction(fromAccountId, toAccountId, amount, useFlatFee, reason);
        System.out.println("Transaction successful.");
    }

    private static void checkAccountBalance(Scanner scanner) throws Exception {
        scanner.nextLine();  // consume newline
        System.out.println("Enter account ID:");
        String accountId = scanner.nextLine();

        double balance = bank.getAccountBalance(accountId);
        System.out.println("Account balance: $" + balance);
    }

    private static void viewTransactions(Scanner scanner) {
        scanner.nextLine();  // consume newline
        System.out.println("Enter account ID:");
        String accountId = scanner.nextLine();

        for (Transaction transaction : bank.getTransactionsForAccount(accountId)) {
            System.out.println("Transaction from " + transaction.getOriginatingAccountId() + " to " + transaction.getResultingAccountId() + " of $" + transaction.getAmount() + " for " + transaction.getReason());
        }
    }

    private static void viewAllAccounts() {
        for (Account account : bank.getAccounts()) {
            System.out.println("Account ID: " + account.getAccountId() + ", User Name: " + account.getUserName() + ", Balance: $" + account.getBalance());
        }
    }

    private static void checkTotalTransactionFeeAmount() {
        System.out.println("Total transaction fee amount: $" + bank.getTotalTransactionFeeAmount());
    }

    private static void checkTotalTransferAmount() {
        System.out.println("Total transfer amount: $" + bank.getTotalTransferAmount());
    }
}
