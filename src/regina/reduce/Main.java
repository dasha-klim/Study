package regina.reduce;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        TransactionRecord pants = new TransactionRecord(LocalDate.parse("2025-01-25"), 25.99, "clothes");
        TransactionRecord shirts = new TransactionRecord(LocalDate.parse("2025-01-15"), 30.99, "clothes");
        TransactionRecord skirts = new TransactionRecord(LocalDate.parse("2025-01-10"), 50.99, "clothes");
        TransactionRecord earrings = new TransactionRecord(LocalDate.parse("2025-01-15"), 18.99, "accessories");
        TransactionRecord haibrush = new TransactionRecord(LocalDate.parse("2025-01-12"), 5.99, "accessories");
        TransactionRecord lipgloss = new TransactionRecord(LocalDate.parse("2025-01-18"), 10.99, "accessories");
        TransactionRecord cookies = new TransactionRecord(LocalDate.parse("2025-01-18"), 12.99, "food");
        TransactionRecord coffee = new TransactionRecord(LocalDate.parse("2025-01-18"), 5.99, "food");
        TransactionRecord pastries = new TransactionRecord(LocalDate.parse("2025-01-18"), 20.99, "food");

        List<TransactionRecord> transactions = List.of(pants, shirts, skirts, earrings, haibrush, lipgloss, cookies, coffee, pastries);

        //task 1
        // Objective: Use reduce to convert a list of Transactions (date, amount, type) into a TransactionSummary class,
        // then collect these summaries into a map grouped by type.

        Map<String, Double> totalAmountByCategory = transactions.stream()
                .collect(Collectors.groupingBy(TransactionRecord::getType,
                        Collectors.reducing(0.0, TransactionRecord::getAmount, Double::sum)));

        System.out.println(totalAmountByCategory);

        //task 2
        //Calculate the sum (10 / (list element)). For example, if your list is: 4, 5, 1, then the sum will be (10/4 + 10/5 + 10/1).
        // This needs to be done using streams, specifically with the use of reduce.
        // If by chance an element or some elements are zeros, the stream should not crash.
        // It should calculate the sum of all valid values.
        // Additionally, the result should not only provide the required sum but also indicate how many and what errors were encountered.
        // Think about the best way to accomplish this.

        List<Integer> elements = List.of(10, 4, 5, 3, 0, 2, 8, 0);

        ReducedListSummary reduced = elements.stream().reduce(new ReducedListSummary(), ((a, b) -> {
            if (b != 0) {
                a.setSum(a.getSum() + (b / 10.0));
            } else {
                a.setNumberOfErrors(a.getNumberOfErrors() + 1);

                String error = "value was 0 - unable to divide";
                a.getErrors().add(error);
            }
            return a;
        }), ((a, b) -> {
            a.setSum(a.getSum() + b.getSum());
            a.setNumberOfErrors(a.getNumberOfErrors() + b.getNumberOfErrors());
            a.getErrors().addAll(b.getErrors());

            return a;
        }));

        System.out.println(reduced);
    }

    static class ReducedListSummary {
        private double sum = 0;
        private int numberOfErrors = 0;
        private List<String> errors = new ArrayList<>();

        public ReducedListSummary() {
            this.sum = 0;
            this.numberOfErrors = 0;
            this.errors = new ArrayList<>();
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
        }

        public int getNumberOfErrors() {
            return numberOfErrors;
        }

        public void setNumberOfErrors(int numberOfErrors) {
            this.numberOfErrors = numberOfErrors;
        }

        public List<String> getErrors() {
            return errors;
        }

        public void setErrors(List<String> errors) {
            this.errors = errors;
        }

        @Override
        public String toString() {
            return "ReducedListSummary{" +
                    "sum=" + sum +
                    ", numberOfErrors=" + numberOfErrors +
                    ", errors=" + errors +
                    '}';
        }
    }
}

