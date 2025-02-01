package com.daria.generics.animal;

public abstract class Animal {

    String name;
    String species;
    String dietType;

    public Animal(String name, String species, String dietType) {
        this.name = name;
        this.species = species;
        this.dietType = dietType;
    }

    abstract void move();
    public void eat(){
        System.out.println(species + " " + name + " eats");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", dietType='" + dietType + '\'' +
                '}';
    }
}
