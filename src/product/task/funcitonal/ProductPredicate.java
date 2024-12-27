package product.task.funcitonal;

import product.task.Product;

import java.util.function.Predicate;

@FunctionalInterface
public interface ProductPredicate /*extends Predicate<Product>*/ {

    boolean test(Product product);
}
