package com.solvd.laba.domain;

import java.time.LocalDate;
import java.util.List;

public class Statement {
    private Long id;
    private double startBalance;
    private double endBalance;
    private LocalDate openDate;
    private LocalDate endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(double startBalance) {
        this.startBalance = startBalance;
    }

    public double getEndBalance() {
        return endBalance;
    }

    public void setEndBalance(double endBalance) {
        this.endBalance = endBalance;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", startBalance=" + startBalance +
                ", endBalance='" + endBalance + '\'' +
                ", openDate=" + openDate +
                ", endDate=" + endDate +
                '}';
    }
}
