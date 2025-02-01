package com.daria.streams;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //TASK1 - REDUCE Sum of Discounted Product Prices
        List<Double> productPrices = Arrays.asList(100.0, 200.0, 150.0, 50.0, 80.0, -100.0);
        Double sum = productPrices.parallelStream().reduce(0d, Double::sum);
        System.out.println("Sum " + sum);
        double discount = 0.2;
        Double sumWithSale = productPrices.stream().reduce(0d,
            (acc, value) -> {
                double v = value - (value * discount);
                return acc + v;
        });
        System.out.println("Sum with sale " + sumWithSale);

        Double sumWithConditions= productPrices.stream().reduce(0d,
                (acc, val) -> val <= 0 ? acc : acc + (val - val * discount),
                (Double::sum));

        System.out.println("Sum with condition " + sumWithConditions);

        // TASK2 – STREAMS
        // DONE in com.daria.sales_analytics -> Main


        // TASK3 – ADVANCED REDUCE
        List<SaleRecordRegion> salesData = Arrays.asList(
                new SaleRecordRegion(12000, "Europe"),
                new SaleRecordRegion(18000, "Asia"),
                new SaleRecordRegion(2500, "Europe"),
                new SaleRecordRegion(30000, "North America"),
                new SaleRecordRegion(16500, "Asia"),
                new SaleRecordRegion(8000, "Europe"),
                new SaleRecordRegion(20500, "North America")
        );

        Map<String, Double> totalRevenueByRegion = salesData.parallelStream()
                .reduce(new HashMap<>(),
                    (acc, saleRecord) -> {
//                        System.out.println("acc " + acc);
//                        System.out.println("val " + saleRecord);
                        double currentSum = acc.getOrDefault(saleRecord.region, 0d);
                        currentSum += saleRecord.revenue;
                        acc.put(saleRecord.region, currentSum);
                        return acc;
                    },
                    (map1, map2)-> {
                    // looks like maps are already containing correct data, merging the will cause incorrect data?
//                        System.out.println("val1 " + map1);
//                        System.out.println("val2 " + map2);
                        return map1;
                    });

        // this is chat gpt version, but seems to be more complicated than it should be
//        Map<String, Double> totalRevenueByRegion = salesData.parallelStream()
//                .com.daria.regina.reduce(
//                        new HashMap<>(),
//                        (acc, saleRecord) -> {
//                            HashMap<String, Double> newAcc = new HashMap<>(acc);
//                            newAcc.merge(saleRecord.region, saleRecord.revenue, Double::sum);
//                            return newAcc;
//                        },
//                        (map1, map2) -> {
//                            HashMap<String, Double> mergedMap = new HashMap<>(map1);
//                            map2.forEach((region, revenue) ->
//                                    mergedMap.merge(region, revenue, Double::sum));
//                            return mergedMap;
//                        }
//                );

        String highestRevenueRegion = totalRevenueByRegion.entrySet().stream()
                .reduce(new SaleRecordRegion(0d, ""), (rec1, rec2) -> {
            if(rec1.revenue > rec2.getValue()) {
                return rec1;
            } else {
                return new SaleRecordRegion(rec2.getValue(), rec2.getKey());
            }

        }, (val1, val2) -> {
            if(val1.revenue > val2.revenue) {
                return val1;
            } else {
                return val2;
            }
        }).region;

        System.out.println("Total revenue by region: " + totalRevenueByRegion);
        System.out.println("Region with highest revenue: " + highestRevenueRegion);

    }
}
