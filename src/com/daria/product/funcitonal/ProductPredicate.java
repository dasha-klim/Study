package com.daria.product.funcitonal;

import com.daria.product.Product;

@FunctionalInterface
public interface ProductPredicate /*extends Predicate<Product>*/ {

    boolean test(Product product);
}
