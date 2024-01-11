package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Loan;
import com.solvd.laba.persistence.LoanRepository;
import com.solvd.laba.service.LoanService;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.List;

public class LoanMyBatisDAO implements LoanRepository {
    @Override
    public void create(Loan loan, Long customerID) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            LoanRepository loanRepository = sqlSession.getMapper(LoanRepository.class);
            loanRepository.create(loan,customerID);
        }
    }

    @Override
    public List<Loan> findLoansAfter(LocalDate date) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            LoanRepository loanRepository = sqlSession.getMapper(LoanRepository.class);
            return loanRepository.findLoansAfter(date);
        }
    }

    @Override
    public void update(Loan loan) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            LoanRepository loanRepository = sqlSession.getMapper(LoanRepository.class);
            loanRepository.update(loan);
        }
    }

    @Override
    public Loan getLoanById(LoanService loanService, Long loanId) {
        return null;
    }

}
