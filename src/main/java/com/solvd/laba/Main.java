package com.solvd.laba;


import com.solvd.laba.domain.Account;
import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.Loan;
import com.solvd.laba.domain.Transaction;
import com.solvd.laba.service.CustomerService;
import com.solvd.laba.service.LoanService;
import com.solvd.laba.service.impl.CustomerServiceImpl;

import java.time.LocalDate;
import java.util.List;

import com.solvd.laba.service.impl.LoanServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
//        // Creating a new customer
//        Customer newCustomer = new Customer();
//        newCustomer.setName("Kyle Upp");
//        newCustomer.setPhoneNumber("+123456789");
//
//        // Creating transactions for the customer
//        Transaction transaction1 = new Transaction();
//        transaction1.setAmount(100.0);
//        transaction1.setType("Credit");
//        transaction1.setDate(LocalDate.now().minusDays(1));
//
//        Transaction transaction2 = new Transaction();
//        transaction2.setAmount(-50.0);
//        transaction2.setType("Debit");
//        transaction1.setDate(LocalDate.now().minusDays(3));
//
//        // Adding transactions to the customer
//        newCustomer.setTransactions(Arrays.asList(transaction1, transaction2));
//
//        // Creating accounts for the customer
//        Account account1 = new Account();
//        account1.setType("Savings");
//
//        Account account2 = new Account();
//        account2.setType("Checking");
//
//        // Adding accounts to the customer
//        newCustomer.setAccounts(Arrays.asList(account1, account2));
//
//        // Creating loans for the customer
//        Loan loan1 = new Loan();
//        loan1.setAmount(5000.0);
//        loan1.setInterestRate(0.05);
//
//        Loan loan2 = new Loan();
//        loan2.setAmount(10000.0);
//        loan2.setInterestRate(0.08);
//
//        // Adding loans to the customer
//        newCustomer.setLoans(Arrays.asList(loan1, loan2));
//
//        // Creating service and repository instances
//        CustomerService customerService = new CustomerServiceImpl();
//
//        // Creating a new customer with associated transactions, accounts, and loans
//        Customer createdCustomer = customerService.create(newCustomer);
//        System.out.println("Created Customer: " + createdCustomer);
//
//        // Retrieving all customer accounts
////        List<Customer> allCustomers = customerService.retrieveAllCustomerAccounts();
////        System.out.println("All Customer Accounts: " + allCustomers);
//
//        // Updating the customer
//        createdCustomer.setName("Updated Name");
//        customerService.update(createdCustomer);
//        System.out.println("Updated Customer: " + createdCustomer);


        LoanService loanService = new LoanServiceImpl();

        // FINDING LOAN
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        List<Loan> loansAfterDate = loanService.retrieveAllLoansAfter(startDate);
        System.out.println("Loans after January 1, 2023:");
        for (Loan loan : loansAfterDate) {
            System.out.println(loan);
        }

        // CREATING LOAN
//        Loan newLoan = new Loan();
//        newLoan.setAmount(5000.0);
//        newLoan.setType("Personal");
//        newLoan.setInterestRate(0.02);
//        newLoan.setStartDate(LocalDate.of(2023, 5, 1));
//        newLoan.setEndDate(LocalDate.of(2024, 5, 1));
//        Loan createdLoan = loanService.create(newLoan);
//        System.out.println("Created Loan: " + createdLoan);

        //Updating Loan
        Loan loanToUpdate = new Loan();
        loanToUpdate.setId(3L);
        loanToUpdate.setAmount(25000.0);
        loanToUpdate.setInterestRate(5.0);
        loanToUpdate.setType("Personal");
        loanToUpdate.setEndDate(LocalDate.of(2023, 12, 31));
        loanService.update(loanToUpdate);

        Loan updatedLoan = loanService.getLoanById(loanService, loanToUpdate.getId());
        System.out.println("Updated Loan: " + updatedLoan);
    }


}