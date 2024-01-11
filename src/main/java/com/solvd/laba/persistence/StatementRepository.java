package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.Statement;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface StatementRepository {
    void create(@Param("statement") Statement statement, @Param("accountID") Long accountID);
    Optional<Statement> findById(Long id);
    void update(Statement statement);


}
