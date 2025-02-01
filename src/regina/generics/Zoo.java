package regina.generics;

import java.util.ArrayList;
import java.util.List;

//Task 5
// Objective: Combine knowledge of extends and super to manage a zoo simulation.
//Create a generic class Cage<T> for animals where T is a type that extends a base
//class Animal. Implement methods to addAnimal into the cage. Use upper bounds to
//ensure that only subtypes of Animal can be added.
//1. Implement an Animal class with subclasses Bird, Fish, and Mammal.
//2. Create a Cage<T> class where T extends Animal. Include methods
//like addAnimal(T animal) and getAnimal(int index).
//3. Write a utility method transferAnimals that moves animals from one cage to
//another. This method should accept parameters of Cage<? extends T> for source cage
//and Cage<? super T> for destination cage, ensuring proper use of PECS (Producer
//Extends, Consumer Super).

public class Zoo {
    static class Cage<T extends Animal> {
        List<T> animalsInCage = new ArrayList<>();

        public Cage(List<T> animalsInCage) {
            this.animalsInCage = animalsInCage;
        }

        public void addAnimal(T animal) {
            this.animalsInCage.add(animal);
        }

        public T getAnimal(int index) {
            if (animalsInCage.isEmpty()) {
                System.out.println("Cage is empty");
                return null;
            }
            return animalsInCage.get(index);
        }

        public List<T> getAnimalsInCage() {
            return animalsInCage;
        }
    }

    static class Animal {
        String name;
        String species;
        boolean isVegetarian;

        public Animal(String name, String species, boolean isVegetarian) {
            this.name = name;
            this.species = species;
            this.isVegetarian = isVegetarian;
        }

        public static void move() {
            System.out.println("Animal is moving from point a to point b");
        }

        public static void eat() {
            System.out.println("Animal is eating");
        }

        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    ", species='" + species + '\'' +
                    ", isVegetarian=" + isVegetarian +
                    '}';
        }
    }

    static class Bird extends Animal {
        boolean doesFly;

        public Bird(String name, String species, boolean isVegetarian, boolean doesFly) {
            super(name, species, isVegetarian);
            this.doesFly = doesFly;
        }

        public static void talk() {
            System.out.println("Squawk Squawk");
        }
    }

    static class Fish extends Animal {
        int numberOfFins;
        boolean livesInTheSea;

        public Fish(String name, String species, boolean isVegetarian, int numberOfFins, boolean livesInTheSea) {
            super(name, species, isVegetarian);
            this.numberOfFins = numberOfFins;
            this.livesInTheSea = livesInTheSea;
        }

        public static void move() {
            System.out.println("When I move, I swim");
        }
    }

    static class Mammal extends Animal {
        int numberOfLegs;

        public Mammal(String name, String species, boolean isVegetarian, int numberOfLegs) {
            super(name, species, isVegetarian);
            this.numberOfLegs = numberOfLegs;
        }

        public static void eat() {
            System.out.println("I'm a mammal and I like to eat yummy food");
        }
    }

    static class ZooUtils {
        public static <T extends Animal> void transferAnimals(Cage<? extends T> sourceCage, Cage<? super T> destinationCage) {
            sourceCage.getAnimalsInCage().forEach(destinationCage::addAnimal);
        }
    }
}

