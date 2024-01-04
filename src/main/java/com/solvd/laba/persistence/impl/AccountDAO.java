package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Account;
import com.solvd.laba.persistence.AccountRepository;
import com.solvd.laba.persistence.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements AccountRepository {

    private static final Logger LOGGER = LogManager.getLogger(LoanDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Account account, Long customerID) {
        Connection connection = CONNECTION_POOL.getConnection();
        String createQuery = "INSERT INTO accounts (balance, type, opening_date, customer_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setString(2, account.getType());

            java.sql.Date sqlOpenDate = java.sql.Date.valueOf(account.getOpenDate());
            preparedStatement.setDate(3,sqlOpenDate);
            preparedStatement.setLong(4, customerID);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                account.setId(resultSet.getLong(1));
            }
            LOGGER.info("Account created: " + account.toString());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create Account", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public List<Account> findBalanceBiggerThan(double amount) {
        List<Account> accounts = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        String bigBalanceQuery = "SELECT a.id, a.type, a.opening_date, a.balance FROM accounts a WHERE balance > ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(bigBalanceQuery)){
            preparedStatement.setDouble(1, amount);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info("Query executed successfully!");
            accounts = mapAccounts(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return accounts;
    }

    @Override
    public void update(Account account) {
        Connection connection = CONNECTION_POOL.getConnection();
        String updateLoanQuery = "UPDATE accounts SET balance = ?, type = ?, opening_date = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateLoanQuery)){
            preparedStatement.setDouble(1,account.getBalance());
            preparedStatement.setString(2,account.getType());

            java.sql.Date sqlOpenDate = java.sql.Date.valueOf(account.getOpenDate());
            preparedStatement.setDate(3,sqlOpenDate);
            preparedStatement.setLong(4,account.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Account updated: {}", account.toString());

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }

    }

    private static List<Account> mapAccounts(ResultSet resultSet) throws SQLException{
        LOGGER.info("Mapping Accounts");
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()){
            mapRow(resultSet, accounts);
        }
        return accounts;
    }

    public static List<Account> mapRow(ResultSet resultSet, List<Account> accounts) throws SQLException{
        accounts.add(mapRow(resultSet));
        return accounts;
    }

    public static Account mapRow(ResultSet resultSet) throws SQLException {
        Account account = null;

        LOGGER.info("Mapping row with return Account");
        long id = resultSet.getLong("id");
        if (id != 0){
            account = new Account();
            account.setId(id);
            account.setBalance(resultSet.getDouble("balance"));
            account.setType(resultSet.getString("type"));

            java.sql.Timestamp startDateTimestamp = resultSet.getTimestamp("opening_date");
            account.setOpenDate(startDateTimestamp == null ? null : startDateTimestamp.toLocalDateTime().toLocalDate());

        }

        return account;
    }
}
