package com.alvonellos.interview.games.codinggame.clashofbots;

import com.alvonellos.interview.games.codinggame.clashofbots.GameBoard;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {
    @Test
    public void testGetCell() {
        int[][] cells = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        GameBoard board = new GameBoard(cells);

        assertEquals(0, board.getCell(0, 0));
        assertEquals(6, board.getCell(1, 1));
        assertEquals(12, board.getCell(2, 2));
        assertEquals(18, board.getCell(3, 3));
        assertEquals(24, board.getCell(4, 4));
    }

    @Test
    public void testSetCell() {
        int[][] cells = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        GameBoard board = new GameBoard(cells);

        board.setCell(0, 0, 99);
        board.setCell(3, 2, 55);

        assertEquals(99, board.getCell(0, 0));
        assertEquals(55, board.getCell(3, 2));
    }

    @Test
    public void testGetWidth() {
        int[][] cells = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        GameBoard board = new GameBoard(cells);

        assertEquals(5, board.getWidth());
    }

    @Test
    public void testGetHeight() {
        int[][] cells = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}
        };
        GameBoard board = new GameBoard(cells);

        assertEquals(5, board.getHeight());
    }
}