package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;

import java.util.List;

public interface CustomerRepository {
    void create(Customer customer);
    List<Customer> findAll();
}
