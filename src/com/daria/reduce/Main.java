package com.daria.reduce;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        // Reduce - Task 1: Reduce and Collect
        // Objective: Use reduce to convert a list of Transactions (date, amount, type)
        // into a TransactionSummary class, then collect these summaries into a map grouped by type.
        List<Transaction> transactions = getTransactions();
        ArrayList<TransactionSummary> transactionSummaries = transactions.stream().reduce(new ArrayList<TransactionSummary>(), (list, tr2) -> {
            Optional<TransactionSummary> first = list.stream().filter(tr -> tr.getType() == tr2.getType()).findFirst();
            if (first.isPresent()) {
                TransactionSummary transactionSummary = first.get();
                transactionSummary.setSum(transactionSummary.getSum() + tr2.getAmount());
                transactionSummary.setCount(transactionSummary.getCount() + 1);
            } else {
                list.add(new TransactionSummary(tr2.getAmount(), tr2.getType()));
            }
            return list;
        }, (list1, list2) -> list1);
        System.out.println("Transaction Summaries" + transactionSummaries);

        Map<Type, List<TransactionSummary>> collect = transactionSummaries.stream().collect(Collectors.groupingBy((TransactionSummary::getType)));
        System.out.println("Collect " + collect);

        // Task 2
        //Calculate the sum (10 / (list element)).
        // For example, if your list is: 4, 5, 1, then the sum will be (10/4 + 10/5 + 10/1).
        // This needs to be done using streams, specifically with the use of reduce.
        // If by chance an element or some elements are zeros, the stream should not crash.
        // It should calculate the sum of all valid values.
        // Additionally, the result should not only provide the required sum but also indicate how many and what errors were encountered.


        ReduceSummary reduceRecord = Stream.of(4, 5, 0, 1, 0, 5)
                .reduce(new ReduceSummary(), (reduceSummary, num) -> {
                    // dividing double by 0 won't result in an exception, it will return 'infinity' therefore checking manually
                    if(num == 0) {
                        reduceSummary.setCount(reduceSummary.getCount() + 1);
                        reduceSummary.getErrors().add("Division by zero");
                    } else {
                        reduceSummary.setSum(reduceSummary.getSum() + 10d / num);
                    }
                    return reduceSummary;

                }, (reduceSummary, reduceSummary2) -> {
                    reduceSummary.setCount(reduceSummary.getCount() + reduceSummary2.getCount());
                    reduceSummary.setSum(reduceSummary.getSum() + reduceSummary2.getSum());
                    reduceSummary.getErrors().addAll(reduceSummary2.getErrors());
                    return reduceSummary;
                });

        System.out.println("reduce " + reduceRecord);

    }

    private static List<Transaction> getTransactions() {
        return List.of(
                new Transaction(LocalDate.of(2025, 1,15), 2000, Type.CASH),
                new Transaction(LocalDate.of(2025, 1,16), 1000, Type.CASH),
                new Transaction(LocalDate.of(2025, 1,12), 2500, Type.PAYMENT),
                new Transaction(LocalDate.of(2025, 1,10), 5000, Type.PAYMENT),
                new Transaction(LocalDate.of(2025, 1,11), 7200, Type.PAYMENT),
                new Transaction(LocalDate.of(2025, 1,10), 25000, Type.BUSINESS),
                new Transaction(LocalDate.of(2025, 1,11), 41000, Type.BUSINESS),
                new Transaction(LocalDate.of(2025, 1,13), 10000, Type.CREDIT),
                new Transaction(LocalDate.of(2025, 1,14), 23500, Type.CREDIT),
                new Transaction(LocalDate.of(2025, 1,15), 5000, Type.CREDIT),
                new Transaction(LocalDate.of(2025, 1,12), 2600, Type.PERSONAL),
                new Transaction(LocalDate.of(2025, 1,13), 1400, Type.PERSONAL),
                new Transaction(LocalDate.of(2025, 1,15), 7500, Type.PERSONAL)
        );
    }
}
