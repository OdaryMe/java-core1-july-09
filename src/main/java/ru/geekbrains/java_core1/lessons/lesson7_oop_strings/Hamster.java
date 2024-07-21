package ru.geekbrains.java_core1.lessons.lesson7_oop_strings;

public class Hamster {
    private String name;
    private int appetite;
    private boolean satiety;

    public Hamster(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Bowl bowl) {
        satiety = false;
        if(appetite <= bowl.getFoodAmount()) {
            bowl.decreaseFood(appetite);
            System.out.printf("Hamster %s has eaten for %d food.\n", name, appetite);
            System.out.printf("Hamster %s is full.\n", name);
            return satiety = true;
        } else {
            System.out.printf("It's no food! Humster %s is hungry!!!\n", name);
        } return false;
    }
}
