package regina.generics;

//Task 4
// Objective: Create a class StackUtils with a method pushAll that takes two parameters: a
//stack (Stack<? super T>) and a collection (Collection<? extends T>). This method should
//push all elements from the collection into the stack. To test, use a Stack<Number> and
//a List<Integer>.

import java.util.Collection;
import java.util.Stack;

public class StackUtils {
    public static <T> void pushAll(Stack<? super T> stack, Collection<? extends T> collection) {
        stack.addAll(collection);
    }
}
