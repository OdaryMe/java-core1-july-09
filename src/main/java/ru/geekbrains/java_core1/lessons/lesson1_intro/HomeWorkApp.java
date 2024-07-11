package ru.geekbrains.java_core1.lessons.lesson1_intro;

public class HomeWorkApp {
    //Домашка к 1 уроку

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void compareNumbers() {
        int a = 1;
        int b = 2;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }


    public static void printColor() {
        int value = 5;

        if (value <= 0) {
            System.out.println("Красный!");
        } else if (value > 100) {
            System.out.println("Зеленый");
        } else {
            System.out.println("Желтый...");
        }
    }


    public static void checkSumSign() {
        int a = 10;
        int b = -20;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printThreeWords() {
        String word1 = new String("Orange\n");
        String word2 = new String("Banana\n");
        String word3 = new String("Apple");

        System.out.println(word1 + word2 + word3);
    }

    private static void envelope() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5 || i == j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
