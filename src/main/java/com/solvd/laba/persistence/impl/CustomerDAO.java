package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Account;
import com.solvd.laba.domain.Customer;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            LOGGER.info("Customer created: " + customer.toString());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create customer", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Customer> findAllCustomerAccounts() {
        List<Customer> customers = null;
        Connection connection = CONNECTION_POOL.getConnection();
        String allCustomerAccountsQuery = "SELECT c.id AS customer_id, c.name AS customer_name, a.id AS account_id, a.type AS account_type " +
                "FROM customers c INNER JOIN accounts a ON c.id = a.customer_id";
        try(PreparedStatement preparedStatement = connection.prepareStatement(allCustomerAccountsQuery)){
            ResultSet resultSet = preparedStatement.executeQuery();
            customers = mapCustomers(resultSet);
        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return customers;
    }

//    public Optional<Customer> findById(Long id){
//        Optional<Customer> result = Optional.empty();
//        Connection connection = CONNECTION_POOL.getConnection();
//        String findIdQuery = "SELECT c.name, c.phone_number FROM customers c WHERE id = ?";
//        try(PreparedStatement preparedStatement = connection.prepareStatement(findIdQuery)){
//            preparedStatement.setLong(1,id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            result = mapCustomer(resultSet);
//
//        }catch (SQLException e) {
//            LOGGER.error(e.getMessage());
//        } finally {
//            CONNECTION_POOL.releaseConnection(connection);
//        }
//        return result;
//    }

    @Override
    public void update(Customer customer){
        Connection connection = CONNECTION_POOL.getConnection();

        String updateCustomerQuery = "UPDATE customers SET name = ?, phone_number = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerQuery, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getPhoneNumber());
            preparedStatement.setLong (3,customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private static Optional<Customer> mapCustomer(ResultSet resultSet) throws SQLException {
        return mapCustomers(resultSet).stream()
                .findFirst();
    }

    private static List<Customer> mapCustomers(ResultSet resultSet) throws SQLException{
        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()){
            mapRow(resultSet, customers);
        }
        return customers;
    }

    public static void mapRow(ResultSet resultSet, List<Customer> customers) throws SQLException{
        customers.add(mapRow(resultSet));
    }

    public static Customer mapRow(ResultSet resultSet) throws SQLException {
        Customer customer = null;

        long id = resultSet.getLong("id");
        if (id != 0){
            customer = new Customer();
            customer.setId(id);
            customer.setName(resultSet.getString("name"));
            customer.setPhoneNumber(resultSet.getString("phone_number"));

            customer.setLoans(LoanDAO.mapRow(resultSet,customer.getLoans()));
            customer.setTransactions(TransactionDAO.mapRow(resultSet,customer.getTransactions()));
            customer.setAccounts(AccountDAO.mapRow(resultSet,customer.getAccounts()));

        }

        return customer;
    }



}