package ru.geekbrains.java_core1.lessons.lesson4_TicTacToeGame;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private static final char DOT_X = 'X';
    private static final char DOT_0 = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner csanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scorHuman;
    private static int scorAI;
    private static int roundCounter;
    private static int winLength;

    public static void main(String[] args) {
        winLength = 5;
        play();
    }
    private static void play() {
        while(true) {
            chooseTheDot();
            playRound();
            System.out.printf("SCORE: Human     AI\n" +
                    "        %d         %d\n", scorHuman, scorAI);
            System.out.print("Wanna play again? Y or N >>> ");
            if (!csanner.next().toLowerCase().equals("y")) {
                System.out.println("Good bye!!!");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("ROUND %d START\n", ++roundCounter);
        initField(5, 5);
        printField();
        if(dotHuman == DOT_X) {
            humanFirstTurn();
        } else {
            aiFirstTurn();
        }
    }

    private static void aiFirstTurn() {
        while (true){
            aiTurn();
            printField();
            if(checkGame(dotAi)) break;
            humanTurn();
            printField();
            if(checkGame(dotHuman)) break;
        }
    }

    private static void humanFirstTurn() {
        while (true){
            humanTurn();
            printField();
            if(checkGame(dotHuman)) break;
            aiTurn();
            printField();
            if(checkGame(dotAi)) break;;
        }
    }

    private static void chooseTheDot() {
        System.out.print("If you want to play with 'X' than enter 'X' otherwise enter anything >>> ");
        if(csanner.next().toLowerCase().equals("x")) {
            dotHuman = DOT_X;
            dotAi = DOT_0;
        } else {
            dotHuman = DOT_0;
            dotAi = DOT_X;
        }
    }

    private static boolean checkGame(char dot) {
        if(checkWin(dot)) {
            if(dot == dotHuman) {
                System.out.println("Human won!!!");
                scorHuman++;
            } else {
                System.out.println("AI won!!!");
                scorAI++;
            }
            return true;
        }
        if(checkDraw()) return true;
        return false;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(fieldSizeX);//fieldSizeX здесь это bound
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(y, x));
        field[y][x] = dotAi;
    }

    private static void humanTurn() {
        int x;
        int y;
    do {
        System.out.print("Please enter coordinates of your turn x and y split by whitespace >>> ");
        x = csanner.nextInt() - 1;
        y = csanner.nextInt() - 1;
    } while (!isCellValid(y, x) || !isCellEmpty(y, x));
        field[y][x] = dotHuman;
    }

    private static boolean checkWin(char dot) {
        int n = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == dot) {
                    n++;
                }
                if (n == winLength) return true;
            } n = 0;
        }

        for (int j = 0; j < fieldSizeX; j++) {
            for (int i = 0; i < fieldSizeY; i++) {
                if (field[i][j] == dot) {
                    n++;
                }
                if (n == winLength) return true;
            } n = 0;
        }

        for (int i = 0; i < fieldSizeY; i++) {
            if (field[i][i] == dot) {
                n++;
            }
        } if (n == winLength) return true;
        n = 0;


        for (int i = 0; i < fieldSizeY; i++) {
                if (field[i][fieldSizeY - 1 - i] == dot) {
                    n++;
            }
        } if (n == winLength) return true;
        n = 0;
        return false;
    }

    private static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
             if(isCellEmpty(y, x)) return false;
            }
        }
        System.out.println("It's DRAW!!!");
        return true;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isCellValid(int y, int x) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    private static void initField(int sizeX, int sizeY) {
            fieldSizeX = sizeX;
            fieldSizeY = sizeY;
            field = new char[fieldSizeY][fieldSizeX];
            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                 field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i %2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                System.out.print(field[y][x] + " ");
//            }
//            System.out.println();
//        }
    }
}
