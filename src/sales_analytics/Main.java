package sales_analytics;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        SaleRecord coffee = new SaleRecord("1", 1L, "Coffee", 2, 30);
        SaleRecord coffee2 = new SaleRecord("2", 1L, "Coffee", 1, 15);

        SaleRecord shampoo = new SaleRecord("3", 2L, "Shampoo", 1, 10.3);
        SaleRecord shampoo2 = new SaleRecord("4", 2L, "Shampoo", 4, 41.2);
        SaleRecord shampoo3 = new SaleRecord("5", 2L, "Shampoo", 2, 20.6);

        SaleRecord lipstick = new SaleRecord("6", 3L, "Lipstick", 1, 5.5);
        SaleRecord lipstick2 = new SaleRecord("7", 3L, "Lipstick", 1, 5.5);

        SaleRecord tuna = new SaleRecord("8", 4L, "Tuna", 1, 6.2);

        SaleRecord lamp = new SaleRecord("9", 5L, "Lamp", 3, 75);

        SaleRecord yogurt = new SaleRecord("10", 6L, "Yogurt", 5, 21);
        SaleRecord yogurt2 = new SaleRecord("11", 6L, "Yogurt", 3, 12.6);

        List<SaleRecord> records = List.of(coffee, coffee2, shampoo, shampoo2, shampoo3, lipstick, lipstick2, tuna, lamp, yogurt, yogurt2);

        // 1. Aggregate Sales:
        Double totalSales = records.stream().map(SaleRecord::getSaleAmount).reduce(0d, Double::sum);
        System.out.println("Total sales: " + totalSales);

        // 2. Product Sales Analysis:
        // a. total sales quantity for each product
        Map<String, Double> productNameTotalSales = records.stream().collect(Collectors.groupingBy(
                SaleRecord::getProductName,
                Collectors.summingDouble(SaleRecord::getSaleAmount)
        ));
        System.out.println("product -> total sales: " + productNameTotalSales);

        //b. Find the product with the highest total sales amount
        Map.Entry<String, Double> stringDoubleEntry = productNameTotalSales.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(1).findFirst().get();
        System.out.println("product with highest sale: " + stringDoubleEntry);

        //3. Filter and Sort Operations:
        // a. Filter records to find all transactions involving a specific product.
        List<SaleRecord> shampoos = records.stream().filter(rec -> rec.getProductId() == 2).toList();
        System.out.println("All shampoo productes: ");
        shampoos.forEach(prod -> System.out.print(prod.getProductName() + " " + prod.getTransactionId() + " "));


        System.out.println();
        System.out.println("records by saleAmount, desc");
        // b. Sort these records by saleAmount in descending order.
        productNameTotalSales.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(System.out::println);

        //4. Advanced Analysis:
        // a. Calculate the average sale amount per transaction.
        // ???

        //b. Identify the productId which appears most frequently across all transactions.
        Optional<Map.Entry<Long, Long>> mostOftenProdId = records.stream()
                .collect(Collectors.groupingBy(record -> record.getProductId(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue());
        System.out.println("Most often prod id " + mostOftenProdId.get().getKey());


    }



}
