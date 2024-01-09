package com.solvd.laba;

import com.solvd.laba.domain.*;
import com.solvd.laba.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solvd.laba.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LoanService loanService = new LoanServiceImpl();
        StatementService statementService = new StatementServiceImpl();
        AccountService accountService = new AccountServiceImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();


//        // FINDING LOAN
//        LocalDate startDate = LocalDate.of(2023, 1, 1);
//        List<Loan> loansAfterDate = loanService.retrieveAllLoansAfter(startDate);
//        System.out.println("Loans after January 1, 2023:");
//        for (Loan loan : loansAfterDate) {
//            System.out.println(loan);
//        }

//         create loan2
//        Loan newLoan1 = new Loan();
//        newLoan1.setAmount(2999.0);
//        newLoan1.setType("Student");
//        newLoan1.setInterestRate(0.2);
//        newLoan1.setStartDate(LocalDate.of(2023, 3, 23));
//        newLoan1.setEndDate(LocalDate.of(2024, 3, 23));
//        Loan createdLoan2 = loanService.create(newLoan1,4L);
//        System.out.println("Created Loan: " + createdLoan2);

        // UPDATE LOAN
//        createdLoan2.setAmount(3500.0);
//        createdLoan2.setInterestRate(0.18);
//        createdLoan2.setType("Personal");
//        createdLoan2.setEndDate(LocalDate.of(2024, 6, 30));
//
//        loanService.update(createdLoan2);
//        System.out.println("Updated Loan: " + createdLoan2);

//        // GET LOAN BY ID
//        Loan retrievedLoan = loanService.getLoanById(loanService, 4L);
//        if (retrievedLoan != null) {
//            System.out.println("Retrieved Loan by ID " + 4L + ": " + retrievedLoan);
//        } else {
//            System.out.println("Loan with ID " + 4L + " not found.");
//        }

        // CREATE NEW STATEMENT
//        Statement newStatement = new Statement();
//        newStatement.setStartBalance(1100.0);
//        newStatement.setEndBalance(3300.0);
//        newStatement.setOpenDate(LocalDate.of(2022, 2, 21));
//        newStatement.setEndDate(LocalDate.of(2022, 3, 21));
//
//        statementService.create(newStatement, 4L);
//        System.out.println("Created Statement: " + newStatement);

        // FIND STATEMENT BY ID
//        Optional<Statement> foundStatement = statementService.findById(8L);
//        if (foundStatement.isPresent()) {
//            System.out.println("Statement ID " + 8L + ": " + foundStatement.get());
//        } else {
//            System.out.println("Statement ID " + 8L + " not found.");
//        }

        // UPDATE STATEMENT
//        if (foundStatement.isPresent()) {
//            Statement statementToUpdate = foundStatement.get();
//            statementToUpdate.setStartBalance(1500.0);
//            statementToUpdate.setEndBalance(2000.0);
//            statementToUpdate.setOpenDate(LocalDate.of(2023,5,15));
//            statementToUpdate.setEndDate(LocalDate.of(2023, 6, 15));
//
//            statementService.update(statementToUpdate);
//            System.out.println("Updated Statement: " + statementToUpdate);
//        } else {
//            System.out.println("Statement ID " + 8L + " not found.");
//        }

        // CREATE NEW ACCOUNT
//        Account newAccount = new Account();
//        newAccount.setBalance(9000.0);
//        newAccount.setType("Checking");
//        newAccount.setOpenDate(LocalDate.of(2023, 4, 22));
//        newAccount.setStatements(new ArrayList<>());
//
//        accountService.create(newAccount, 3L);
//        System.out.println("Created Account: " + newAccount);

        // FIND ACCOUNTS BY BALANCE
        double balanceToFind = 3000.0;
        List<Account> accountsWithBigBalance = accountService.retrieveBalance(balanceToFind);
        System.out.println("Accounts with balance bigger than " + balanceToFind + ":");
        for (Account account : accountsWithBigBalance) {
            System.out.println(account.toString());
        }

        // UPDATE ACCOUNT
//        if (!accountsWithBigBalance.isEmpty()) {
//            Account accountToUpdate = accountsWithBigBalance.get(0);
//            accountToUpdate.setBalance(4500.0);
//            accountToUpdate.setType("Checking");
//
//            accountService.update(accountToUpdate);
//            System.out.println("Updated Account: " + accountToUpdate);
//        }

        // Create a new transaction
//        Transaction newTransaction = new Transaction();
//        newTransaction.setAmount(150.0);
//        newTransaction.setType("Deposit");
//        newTransaction.setDate(LocalDate.now());
//        // Create the transaction
//        transactionService.create(newTransaction, 1L);
//        System.out.println("Created Transaction: " + newTransaction);

//         Find the transaction by ID
//        Optional<Transaction> foundTransaction = transactionService.retrieveById(1L);
//        if (foundTransaction.isPresent()) {
//            System.out.println("Found Transaction ID " + 1L + ": " + foundTransaction.get());
//        } else {
//            System.out.println("Transaction ID " + 1L + " not found.");
//        }

        // Update the transaction
//        if (foundTransaction.isPresent()) {
//            Transaction updatedTransaction = foundTransaction.get();
//            updatedTransaction.setAmount(1500.0);
//            updatedTransaction.setType("Deposit");
//            updatedTransaction.setDate(LocalDate.now());
//
//            transactionService.update(updatedTransaction);
//            System.out.println("Updated Transaction: " + updatedTransaction);
//        } else {
//            System.out.println("Transaction with ID " + 3L + " not found.");
//        }

//        Customer createdCustomer = testCustomerService(customerService);

        // Test findById method
        System.out.println("\n\nFinding customer by ID...");
        Optional<Customer> foundCustomer = customerService.findById(1L);
        if (foundCustomer.isPresent()) {
            System.out.println("Found Customer ID " + 1L + ": " + foundCustomer.get());
        } else {
            System.out.println("Customer ID " + 1L + " not found.");
        }

        // Test update method
//        System.out.println("Updating customer...");
//        createdCustomer.setName("Updated Name2");
//        createdCustomer.setPhoneNumber("473-483-4923");
//        customerService.update(createdCustomer);
//        System.out.println("Customer updated: " + createdCustomer);


    }

    private static Customer testCustomerService(CustomerService customerService) {
        Customer customer = new Customer();
        customer.setName("Julius Pope");
        customer.setPhoneNumber("473-443-4938");

        // fake data for transactions
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(1000.0);
        transaction1.setType("Deposit");
        transaction1.setDate(LocalDate.now().minusDays(5));
        transactions.add(transaction1);

        // fake data for loans
        List<Loan> loans = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setAmount(2000.0);
        loan1.setType("Student");
        loan1.setInterestRate(7.0);
        loan1.setStartDate(LocalDate.now().minusMonths(3));
        loan1.setEndDate(LocalDate.now().plusMonths(9));
        loans.add(loan1);

        // Generate fake data for accounts
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account();
        account1.setBalance(2000.0);
        account1.setType("Checking");
        account1.setOpenDate(LocalDate.now().minusYears(1));
        accounts.add(account1);

        customer.setTransactions(transactions);
        customer.setLoans(loans);
        customer.setAccounts(accounts);

        // creating customer
        System.out.println("Creating customer...");
        Customer createdCustomer = customerService.create(customer);
        System.out.println("Customer created: " + createdCustomer);

        return createdCustomer;
    }


}