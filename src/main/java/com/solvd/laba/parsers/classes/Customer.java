package com.solvd.laba.parsers.classes;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD) // will use annotation from fields not from getters and setters (by default Jaxb uses annotations from getters and setters)
public class Customer {
    @XmlAttribute(name = "id")
    private Long id;
    private String name;
    private String phoneNumber;

    @XmlElementWrapper(name = "transactions") // tags from customer.xml
    @XmlElement(name = "transaction")
    private List<Transaction> transactions;
    @XmlElementWrapper(name = "accounts")
    @XmlElement(name = "account")
    private List<Account> accounts;
    @XmlElementWrapper(name = "loans")
    @XmlElement(name = "loan")
    private List<Loan> loans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Customer {").append("\n  id=").append(id).append("\n  name='").append(name).append('\'')
                .append("\n  phoneNumber='").append(phoneNumber).append('\'');

        if (transactions != null) {
            stringBuilder.append("\n  Transactions [");
            for (Transaction transaction : transactions) {
                stringBuilder.append("\n    ").append(transaction);
            }
            stringBuilder.append("\n  ]");
        }
        if (accounts != null) {
            stringBuilder.append("\n  Accounts [");
            for (Account account : accounts) {
                stringBuilder.append("\n    ").append(account);
            }
            stringBuilder.append("\n  ]");
        }
        if (loans != null) {
            stringBuilder.append("\n  Loans [");
            for (Loan loan : loans) {
                stringBuilder.append("\n    ").append(loan);
            }
            stringBuilder.append("\n  ]");
        }
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

}

