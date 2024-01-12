package com.solvd.laba;

import com.solvd.laba.domain.*;
import com.solvd.laba.domain.exception.ResourceNotFoundException;
import com.solvd.laba.persistence.CustomerRepository;
import com.solvd.laba.service.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.solvd.laba.service.impl.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
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
//        double balanceToFind = 3000.0;
//        List<Account> accountsWithBigBalance = accountService.retrieveBalance(balanceToFind);
//        System.out.println("Accounts with balance bigger than " + balanceToFind + ":");
//        for (Account account : accountsWithBigBalance) {
//            System.out.println(account.toString());
//        }

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
//
//        // Test findById method
//        System.out.println("\n\nFinding customer by ID...");
//        Optional<Customer> foundCustomer = customerService.findById(1L);
//        if (foundCustomer.isPresent()) {
//            System.out.println("Found Customer ID " + 1L + ": " + foundCustomer.get());
//        } else {
//            System.out.println("Customer ID " + 1L + " not found.");
//        }

        // Test update method
//        System.out.println("Updating customer...");
//        createdCustomer.setName("Updated Name2");
//        createdCustomer.setPhoneNumber("473-483-4923");
//        customerService.update(createdCustomer);
//        System.out.println("Customer updated: " + createdCustomer);


//        myBatisLoan(loanService);
//        myBatisStatement(statementService);
//        myBatisAccount(accountService);
//        myBatisTransaction(transactionService);
        myBatisCustomer(customerService);


    }

    private static void myBatisCustomer(CustomerService customerService) {
        Customer customer = new Customer();
        customer.setName("Noo Yess");
        customer.setPhoneNumber("323-432-5654");

        // fake data for transactions
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(1600.0);
        transaction1.setType("Deposit");
        transaction1.setDate(LocalDate.now().minusDays(5));
        transactions.add(transaction1);

        // fake data for loans
        List<Loan> loans = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setAmount(4000.0);
        loan1.setType("Student");
        loan1.setInterestRate(2.0);
        loan1.setStartDate(LocalDate.now().minusMonths(3));
        loan1.setEndDate(LocalDate.now().plusMonths(9));
        loans.add(loan1);

        // fake data for accounts
        List<Account> accounts = new ArrayList<>();
        Account account1 = new Account();
        account1.setBalance(1000.0);
        account1.setType("Checking");
        account1.setOpenDate(LocalDate.now().minusYears(1));
        accounts.add(account1);

        customer.setTransactions(transactions);
        customer.setLoans(loans);
        customer.setAccounts(accounts);

        // Creating a new customer
        Customer createdCustomer = customerService.create(customer);
        System.out.println("Customer created: " + createdCustomer);

        // Retrieving a customer by ID
        Optional<Customer> retrievedCustomer = customerService.findById(4L);
        System.out.println("Retrieved Customer: " + retrievedCustomer.orElse(null));

        // Updating the customer
        if (retrievedCustomer.isPresent()) {
            Customer updatedCustomer = retrievedCustomer.get();
            updatedCustomer.setName("Updated Name");
            customerService.update(updatedCustomer);
            System.out.println("Customer updated: " + updatedCustomer);
        } else {
            System.out.println("Customer not found for update.");
        }
    }


    private static void myBatisTransaction(TransactionService transactionService) {
        Transaction transaction = new Transaction();
        transaction.setAmount(100.0);
        transaction.setType("Withdrawal");
        transaction.setDate(LocalDate.now());

        transactionService.create(transaction, 3L);
        System.out.println("Transaction created: " + transaction);

//         Retrieving transaction by ID
        Optional<Transaction> retrievedTransaction = transactionService.retrieveById(3L);
        System.out.println("Retrieved Transaction: " + retrievedTransaction.orElse(null));

        // Updating the transaction
        if (retrievedTransaction.isPresent()) {
            Transaction updatedTransaction = retrievedTransaction.get();
            updatedTransaction.setAmount(200.0);
            transactionService.update(updatedTransaction);
            System.out.println("Transaction updated: " + updatedTransaction);
        } else {
            System.out.println("Transaction not found for update.");
        }
    }

    private static void myBatisAccount(AccountService accountService) {
        // Creating a new account with statements
        Account newAccount = new Account();
        newAccount.setBalance(2300.0);
        newAccount.setType("Saving");
        newAccount.setOpenDate(LocalDate.now());
        // Creating statements for the account
        List<Statement> statements = new ArrayList<>();
        Statement statement1 = new Statement();
        statement1.setStartBalance(1500.0);
        statement1.setEndBalance(1900.0);
        statement1.setOpenDate(LocalDate.now());
        statement1.setEndDate(LocalDate.now().plusMonths(1));

        Statement statement2 = new Statement();
        statement2.setStartBalance(2000.0);
        statement2.setEndBalance(3000.0);
        statement2.setOpenDate(LocalDate.now());
        statement2.setEndDate(LocalDate.now().plusMonths(2));

        statements.add(statement1);
        statements.add(statement2);
        newAccount.setStatements(statements);

        accountService.create(newAccount, 4L);
        System.out.println("Created Account: " + newAccount);

        // Finding accounts with balance greater than amount
        List<Account> accountsWithBalance = accountService.retrieveBalance(10.0);
        System.out.println("Accounts with balance greater than " + 10.0 + ":");
        for (Account account : accountsWithBalance) {
            System.out.println(account);
        }

        // Updating
        if (!accountsWithBalance.isEmpty()) {
            Account updatedAccount = accountsWithBalance.get(0);
            updatedAccount.setBalance(6000.0);
            accountService.update(updatedAccount);
            System.out.println("Updated Account: " + updatedAccount);
        } else {
            System.out.println("Cannot update. No accounts found.");
        }

    }

    private static void myBatisStatement(StatementService statementService) {
        Statement newStatement = new Statement();
        newStatement.setStartBalance(1000.0);
        newStatement.setEndBalance(1500.0);
        newStatement.setOpenDate(LocalDate.now());
        newStatement.setEndDate(LocalDate.now().plusMonths(1));

        statementService.create(newStatement, 10L);
        System.out.println("Created Statement: " + newStatement);

        // Finding a statement by ID
        Optional<Statement> foundStatement = statementService.findById(8L);
        foundStatement.ifPresentOrElse(
                statement -> System.out.println("Found Statement: " + statement),
                () -> System.out.println("Statement not found.")
        );

        // Updating an existing statement
        if (foundStatement.isPresent()) {
            Statement updatedStatement = foundStatement.get();
            updatedStatement.setEndBalance(2300.0);
            statementService.update(updatedStatement);
            System.out.println("Updated Statement: " + updatedStatement);
        } else {
            System.out.println("Statement not found.");
        }

    }

    private static void myBatisLoan(LoanService loanService) {
        List<Loan> loans = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setAmount(2100.0);
        loan1.setType("Student");
        loan1.setInterestRate(2.9);
        loan1.setStartDate(LocalDate.now().minusMonths(3));
        loan1.setEndDate(LocalDate.now().plusMonths(9));
        loans.add(loan1);

        Loan createdLoan = loanService.create(loan1, 5L);
        System.out.println("Created Loan: " + createdLoan);

        // Finding loans after a specific date
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        List<Loan> loansAfterDate = loanService.retrieveAllLoansAfter(startDate);
        System.out.println("Loans after " + startDate + ":");
        for (Loan loan : loansAfterDate) {
            System.out.println(loan);
        }

        // Updating an existing loan
        createdLoan.setAmount(3000.0);
        loanService.update(createdLoan);
        System.out.println("Updated Loan: " + createdLoan);
    }

    private static Customer testCustomerService(CustomerService customerService) {
        Customer customer = new Customer();
        customer.setName("Do dont");
        customer.setPhoneNumber("323-432-4332");

        // fake data for transactions
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(2600.0);
        transaction1.setType("Deposit");
        transaction1.setDate(LocalDate.now().minusDays(5));
        transactions.add(transaction1);

        // fake data for loans
        List<Loan> loans = new ArrayList<>();
        Loan loan1 = new Loan();
        loan1.setAmount(8100.0);
        loan1.setType("Student");
        loan1.setInterestRate(7.0);
        loan1.setStartDate(LocalDate.now().minusMonths(3));
        loan1.setEndDate(LocalDate.now().plusMonths(9));
        loans.add(loan1);

        // fake data for accounts
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