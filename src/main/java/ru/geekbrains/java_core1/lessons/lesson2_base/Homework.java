package ru.geekbrains.java_core1.lessons.lesson2_base;

import java.util.Scanner;

public class Homework {
    //Домашка ко 2-му уроку
    public static void main(String[] args) {
//        checkSummSize(5, 10);
//        checkPositiveOrNegative(-5);
//        isPositiveOrNegative(2);
//        printWordNTimes("Урра!!!", 4);
//        isLeapYear(1100);
        isLeapYear2();
    }

    public static void isLeapYear2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите год --> ");
//проверяю, точно ли ввели число, а не другую хрень:
        if (scan.hasNextInt()) {
            int year = scan.nextInt();
//если инт, делаю алгоритм проверки
            isLeapYear(year);
        } else {
            System.out.println("Извините, но это явно не год. Перезапустите программу и попробуйте снова!");
        }
        scan.close();
    }

    public static void isLeapYear(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            System.out.println("Это високосный год");
    } else
    {
        System.out.println("Год не високосный");
    }
}


    public static void printWordNTimes(String word, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(word);
        }
    }

    public static boolean isPositiveOrNegative(int n) {
        if (n >= 0) {
            return false;
        }
            return true;

    }

    public static void checkPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("Это положительное число");
        } else {
            System.out.println("Это отрицательное число");
        }
    }

    public static boolean checkSummSize(int a, int b) {

        int c = a + b;
        if (c >= 10 && c <= 20) {
            System.out.println(c);
            return true;
        } else {
            System.out.println("Wrong diapason");
             return false;
        }
    }
}
