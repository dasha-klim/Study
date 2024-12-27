package product.task.funcitonal;

import product.task.Product;

@FunctionalInterface
public interface ProductTransformer {

    Product apply(Product product);
}
