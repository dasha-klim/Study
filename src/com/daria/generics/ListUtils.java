package com.daria.generics;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getFirstElement(List<T> list) {
        if(list.isEmpty()) {
            System.out.println("Empty list");
            return null;
        }
        // QUESTION: should we sort the list everytime we return an element?
        // Or just return the first element, without sorting?
        return list.stream().sorted().findFirst().get();
        //return list.get(0);
    }
}
