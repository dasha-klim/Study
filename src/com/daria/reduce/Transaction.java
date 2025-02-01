package com.daria.reduce;

import java.time.LocalDate;
public class Transaction {

    private LocalDate date;
    private Integer amount;
    private Type type;

    public Transaction(LocalDate date, Integer amount, Type type) {
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
