package com.solvd.laba.parsers.classes;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.laba.parsers.jaxb.MyAdapter;
import com.solvd.laba.parsers.json.JsonAdapter;
import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @XmlAttribute(name = "id")
    private Long id;
    private double balance;
    @JsonProperty("accountType")
    @XmlElement(name = "accountType")
    private String type;
    @JsonDeserialize(using = JsonAdapter.class)
    @JsonProperty("AccountOpenDate")
    @XmlElement(name = "AccountOpenDate")
    @XmlJavaTypeAdapter(MyAdapter.class)
    private LocalDate openDate;
    @XmlElementWrapper(name = "statements")
    @XmlElement(name = "statement")
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
