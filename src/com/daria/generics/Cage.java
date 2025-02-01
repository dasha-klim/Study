package com.daria.generics;

import com.daria.generics.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class Cage <T extends Animal> {
    List<T> zoo;

    public Cage() {
        this.zoo = new ArrayList<>();
    }


    void addAnimal(T animal) {
        zoo.add(animal);
    }

    T getAnimal(int index) {
        if(zoo.isEmpty() || zoo.size() <= index) {
            return null;
        } else {
            return zoo.get(index);
        }
    }

    public List<T> getAnimals() {
        return zoo;
    }
}
