package com.daria.generics;

import java.util.ArrayList;
import java.util.List;

public class Container<T>{

    private final List<T> elements;

    public Container() {
        this.elements = new ArrayList<>();
    }


    public boolean addElement(T element) {
        return elements.add(element);
    }

    public T getElement() {
        if(elements.isEmpty()) {
            return null;
        } else {
            return elements.get(0);
        }
    }


}
