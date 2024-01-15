package com.solvd.laba.parsers.classes;

import com.solvd.laba.parsers.jaxb.MyAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statement {
    @XmlAttribute(name = "id")
    private Long id;
    private double startBalance;
    private double endBalance;
    @XmlJavaTypeAdapter(MyAdapter.class)
    private LocalDate openDate;
    @XmlJavaTypeAdapter(MyAdapter.class)
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
