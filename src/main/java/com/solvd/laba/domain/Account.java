package com.solvd.laba.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long id;
    private double balance;
    private String type;
    private LocalDate openDate;
    private List<Statement> statements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", type='" + type + '\'' +
                ", openDate=" + openDate +
                ", statements=" + statements +
                '}';
    }
}
