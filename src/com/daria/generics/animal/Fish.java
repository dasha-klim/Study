package com.daria.generics.animal;

public class Fish extends Animal{

    public Fish(String name, String spices, String dietType) {
        super(name, spices, dietType);
    }

    @Override
    void move() {
        System.out.println(species + " " + name + " swims");
    }
}
