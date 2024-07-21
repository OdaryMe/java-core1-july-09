package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

public class Dog extends Animal {
    private int maxGap = 500;
    private int maxRange = 10;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run(int gap) {
        if(gap <= maxGap) {
            System.out.printf("Dog %s ran %d m\n", name, gap);
        } else {
            System.out.printf("Dog %s only ran %d meters and dropped out of the race\n", name, maxGap);
        }
    }

    @Override
    public void swim(int range) {
        if(range <= maxRange) {
            System.out.printf("Dog %s swam %d m\n", name, range);
        } else {
            System.out.printf("Unfortunately dog %s drowned\n", name);
        }
    }
}
