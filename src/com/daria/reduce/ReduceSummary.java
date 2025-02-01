package com.daria.reduce;

import java.util.ArrayList;
import java.util.List;

public class ReduceSummary {
    private int count;

    private double sum;
    List<String> errors;

    public ReduceSummary() {
        count = 0;
        sum = 0;
        errors = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ReduceSummary{" +
                "count=" + count +
                ", sum=" + sum +
                ", errors=" + errors +
                '}';
    }
}
