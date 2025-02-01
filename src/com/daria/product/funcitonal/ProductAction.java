package com.daria.product.funcitonal;

import com.daria.product.Product;

@FunctionalInterface
public interface ProductAction {

    void execute(Product product);
}
