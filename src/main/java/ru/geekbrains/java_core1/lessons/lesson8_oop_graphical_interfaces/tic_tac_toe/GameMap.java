package ru.geekbrains.java_core1.lessons.lesson8_oop_graphical_interfaces.tic_tac_toe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    public static final Random RANDOM = new Random();
    private static final int DOT_HUMAN = 1;
    private static final int DOT_AI = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private int stateGameOver;
    private int[][] field;
    private int fieldSizeX;
    private int fieldSizeY;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;

    public GameMap() {
         isInitialized = false;
         addMouseListener(new MouseAdapter() {
             @Override
             public void mouseReleased(MouseEvent e) {
                 super.mouseReleased(e);
                 update(e);
             }
         });
    }

    private void update(MouseEvent e) {
       if (gameMode == 0) {
           if (isGameOver || !isInitialized) {
               return;
           }
           if (!playerTurn(e)) {
               return;
           }
           if (gameCheck(DOT_HUMAN, STATE_WIN_HUMAN)) {
               return;
           }
           aiTurn();
           repaint();
           if (gameCheck(DOT_AI, STATE_WIN_AI)) {
               return;
           }
       } else {
           if (isGameOver || !isInitialized) {
               return;
           }
           if (playerNumTurn == 1) {
           playerTurn(e);
           playerNumTurn ^= 1;
           if (gameCheck(DOT_HUMAN, STATE_WIN_HUMAN)) {
               return;
           }
           } else if (playerNumTurn == 0) {
               player2Turn(e);
               playerNumTurn ^= 1;
           if (gameCheck(DOT_AI, STATE_WIN_AI)) {
               return;
           }
           }
       }
    }

    private boolean playerTurn(MouseEvent event) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;
        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return false;
        }
        field[cellY][cellX] = DOT_HUMAN;
        repaint();
        return true;
    }

    private boolean player2Turn(MouseEvent event) {
        int cellX = event.getX() / cellWidth;
        int cellY = event.getY() / cellHeight;
        if (!isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)) {
            return false;
        }
        field[cellY][cellX] = DOT_AI;
        repaint();
        return true;
    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInitialized) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        cellWidth = width / fieldSizeX;
        cellHeight = height / fieldSizeY;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth; //cellHeight?
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(y, x)) {
                    continue;
                }
                if (field[y][x] == DOT_HUMAN) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x * cellWidth + DOT_PADDING, y *cellHeight + DOT_PADDING,
                                cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    g.setColor(Color.RED);
                    g.fillRect(x * cellWidth + DOT_PADDING, y *cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                }
            }
        }
        if (isGameOver) {
            showGameOverMessage(g);
        }
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
          this.gameMode = gameMode;
          playerNumTurn = 1;
          fieldSizeX = fieldSize;
          fieldSizeY = fieldSize;
          this.winLength = winLength;
          field = new int[fieldSizeY][fieldSizeX];
          isInitialized = true;
          isGameOver = false;
          repaint();
    }



    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, getHeight() / 2 - 60, getWidth(), 90);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        if (gameMode == 0) {
            switch (stateGameOver) {
                case STATE_DRAW -> g.drawString("DRAW!", getWidth() / 4, getHeight() / 2);
                case STATE_WIN_HUMAN -> g.drawString("Human won!", getWidth() / 4, getHeight() / 2);
                case STATE_WIN_AI -> g.drawString("Ai won!", getWidth() / 4, getHeight() / 2);
            }
        } else {
            switch (stateGameOver) {
                case STATE_DRAW -> g.drawString("DRAW!", getWidth() / 4, getHeight() / 2);
                case STATE_WIN_HUMAN -> g.drawString("Player 1 won!", getWidth() / 4, getHeight() / 2);
                case STATE_WIN_AI -> g.drawString("Player 2 won!", getWidth() / 4, getHeight() / 2);
            }
        }
    }

    private boolean gameCheck(int dot, int stateGameOver) {
        if(checkWin(dot, winLength)) {
            this.stateGameOver = stateGameOver;
            isGameOver = true;
            repaint();
            return true;
        }
        if(checkDraw()) {
            this.stateGameOver = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(y, x)) return false;
            }
        }
        return true; 
    }

    private void aiTurn() {
        if(scanField(DOT_AI, winLength)) return;
        if(scanField(DOT_HUMAN, winLength)) return;
        if(scanField(DOT_AI, winLength - 1)) return;
        if(scanField(DOT_HUMAN, winLength - 1)) return;
        if(scanField(DOT_AI, winLength - 2)) return;
        if(scanField(DOT_HUMAN, winLength - 2)) return;
        aiTurnEasy();
    }

    private void aiTurnEasy() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[y][x] = DOT_AI;
    }

    private boolean scanField(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(isCellEmpty(y, x)) {
                    field[y][x] = dot;
                    if (checkWin(dot, length)) {
                       if (dot == DOT_AI) return true;
                       if (dot == DOT_HUMAN) {
                           field[y][x] = DOT_AI;
                           return true;
                       }
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    private boolean checkWin(int dot, int length) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkLine(x, y, 1, 0, length, dot)) return true;
                if (checkLine(x, y, 1, 1, length, dot)) return true;
                if (checkLine(x, y, 0, 1, length, dot)) return true;
                if (checkLine(x, y, 1, -1, length, dot)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int incrementX, int incrementY, int len, int dot) {
       int endXLine = x + (len - 1) * incrementX;
       int endYLine = y + (len - 1) * incrementY;
       if (!isCellValid(endYLine, endXLine)) return false;
        for (int i = 0; i < len; i++) {
            if (field[y + i * incrementY][x + i * incrementX] != dot) return false;
        }
        return true;
    }

    private boolean isCellValid(int y, int x) { return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;}

    private boolean isCellEmpty(int y, int x) { return field[y][x] == DOT_EMPTY; }
}
