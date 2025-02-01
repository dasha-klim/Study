package com.daria.product.funcitonal;

import com.daria.product.Product;

@FunctionalInterface
public interface ProductTransformer {

    Product apply(Product product);
}
