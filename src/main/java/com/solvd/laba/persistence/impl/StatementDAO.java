package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Statement;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.StatementRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StatementDAO implements StatementRepository {
    private static final Logger LOGGER = LogManager.getLogger(StatementDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Statement statement, Long accountID) {
        Connection connection = CONNECTION_POOL.getConnection();
        String createQuery = "INSERT INTO statements (start_date, end_date, starting_balance, ending_balance, account_id) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery, java.sql.Statement.RETURN_GENERATED_KEYS)){
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(statement.getOpenDate());
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(statement.getEndDate());
            preparedStatement.setDate(1,sqlStartDate );
            preparedStatement.setDate(2, sqlEndDate);

            preparedStatement.setDouble(3, statement.getStartBalance());
            preparedStatement.setDouble(4, statement.getEndBalance());
            preparedStatement.setLong(5, accountID);

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                statement.setId(resultSet.getLong(1));
            }
            LOGGER.info("Statement created: " + statement.toString());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create statement", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    @Override
    public Optional<Statement> findById(Long id){
        Optional<Statement> result = Optional.empty();
        Connection connection = CONNECTION_POOL.getConnection();
        String findIdQuery = "SELECT s.start_date AS statement_start_date, s.end_date AS statement_end_date, s.starting_balance AS statement_starting_balance, s.ending_balance AS statement_ending_balance, s.id AS statement_id FROM statements s WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(findIdQuery)){
            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            result = mapStatement(resultSet);

        }catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return result;
    }

    @Override
    public void update(Statement statement) {
        Connection connection = CONNECTION_POOL.getConnection();
        String updateStatementQuery = "UPDATE statements SET start_date = ?, end_date = ?, starting_balance = ?, ending_balance = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateStatementQuery)){
            java.sql.Date sqlOpenDate = java.sql.Date.valueOf(statement.getOpenDate());
            preparedStatement.setDate(1,sqlOpenDate);
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(statement.getOpenDate());
            preparedStatement.setDate(2,sqlEndDate);

            preparedStatement.setDouble(3,statement.getStartBalance());
            preparedStatement.setDouble(4,statement.getEndBalance());
            preparedStatement.setLong(5,statement.getId());

            preparedStatement.executeUpdate();
            LOGGER.info("Statement updated: {}", statement.toString());

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }

    private static Optional<Statement> mapStatement(ResultSet resultSet) throws SQLException {
        LOGGER.info("Optional Map Sttements!");
        return mapStatements(resultSet).stream()
                .findFirst();
    }

    private static List<Statement> mapStatements(ResultSet resultSet) throws SQLException{
        List<Statement> statements = new ArrayList<>();
        while (resultSet.next()){
            mapRow(resultSet, statements);
        }
        return statements;
    }

    public static List<Statement> mapRow(ResultSet resultSet, List<Statement> statements) throws SQLException{
        if (statements == null) {
            statements = new ArrayList<>();
        }
        LOGGER.info("map Row for StatementDAO");
        statements.add(mapRow(resultSet));
        return statements;
    }

    public static Statement mapRow(ResultSet resultSet) throws SQLException {
        LOGGER.info("Statement map Row");
        Statement statement = null;

        long id = resultSet.getLong("statement_id");
        if (id != 0){
            statement = new Statement();
            statement.setId(id);
            statement.setStartBalance(resultSet.getDouble("statement_starting_balance"));
            statement.setEndBalance(resultSet.getDouble("statement_ending_balance"));

            java.sql.Timestamp startDateTimestamp = resultSet.getTimestamp("statement_start_date");
            statement.setOpenDate(startDateTimestamp == null ? null : startDateTimestamp.toLocalDateTime().toLocalDate());

            java.sql.Timestamp endDateTimestamp = resultSet.getTimestamp("statement_end_date");
            statement.setEndDate(endDateTimestamp == null ? null : endDateTimestamp.toLocalDateTime().toLocalDate());
        }

        return statement;
    }
}
