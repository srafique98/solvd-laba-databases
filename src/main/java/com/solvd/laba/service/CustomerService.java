package com.solvd.laba.service;

import com.solvd.laba.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> retrieveAllCustomerAccounts();
    void update(Customer customer);
}
