package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

public class Dog extends Animal {
    String name;
    int maxGap = 500;
    int maxRange = 10;

    public Dog(String name) {
        this.name = name;
    }

    public void dogRun(int gap) {
        if(gap <= maxGap) {
            System.out.printf("Dog %s ran %d m\n", name, gap);
        } else {
            System.out.printf("Dog %s only ran %d meters and dropped out of the race\n", name, maxGap);
        }
    }

    public void dogSwim(int range) {
        if(range <= maxRange) {
            System.out.printf("Dog %s swam %d m\n", name, range);
        } else {
            System.out.printf("Unfortunately dog %s drowned\n", name);
        }
    }
}
