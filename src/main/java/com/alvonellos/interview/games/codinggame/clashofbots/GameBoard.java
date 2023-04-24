package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.Arrays;

public class GameBoard {
    private int[][] cells;

    public GameBoard() {
        this.cells = new int[5][5];
        Arrays.fill(cells, 0);
        this.cells[2][2] = 10;
    }

    public void addSprite(int x, int y, int value) {
        cells[y][x] = value;
    }

    public GameBoard(int[][] cells) {
        this.cells = cells;
    }

    public int getCell(int x, int y) {
        return cells[y][x];
    }

    public void setCell(int x, int y, int value) {
        cells[y][x] = value;
    }

    public int getWidth() {
        return cells[0].length;
    }

    public int getHeight() {
        return cells.length;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                sb.append(cells[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
