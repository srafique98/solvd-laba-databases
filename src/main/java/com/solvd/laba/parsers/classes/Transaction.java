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
public class Transaction {
    @XmlAttribute(name = "id")
    private Long id;
    private double amount;
    @JsonProperty("transactionType")
    @XmlElement(name = "transactionType")
    private String type;
    @JsonDeserialize(using = JsonAdapter.class)
    @XmlJavaTypeAdapter(MyAdapter.class)
    private LocalDate date;

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
