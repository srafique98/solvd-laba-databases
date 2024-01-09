package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.Statement;

import java.util.Optional;

public interface StatementRepository {
    void create(Statement statement, Long accountID);
    Optional<Statement> findById(Long id);
    void update(Statement statement);


}
