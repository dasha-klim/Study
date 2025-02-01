package com.daria.reduce;

import java.time.LocalDate;

public class TransactionSummary {
    private double sum;

    private int count;
    private Type type;

    public TransactionSummary() {}

    public TransactionSummary(double sum, Type type) {
        this.sum = sum;
        this.type = type;
        count = 1;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Type " + type + " sum " + sum + " count " + count;
    }
}
