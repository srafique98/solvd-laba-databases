package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Statement;
import com.solvd.laba.persistence.StatementRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class StatementMyBatisDAO implements StatementRepository {
    @Override
    public void create(Statement statement, Long accountID) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            StatementRepository statementRepository = sqlSession.getMapper(StatementRepository.class);
            statementRepository.create(statement,accountID);
        }
    }

    @Override
    public Optional<Statement> findById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            StatementRepository statementRepository = sqlSession.getMapper(StatementRepository.class);
            return statementRepository.findById(id);
        }
    }

    @Override
    public void update(Statement statement) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            StatementRepository statementRepository = sqlSession.getMapper(StatementRepository.class);
            statementRepository.update(statement);
        }
    }
}
