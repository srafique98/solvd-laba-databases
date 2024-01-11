package com.solvd.laba.persistence;

import com.solvd.laba.domain.Loan;
import com.solvd.laba.service.LoanService;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface LoanRepository {

    void create(@Param("loan") Loan loan, @Param("customerID") Long customerID);
    List<Loan> findLoansAfter(LocalDate date);
    void update(Loan loan);
    Loan getLoanById(LoanService loanService, Long loanId);

}
