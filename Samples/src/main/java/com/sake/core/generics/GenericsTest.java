package com.sake.core.generics;

import java.util.*;

/**
 * Created by sakez on 07/08/17
 * This is a test class for generics basics
 */
public class GenericsTest {

    public static void main(String []args) {
        List<Animal> animals = new ArrayList<>();

        Animal animal = new Animal();
        Dog dog = new Dog();

        animals.add(animal);
        animals.add(dog);

        for (Animal animalType : animals){
            System.out.println("Animal type is: " + animalType);
        }
    }
}