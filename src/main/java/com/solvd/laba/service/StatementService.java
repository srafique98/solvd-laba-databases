package com.solvd.laba.service;

import com.solvd.laba.domain.Statement;

import java.util.Optional;

public interface StatementService {
    void update(Statement statement);
    void create(Statement statement, Long accountID);
    Optional<Statement> findById(Long id);
}
