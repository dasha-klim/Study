package com.daria.generics.animal;

public class Bird extends Animal{

    public Bird(String name, String spices, String dietType) {
    super(name, spices, dietType);
    }

    @Override
    void move() {
        System.out.println(species + " " + name + " flies");
    }
}
