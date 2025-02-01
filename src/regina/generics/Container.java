package regina.generics;

import java.util.ArrayList;
import java.util.List;

//task1:
//Objective: Create a generic class Container that can store any type of elements.
//        Implement the methods addElement(T element) and getElement() in it.

public class Container<T> {
    List<T> elements = new ArrayList<>();

    public Container(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T element) {
        this.elements.add(element);
    }

    public T getElement(T element) {
        if (elements.isEmpty()) {
            return null;
        } else {
           return elements.stream().filter(el -> el.equals(element)).toList().getFirst();
        }
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}
