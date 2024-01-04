package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void create(Customer customer);
    List<Customer> findAllCustomerAccounts();
    void update(Customer customer);
}
