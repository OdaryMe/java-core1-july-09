package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

public class Animal {
    protected String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }


    public void animalRun(int gap) {
        System.out.printf("Animal ran %d m\n", gap);
    }

    public void animalSwim(int range) {
        System.out.printf("Animal swam %d m\n", range);
    }
}
