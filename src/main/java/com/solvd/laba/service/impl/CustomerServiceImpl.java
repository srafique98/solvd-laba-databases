package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.persistence.CustomerRepository;
import com.solvd.laba.persistence.impl.CustomerDAO;
import com.solvd.laba.service.AccountService;
import com.solvd.laba.service.CustomerService;
import com.solvd.laba.service.LoanService;
import com.solvd.laba.service.TransactionService;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository; // customerDAO
    private final LoanService loanService; // service can talk to service
    private final TransactionService transactionService;
    private final AccountService accountService;

    public CustomerServiceImpl() {
        this.customerRepository = new CustomerDAO();
        this.loanService = new LoanServiceImpl();
        this.transactionService = new TransactionServiceImpl();
        this.accountService = new AccountServiceImpl();
    }
    @Override
    public Customer create(Customer customer) {
        customer.setId(null);
        customerRepository.create(customer);

        if (!customer.getLoans().isEmpty()) {
            customer.getLoans().forEach(loan -> {
                loanService.create(loan, customer.getId());
            });
        }

        if (!customer.getTransactions().isEmpty()) {
            customer.getTransactions().forEach(transaction -> {
                transactionService.create(transaction, customer.getId());
            });
        }

        if (!customer.getAccounts().isEmpty()) {
            customer.getAccounts().forEach(account -> {
                accountService.create(account, customer.getId());
            });
        }

        return customer;
    }

    @Override
    public List<Customer> retrieveAllCustomerAccounts() {
        return customerRepository.findAllCustomerAccounts();
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);

    }

    @Override
    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

}
