package ru.geekbrains.java_core1.lessons.lesson3_practice;
/*Домашнее задание
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
З. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть
[0][0], [1][1], [2][2], …, [n][n];
5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа
int длиной len, каждая ячейка которого равна initialValue;
6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры:
checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.


8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или
отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один
вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону
сдвиг можете выбирать сами.
*/
import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
        invertedArr(); //1й вариант решения задания 1
        //2й вариант задания 1:
        int[] array = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        invertArray(array);
        fillArray();//задание 2
        multiplyLessThan6(); //задание 3
        fillDiagonal(); //задание 4
        createArray(7, 5); //задание 5
        //задание 6:
        int[] mi = {3, - 15, 46, -2, 348, -150, 21, 66, 14, 180, 2, 500};
        MyArrayUtil.findMaxAndMinElem(mi);
        //задание 7:
        int[] set = {1, 5, 3, 2, 1, 8, 2, 2};
        System.out.println(checkBalance(set));
        //задание 8:
        int[] collection = {5, 8, 2, 6, 3, 1, 7, 4};
        int n = 3;
        cyclicShiftNSteps(n, collection);
    }

    private static void cyclicShiftNSteps(int n, int[] collection) {
        for (int i = 0; i < n; i++) {
            MyArrayUtil.cyclicShiftOfElementsOneStep(collection);
        }
        System.out.println(Arrays.toString(collection));
    }

    private static boolean checkBalance(int[] set) {
        int summ = 0;
        for (int i = 0; i < set.length; i++) {
            summ += set[i];
    }
        int partSumm = 0;
        for (int n = 0; n < set.length; n++) {
            partSumm += set[n];
            if(partSumm == summ / 2)
                break;
        } return partSumm == summ / 2;
    }

    private static int[] createArray(int len, int initialValue) {
        int[] arr = new int [len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static void fillDiagonal() {
        int[][] square = new int[7][7];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (i == j || i == square.length - 1 - j || j == square.length - 1 - i) {
                    square[i][j] = 1;
                } else {
                    square[i][j] = 0;
                }
            }

        }
        MyArrayUtil.printArray(square);
    }

    private static void multiplyLessThan6() {
        int[] massive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] < 6) {
                massive[i] *= 2;
            }
        }
        MyArrayUtil.printArray(massive);
    }

    private static void fillArray() {
        int[] mass = new int[100];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i + 1;
            System.out.print(mass[i] + " ");
        }
        System.out.println();
    }

    public static void invertArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
        System.out.print("]\n");
    }

    private static void invertedArr() {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == 1) {
               arr[i] = 0;
               continue;
           } else if (arr[i] == 0){
               arr[i] = 1;
           }
        }
        MyArrayUtil.printArray(arr);
    }
}
