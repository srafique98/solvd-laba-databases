package com.solvd.laba.persistence.impl;

import com.solvd.laba.Main;
import com.solvd.laba.domain.Customer;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class CustomerDAO implements CustomerRepository {
    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();


    @Override
    public void create(Customer customer) {
        Connection connection = CONNECTION_POOL.getConnection();
        String createQuery = "INSERT INTO customers(name, phone_number) VALUES (?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery,Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getPhoneNumber());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                customer.setId(resultSet.getLong(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create customer", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers;
        Connection connection = CONNECTION_POOL.getConnection();

        String findAllQuery = "SELECT * FROM customers";
        try(PreparedStatement preparedStatement = connection.prepareStatement(findAllQuery)){
            ResultSet resultSet = preparedStatement.executeQuery();
//            customers = map
        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

        return null;

    }


}