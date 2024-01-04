package com.solvd.laba.service;

import com.solvd.laba.domain.Loan;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    List<Loan> retrieveAllLoansAfter(LocalDate date);
    Loan create(Loan loan, Long customerID);
    void update(Loan loan);
    Loan getLoanById(LoanService loanService, Long loanId);
}
