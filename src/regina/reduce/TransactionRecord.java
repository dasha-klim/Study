package regina.reduce;

import java.time.LocalDate;

public class TransactionRecord {
    private LocalDate date;
    private double amount;
    private String type;

    public TransactionRecord(LocalDate date, double amount, String type) {
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
}
