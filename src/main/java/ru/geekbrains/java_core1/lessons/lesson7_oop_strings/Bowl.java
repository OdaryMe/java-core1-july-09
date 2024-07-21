package ru.geekbrains.java_core1.lessons.lesson7_oop_strings;

public class Bowl {
    private int foodAmount;
    private int foodMax = 600;
    private int foodNull = 0;

    public void putFood(int amount) {
        this.foodAmount += amount;
        if(foodAmount >= foodMax) {
            this.foodAmount = foodMax;
            System.out.printf("The bowl is full\n");
        } else {
            System.out.printf("Food increased by %d pts, there is now %d\n", amount, foodAmount);
        }
    }

    public boolean decreaseFood(int amount) {
        this.foodAmount -= amount;
        if(foodAmount <= foodNull) {
            System.out.println("There is not enough food.");
            return false;
        } else {
            System.out.printf("Food decreased by %d pts, there is now %d\n", amount, foodAmount);
        }
        return true;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
