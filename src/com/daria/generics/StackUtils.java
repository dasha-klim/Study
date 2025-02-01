package com.daria.generics;

import java.util.Collection;
import java.util.Stack;

public class StackUtils {

    public static <T> void pushAll(Stack<? super T> stack, Collection<? extends T> collection) {
        stack.addAll(collection);
    }
}
