package com.solvd.laba.parsers.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.laba.parsers.jaxb.MyAdapter;
import com.solvd.laba.parsers.json.JsonAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Loan {
    @XmlAttribute(name = "id")
    private Long id;
    @JsonProperty("loanAmount")
    @XmlElement(name = "loanAmount")
    private double amount;
    private double interestRate;
    @JsonProperty("loanType")
    @XmlElement(name = "loanType")
    private String type;
    @JsonDeserialize(using = JsonAdapter.class)
    @XmlJavaTypeAdapter(MyAdapter.class)
    private LocalDate startDate;
    @JsonDeserialize(using = JsonAdapter.class)
    @JsonProperty("closeDate")
    @XmlElement(name = "closeDate")
    @XmlJavaTypeAdapter(MyAdapter.class)
    private LocalDate endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", type='" + type + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
