# Bank System Console Application

## Overview
This is a console application for a bank system that supports multiple user accounts and performs transactions. The application allows users to create accounts, deposit and withdraw money, and perform transactions between accounts with applicable fees.

## Features
- Create a bank with a name, transaction flat fee, and transaction percent fee.
- Create user accounts with a specified account ID, user name, and initial balance.
- Perform both flat fee and percent fee transactions from one account to another.
- Withdraw and deposit money to accounts.
- View a list of transactions for any account.
- Check the account balance for any account.
- View a list of all bank accounts.
- Check the total transaction fee amount and total transfer amount for the bank.

## How to Run the Application
1. **Clone the Repository:** 
git clone https://github.com/Albion599/LinkPlusCodeChallenge.git


2. **Open the Project:**
Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).

3. **Run the Main Class:**
Run the `Main` class to start the application.

4. **Follow the Prompts:**
Follow the prompts in the console to interact with the bank system. Here's a brief overview of the available options:

- **Create Account:**
  - Enter the account ID (e.g., 1234).
  - Enter the user name (e.g., John Doe).
  - Enter the initial balance (e.g., 1000).
  - Select the account type (1 for Checking, 2 for Savings).

- **Deposit:**
  - Enter the account ID.
  - Enter the amount to deposit.

- **Withdraw:**
  - Enter the account ID.
  - Enter the amount to withdraw.

- **Perform Transaction:**
  - Enter the originating account ID.
  - Enter the resulting account ID.
  - Enter the amount to transfer.
  - Specify whether to use a flat fee (true/false).
  - Enter the transaction reason.

- **Check Account Balance:**
  - Enter the account ID.

- **View Transactions for Account:**
  - Enter the account ID.

- **View All Accounts:** No input required.

- **Check Total Transaction Fee Amount:** No input required.

- **Check Total Transfer Amount:** No input required.

- **Exit:** No input required.

5. **Handle Errors:**
Proper error messages will be displayed in case of any errors, such as account not found or not enough funds.

## Contributor
- Albion Paçarizi (@Albion599)

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


