package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.exception.ResourceNotFoundException;
import com.solvd.laba.persistence.CustomerRepository;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class PersistenceConfig {

    private static final SqlSessionFactory sessionFactory;
    static {
        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml");) {
             sessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }
}










