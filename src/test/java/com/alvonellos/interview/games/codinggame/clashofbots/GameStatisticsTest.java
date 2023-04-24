package com.alvonellos.interview.games.codinggame.clashofbots;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameStatisticsTest {
    @Test
    public void testCheckCells_validCells_returnsTrue() {
        int[][] cells = {
                {0, -10, 5, 1, -5},
                {10, 0, 3, -3, 2},
                {-2, 8, 0, -6, 0},
                {-1, -8, -10, 0, 10},
                {5, 4, -7, -9, 0}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertTrue(stats.checkCells());
    }

    @Test
    public void testCheckCells_invalidCells_returnsFalse() {
        int[][] cells = {
                {0, -10, 5, 1, -5},
                {10, 0, 3, -3, 2},
                {-2, 8, 0, -6, 0},
                {-1, -8, -11, 0, 10}, // invalid cell value (-11)
                {5, 4, -7, -9, 0}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertFalse(stats.checkCells());
    }

    @Test
    public void testIsGameOver_notOver_returnsFalse() {
        int[][] cells = {
                {0, -10, 5, 1, -5},
                {10, 0, 3, -3, 2},
                {-2, 8, 0, -6, 0},
                {-1, -8, -10, 0, 10},
                {5, 4, -7, -9, 0}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertFalse(stats.isGameOver());
    }

    @Test
    public void testIsGameOver_allEnemies_returnsTrue() {
        int[][] cells = {
                {-2, -8, -5, -1, -5},
                {-10, -1, -3, -3, -2},
                {-2, -8, -3, -6, -3},
                {-1, -8, -10, -2, -10},
                {-5, -4, -7, -9, -3}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertTrue(stats.isGameOver());
    }

    @Test
    public void testIsGameWon_notWon_returnsFalse() {
        int[][] cells = {
                {0, -10, 5, 1, -5},
                {10, 0, 3, -3, 2},
                {-2, 8, 0, -6, 0},
                {-1, -8, -10, 0, 10},
                {5, 4, -7, -9, 0}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertFalse(stats.isGameWon());
    }

    @Test
    public void testIsGameWon_allAllies_returnsTrue() {
        int[][] cells = {
                {2, 8, 5, 1, 5},
                {10, 1, 3, 3, 2},
                {2, 8, 3, 6, 3},
                {1, 8, 10, 2, 10},
                {5, 4, 7, 9, 3}
        };
        GameStatistics stats = new GameStatistics(cells);
        assertTrue(stats.isGameWon());
    }
}
