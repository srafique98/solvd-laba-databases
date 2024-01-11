package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Loan;
import com.solvd.laba.persistence.LoanRepository;
import com.solvd.laba.persistence.impl.LoanDAO;
import com.solvd.laba.persistence.mybatis.LoanMyBatisDAO;
import com.solvd.laba.service.LoanService;

import java.time.LocalDate;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    public LoanServiceImpl() {

//        this.loanRepository = new LoanDAO();
        this.loanRepository = new LoanMyBatisDAO();
    }

    @Override
    public Loan create(Loan loan, Long customerID) {
        loan.setId(null);
        loanRepository.create(loan, customerID);
        return loan;
    }

    @Override
    public List<Loan> retrieveAllLoansAfter(LocalDate date) {
        return loanRepository.findLoansAfter(date);
    }

    @Override
    public void update(Loan loan) {
        loanRepository.update(loan);
    }

    @Override
    public Loan getLoanById(LoanService loanService, Long loanId) {
        return loanRepository.getLoanById(loanService, loanId);
    }
}
