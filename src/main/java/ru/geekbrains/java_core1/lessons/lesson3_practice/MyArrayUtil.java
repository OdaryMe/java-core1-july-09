package ru.geekbrains.java_core1.lessons.lesson3_practice;

import java.util.Arrays;
import java.util.Random;

public class MyArrayUtil {
    public static void printArray(int[] arr) {
        //System.out.println(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void printArray(double... arr) {
        //System.out.println(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void printArray(float[] arr) {
        //System.out.println(arr);
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");
    }

    public static void printArray(int[][] arr) {
        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                System.out.print(arr[y][x] + " ");
            }
            System.out.println();
        }
    }

    public static int[] makeArrayWithRandomValues(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    public static void findMaxAndMinElem(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Самый большой элемент: " + max);
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Самый маленький элемент: " + min);
    }

    public static int[] cyclicShiftOfElementsOneStep(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }
}
