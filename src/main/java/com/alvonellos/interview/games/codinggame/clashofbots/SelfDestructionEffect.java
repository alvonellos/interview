package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.List;
import java.util.function.Predicate;

public class SelfDestructionEffect extends GameStatistics {
    private Robot robot;
    private GameBoard board;

    private static final int[][] effectMap = {
            {0, 0, 0, 0, 0},
            {0, -4, -4, -4, 0},
            {0, -4, -10, -4, 0},
            {0, -4, -4, -4, 0},
            {0, 0, 0, 0, 0},
    };

    public SelfDestructionEffect(Robot robot, GameBoard board) {
        super(board.getCells());
        this.robot = robot;
        this.board = board;
    }

    @Override
    public boolean isGameWon() {
        return false; // self-destruction doesn't win the game
    }

    @Override
    public boolean isGameOver() {
        return false; // self-destruction doesn't end the game
    }

    @Override
    public int sumEnemyHealth() {
        int sum = 0;
        int[][] cells = board.getCells();

        sum = sumBoard(sum, cells, criteria);

        return sum;
    }

    private static int sumBoard(final int[][] cells, final Predicate<Integer> criteria) {
        final int row = cells.length - 1;
        final int col = cells[0].length - 1;
        int sum = 0;

        for (int i = Math.max(row - 1, 0); i <= Math.min(row + 1, cells.length - 1); i++) {
            for (int j = Math.max(col - 1, 0); j <= Math.min(col + 1, cells[0].length - 1); j++) {
                if(criteria.test(cells[i][j])) {
                    sum += cells[i][j];
                }
            }
        }
        return sum;
    }
}

