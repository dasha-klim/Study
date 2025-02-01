package com.daria.generics.animal;

public class Mammal extends Animal{

    public Mammal(String name, String spices, String dietType) {
        super(name, spices, dietType);
    }

    @Override
    void move() {
        System.out.println(species + " " + name + " walks");
    }

}
