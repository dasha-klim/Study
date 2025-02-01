package com.daria.generics;

import com.daria.generics.animal.Animal;
import com.daria.generics.animal.Bird;
import com.daria.generics.animal.Fish;
import com.daria.generics.animal.Mammal;

import java.math.BigDecimal;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //Task 1: generic class Container
        Container<Integer> container = new Container<>();
        container.addElement(15);
        container.addElement(16);
        Integer element = container.getElement();
        System.out.println("Element " + element);

        // Task 2: Generic Method printArray
        printArray(new Integer[]{3,5,7});
        printArray(new String[]{"Hello","world","!"});


        //Task 3: Using extends with Generics
        //Objective: Implement a method getFirstElement in a class called ListUtils.
        // This method should accept a List of any type that extends Comparable and returns the first element of the list.
        // Test this method with a List<String> and a List<Integer>.
        List<String> list = List.of("Hello", "Java", "World", "!");
        String firstElement = ListUtils.getFirstElement(list);
        System.out.println("First string " + firstElement);

        List<Integer> numbers = List.of(5,4,3,2,1);
        Integer firstNum = ListUtils.getFirstElement(numbers);
        System.out.println("First number " + firstNum);

        //Task 4: Using super with Generics (Medium to Hard)
        //Objective: Create a class StackUtils with a method pushAll that takes two parameters:
        // a stack (Stack<? super T>) and a collection (Collection<? extends T>).
        // This method should push all elements from the collection into the stack. To test, use a Stack<Number> and a List<Integer>.
        Stack<Number> stack = new Stack<>();
        stack.push(BigDecimal.ZERO);
        stack.push(10.3);
        List<Integer> numList = List.of(2,4,6,8,10);
        StackUtils.pushAll(stack, numList);
        System.out.println("Stack:");
        System.out.println(stack);


        //Task 5: Complex Generics with extends and super (Hard)
        //Objective: Combine knowledge of extends and super to manage a zoo simulation.
        // Create a generic class Cage<T> for animals where T is a type that extends a base class Animal.
        // Implement methods to addAnimal into the cage. Use upper bounds to ensure that only subtypes of Animal can be added.
        //1.
        //Implement an Animal class with subclasses Bird, Fish, and Mammal.
        //2.
        //Create a Cage<T> class where T extends Animal. Include methods like addAnimal(T animal) and getAnimal(int index).
        //3.
        //Write a utility method transferAnimals that moves animals from one cage to another.
        // This method should accept parameters of Cage<? extends T> for source cage and Cage<? super T> for destination cage,
        // ensuring proper use of PECS (Producer Extends, Consumer Super).

        Fish fish1 = new Fish("Ruby", "Goldfish", "dry");
        Fish fish2 = new Fish("Cherry", "Sardine", "dry");

        Bird bird1 = new Bird("Kiwi", "Dove", "Wheat");
        Bird bird2 = new Bird("Sunny", "Eagle", "Mouse");

        Mammal mammal1 = new Mammal("Levi", "Dog", "Meat");
        Mammal mammal2 = new Mammal("Kasper", "Cat", "Meat");

        Cage<Bird> birds = new Cage<>();
        birds.addAnimal(bird1);
        birds.addAnimal(bird2);

        Cage<Fish> fishes = new Cage<>();
        fishes.addAnimal(fish1);
        fishes.addAnimal(fish2);

        Cage<Mammal> mammals = new Cage<>();
        mammals.addAnimal(mammal1);
        mammals.addAnimal(mammal2);

        Cage<Animal> birdsAndFishes = new Cage<>();

        System.out.println("Cage before first transfer ");
        birdsAndFishes.getAnimals().forEach(System.out::println);
        ZooUtils.transferAnimals(birds, birdsAndFishes);

        System.out.println("Cage after first transfer ");
        birdsAndFishes.getAnimals().forEach(System.out::println);
        ZooUtils.transferAnimals(fishes, birdsAndFishes);
        System.out.println("Cage after second transfer ");
        birdsAndFishes.getAnimals().forEach(System.out::println);

    }

    public static <T> void printArray (T[] array) {
        if(array == null) {
            return;
        }
        for(T elem : array) {
            System.out.print(elem + " ");
        }
        System.out.println();

    }
}
