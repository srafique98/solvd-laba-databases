package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Transaction;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.TransactionRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionDAO implements TransactionRepository {
    private static final Logger LOGGER = LogManager.getLogger(TransactionDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Transaction transaction, Long customerId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String createQuery = "INSERT INTO transactions (amount, type, date, customer_id) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setDouble(1, transaction.getAmount());
            preparedStatement.setString(2,transaction.getType());
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(transaction.getDate());
            preparedStatement.setDate(3,sqlStartDate );
            preparedStatement.setLong(4, customerId);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                transaction.setId(resultSet.getLong(1));
            }
            LOGGER.info("Transaction created: " + transaction.toString());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create Transaction", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Transaction> findById(Long id){
        Optional<Transaction> result = Optional.empty();
        Connection connection = CONNECTION_POOL.getConnection();
        String findIdQuery = "SELECT t.id AS transaction_id, t.amount AS transaction_amount, t.type AS transaction_type, t.date AS transaction_date FROM transactions t WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(findIdQuery)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = mapTransaction(resultSet);

        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public void update(Transaction transaction){
        Connection connection = CONNECTION_POOL.getConnection();
        String updateTransactionQuery = "UPDATE transactions SET amount = ?, type = ?, date = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateTransactionQuery, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setDouble(1,transaction.getAmount());
            preparedStatement.setString(2,transaction.getType());
            java.sql.Date sqlDate = java.sql.Date.valueOf(transaction.getDate());
            preparedStatement.setDate(3,sqlDate);
            preparedStatement.setLong(4, transaction.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private static Optional<Transaction> mapTransaction(ResultSet resultSet) throws SQLException {
        return mapTransactions(resultSet).stream()
                .findFirst();
    }

    private static List<Transaction> mapTransactions(ResultSet resultSet) throws SQLException{
        List<Transaction> transaction = new ArrayList<>();
        while (resultSet.next()){
            mapRow(resultSet, transaction);
        }
        return transaction;
    }

    public static List<Transaction> mapRow(ResultSet resultSet, List<Transaction> transactions) throws SQLException{
        if (transactions == null){
            transactions = new ArrayList<>();
        }
        transactions.add(mapRow(resultSet));
        return transactions;
    }

    public static Transaction mapRow(ResultSet resultSet) throws SQLException {
        Transaction transaction = null;
        long id = resultSet.getLong("transaction_id");
        if (id != 0){
            transaction = new Transaction();
            transaction.setId(id);
            transaction.setAmount(resultSet.getDouble("transaction_amount"));
            transaction.setType(resultSet.getString("transaction_type"));
            java.sql.Timestamp Timestamp = resultSet.getTimestamp("transaction_date");
            transaction.setDate(Timestamp == null ? null : Timestamp.toLocalDateTime().toLocalDate());
        }
        return transaction;
    }
}
