package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

public class Cat extends Animal {
    private int maxGap = 200;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int gap) {
        if(gap <= maxGap) {
            System.out.printf("Cat %s ran %d m\n", name, gap);
        } else {
            System.out.printf("Cat %s dropped out of the race\n", name);
        }
    }

    @Override
    public void swim(int range) {
        System.out.printf("Cats cannot swim\n");
    }
}
