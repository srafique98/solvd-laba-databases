package com.solvd.laba.service;

import com.solvd.laba.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> retrieveAllCustomerAccounts();
    void update(Customer customer);
    Optional<Customer> findById(Long id);
}
