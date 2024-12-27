package sales_analytics;

import java.util.Objects;

public class SaleRecord {
    String transactionId;
    Long productId;
    String productName;
    int quantity;
    double saleAmount;

    public SaleRecord(String transactionId, Long productId, String productName, int quantity, double saleAmount) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.saleAmount = saleAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleRecord that = (SaleRecord) o;
        return quantity == that.quantity && Double.compare(saleAmount, that.saleAmount) == 0 && Objects.equals(transactionId, that.transactionId) && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, productId, productName, quantity, saleAmount);
    }
}
