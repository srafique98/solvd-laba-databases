package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.persistence.CustomerRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public class CustomerMyBatisDAO implements CustomerRepository {
    @Override
    public void create(Customer customer) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.create(customer);
        }
    }

    @Override
    public List<Customer> findAllCustomerAccounts() {
        return null;
    }

    @Override
    public void update(Customer customer) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            customerRepository.update(customer);
        }

    }

    @Override
    public Optional<Customer> findById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
            return customerRepository.findById(id);
        }
    }
}
