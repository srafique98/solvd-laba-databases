package com.solvd.laba.domain;

import java.time.LocalDate;

public class Transaction {
    private long id;
    private double amount;
    private String type;
    private LocalDate date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", date=" + date +
                '}';
    }
}
