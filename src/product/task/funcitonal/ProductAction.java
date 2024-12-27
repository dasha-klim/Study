package product.task.funcitonal;

import product.task.Product;

import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
public interface ProductAction {

    void execute(Product product);
}
