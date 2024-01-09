package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Loan;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.LoanRepository;
import com.solvd.laba.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO implements LoanRepository {
    private static final Logger LOGGER = LogManager.getLogger(LoanDAO.class);
    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void create(Loan loan, Long customerId) {
        Connection connection = CONNECTION_POOL.getConnection();
        String createQuery = "INSERT INTO loans (amount, type, interest_rate, start_date, end_date, customer_id) VALUES (?, ?, ?, ?, ?, ?)";
        LOGGER.info("0");
        try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS)){
            LOGGER.info("1");
            preparedStatement.setDouble(1, loan.getAmount());
            preparedStatement.setString(2, loan.getType());
            preparedStatement.setDouble(3, loan.getInterestRate());
            LOGGER.info("2");
            java.sql.Date sqlStartDate = java.sql.Date.valueOf(loan.getStartDate());
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(loan.getEndDate());
            preparedStatement.setDate(4,sqlStartDate );
            preparedStatement.setDate(5, sqlEndDate);
            preparedStatement.setLong(6, customerId);
            LOGGER.info("3");
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                LOGGER.info("4");
                loan.setId(resultSet.getLong(1));
            }
            LOGGER.info("Loan created: " + loan.toString());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Unable to create loan", e);
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
    }


    @Override
    public List<Loan> findLoansAfter(LocalDate date) {
        List<Loan> loans = new ArrayList<>();
        Connection connection = CONNECTION_POOL.getConnection();
        String afterDateQuery = "SELECT l.id AS loan_id, l.type AS loan_type, l.amount AS loan_amount, l.interest_rate AS loan_interest_rate, l.start_date AS loan_start_date, l.end_date AS loan_end_date FROM loans l WHERE start_date > ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(afterDateQuery)){
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            preparedStatement.setDate(1, sqlDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            LOGGER.info("Date Query executed successfully!");
            loans = mapLoans(resultSet);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            CONNECTION_POOL.releaseConnection(connection);
        }
        return loans;
    }

    @Override
    public void update(Loan loan) {
        Connection connection = CONNECTION_POOL.getConnection();
        String updateLoanQuery = "UPDATE loans SET amount = ?, interest_rate = ?, type = ?, end_date = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateLoanQuery)){
            preparedStatement.setDouble(1,loan.getAmount());
            preparedStatement.setDouble(2,loan.getInterestRate());
            preparedStatement.setString(3,loan.getType());
            java.sql.Date sqlEndDate = java.sql.Date.valueOf(loan.getEndDate());
            preparedStatement.setDate(4,sqlEndDate);
            preparedStatement.setLong(5,loan.getId());
            preparedStatement.executeUpdate();

            LOGGER.info("Loan updated: {}", loan.toString());

        } catch (SQLException e) {
        LOGGER.error(e.getMessage());
    } finally {
        CONNECTION_POOL.releaseConnection(connection);
    }
    }

    @Override
    public Loan getLoanById(LoanService loanService, Long loanId) {
        List<Loan> loans = loanService.retrieveAllLoansAfter(LocalDate.of(2020, 1, 1));
        return loans.stream()
                .filter(loan -> loan.getId().equals(loanId))
                .findFirst()
                .orElse(null);
    }

    private static List<Loan> mapLoans(ResultSet resultSet) throws SQLException{
        LOGGER.info("Mapping Loans");
        List<Loan> loans = new ArrayList<>();
        while (resultSet.next()){
            mapRow(resultSet, loans);
        }
        return loans;
    }

    public static List<Loan> mapRow(ResultSet resultSet, List<Loan> loans) throws SQLException{
        if (loans == null){
            loans = new ArrayList<>();
        }
        loans.add(mapRow(resultSet));
        return loans;
    }

    public static Loan mapRow(ResultSet resultSet) throws SQLException {
        Loan loan = null;

        LOGGER.info("Mapping row with return Loan");
        long id = resultSet.getLong("loan_id");
        if (id != 0){
            loan = new Loan();
            loan.setId(id);
            loan.setAmount(resultSet.getDouble("loan_amount"));
            loan.setInterestRate(resultSet.getDouble("loan_interest_rate"));
            loan.setType(resultSet.getString("loan_type"));

            java.sql.Timestamp startDateTimestamp = resultSet.getTimestamp("loan_start_date");
            loan.setStartDate(startDateTimestamp == null ? null : startDateTimestamp.toLocalDateTime().toLocalDate());

            java.sql.Timestamp endDateTimestamp = resultSet.getTimestamp("loan_end_date");
            loan.setEndDate(endDateTimestamp == null ? null : endDateTimestamp.toLocalDateTime().toLocalDate());
        }

        return loan;
    }


}
