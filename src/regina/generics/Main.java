package regina.generics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //task 1 - in container class
        Container<String> stringContainer = new Container<>(new ArrayList<>());
        stringContainer.addElement("first");
        stringContainer.addElement("second");
        stringContainer.addElement("third");

        Container<Integer> integerContainer = new Container<>(new ArrayList<>());
        integerContainer.addElement(4);
        integerContainer.addElement(6);
        integerContainer.addElement(8);

        //task 2
        printArray(stringContainer.getElements());
        printArray(integerContainer.getElements());


        //task 3
        String firstElementString = ListUtils.getFirstElement(stringContainer.getElements());
        System.out.println("first element string " + firstElementString);

        Integer firstElementInteger = ListUtils.getFirstElement(integerContainer.getElements());
        System.out.println("first element integer " + firstElementInteger);

        //task 4
        Stack<Number> numberStack = new Stack<>();
        numberStack.add(1.0);
        numberStack.add(BigDecimal.TEN);

        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println("stack before " + numberStack);
        StackUtils.pushAll(numberStack, integerList);
        System.out.println("stack after " + numberStack);


        //Task 5
        Zoo.Bird Emu = new Zoo.Bird("Emily", "Emu", true, false);
        Zoo.Fish shark = new Zoo.Fish("Sharky", "shark", true, 8, true);
        Zoo.Mammal bruceKangaroo = new Zoo.Mammal("Bruce", "Red Kangaroo", true, 2);
        Zoo.Mammal wallyWallaby = new Zoo.Mammal("Wally", "Wallaby", true, 2);

        List<Zoo.Mammal> listOfMammals = List.of(bruceKangaroo, wallyWallaby);
        Zoo.Cage<Zoo.Mammal> mammalCageOld = new Zoo.Cage<>(listOfMammals);

        System.out.println("Animals in mammal cage: ");
        mammalCageOld.getAnimalsInCage().forEach(System.out::println);

        Zoo.Cage<? super Zoo.Animal> cageWithEmu = new Zoo.Cage<>(new ArrayList<>());
        cageWithEmu.addAnimal(Emu);

        System.out.println("Animals in emu cage: ");
        cageWithEmu.getAnimalsInCage().forEach(System.out::println);
        Zoo.ZooUtils.transferAnimals(mammalCageOld, cageWithEmu);
        System.out.println("Animals in emu cage after transfer: ");
        cageWithEmu.getAnimalsInCage().forEach(System.out::println);

    }

    //Task 2
    //Objective: Write a generic method printArray that can take an array of any type and
    //prints each element to the console. The method should be able to accept arrays of any
    //data types, including integers, strings, and doubles.
    public static <T> void printArray(List<T> array) {
        array.forEach(System.out::println);
    }


}
