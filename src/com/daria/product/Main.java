package com.daria.product;

import com.daria.product.funcitonal.ProductAction;
import com.daria.product.funcitonal.ProductPredicate;
import com.daria.product.funcitonal.ProductTransformer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product chocolate = new Product("Chocolate", 5, "food");
        Product bacon = new Product("Bacon", 20, "food");
        Product bwm = new Product("Bwm", 300_000, "car");
        Product mercedes = new Product("Mercedes", 310_000, "cat");
        Product kettle = new Product("Kettle", 100, "kitchen appliances");
        Product toaster = new Product("Toaster", 100, "kitchen appliances");

        List<Product> products = List.of(chocolate, bacon, bwm, mercedes, kettle, toaster);

        ProductPredicate foodOnly = (product) -> product.category.equals("food");
        ProductPredicate lessThan150 = (product) -> product.price < 150;

        ProductAction printProductName = (product) -> System.out.print(product.name + " ");
        ProductAction printProductNameWithPrice = (product) -> System.out.println(product.name + " " + product.price);
        ProductAction reduce10PercentPrice = (product) -> {
            product.price = product.price - product.price * 0.1;
        };

        ProductTransformer sale20Percent = (product) ->  {
            product.price = product.price - product.price * 0.2;
            return product;
        };


          // if foodOnly extends Predicate, can be used with stream
//        List<Product> food = products.stream().filter(foodOnly).toList();
//        List<Product> cheaperThan150 = products.stream().filter(lessThan150).toList();

        System.out.print("Food: ");
        products.forEach(product -> {
           if(foodOnly.test(product)) {
               printProductName.execute(product);
           }
        });

        System.out.println();

        System.out.print("Cheap products: ");
        products.forEach(product -> {
            if(lessThan150.test(product)) {
                printProductName.execute(product);
            }
        });

        System.out.println();

        System.out.println("20% SALE");
        products.forEach(product -> {
          //  printProductNameWithPrice.execute(product);
            sale20Percent.apply(product);
            printProductNameWithPrice.execute(product);
        });



        System.out.println();

        System.out.println("10% MORE SALE");
        products.forEach(product -> {
            //printProductNameWithPrice.execute(product);
            reduce10PercentPrice.execute(product);
            printProductNameWithPrice.execute(product);
        });
    }
}
