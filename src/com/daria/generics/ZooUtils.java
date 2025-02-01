package com.daria.generics;

import com.daria.generics.animal.Animal;

public class ZooUtils {

    public static  <T> void transferAnimals(Cage<? extends Animal> sourceCage, Cage<? super Animal> destinationCage) {
        sourceCage.getAnimals().forEach(destinationCage::addAnimal);
    }
}
