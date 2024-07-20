package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

public class Cat extends Animal {
    String name;
    int maxGap = 200;

    public Cat(String name) {
        this.name = name;
    }

    public void catRun(int gap) {
        if(gap <= maxGap) {
            System.out.printf("Cat %s ran %d m\n", name, gap);
        } else {
            System.out.printf("Cat %s dropped out of the race\n", name);
        }
    }

    public void catSwim(int range) {
        System.out.printf("Cats cannot swim\n");
    }
}
