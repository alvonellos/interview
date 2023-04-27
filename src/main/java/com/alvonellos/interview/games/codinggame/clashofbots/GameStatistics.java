package com.alvonellos.interview.games.codinggame.clashofbots;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class GameStatistics implements Comparable<GameStatistics> {
    int[][] cells;

    public GameStatistics(int[][] cells) {
        this.cells = cells;
    }

    public boolean checkCells() {
        return Arrays.stream(cells).flatMapToInt(Arrays::stream).allMatch(
                cell -> cell > -10 && cell < 10 && (cell > 0 || cell < 0 || cell == 0)
        );
    }

    public boolean isGameOver() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameWon() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numAllies() {
        return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
    }

    public int numEnemies() {
        return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
    }

    public int sumAllyHealth() {
        return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
    }

    public int sumEnemyHealth() {
        return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
    }

    public boolean isWinning() {
        int numAllies = numAllies();
        int numEnemies = numEnemies();
        int sumAllyHealth = sumAllyHealth();
        int sumEnemyHealth = sumEnemyHealth();

        if (numAllies > numEnemies) {
            return true;
        } else {
            if (numAllies == numEnemies) {
                if (sumAllyHealth > sumEnemyHealth) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }


    @Override
    public int compareTo(@NotNull GameStatistics o) {
        if (this.isWinning() && o.isWinning()) {
            // Compare number of allies
            int numAlliesDiff = this.numAllies() - o.numAllies();
            if (numAlliesDiff != 0) {
                return numAlliesDiff;
            }

            // Compare sum of ally health
            int sumAllyHealthDiff = this.sumAllyHealth() - o.sumAllyHealth();
            if (sumAllyHealthDiff != 0) {
                return sumAllyHealthDiff;
            }

            // Compare number of enemies
            int numEnemiesDiff = this.numEnemies() - o.numEnemies();
            if (numEnemiesDiff != 0) {
                return numEnemiesDiff;
            }

            // Compare sum of enemy health
            int sumEnemyHealthDiff = this.sumEnemyHealth() - o.sumEnemyHealth();
            if (sumEnemyHealthDiff != 0) {
                return sumEnemyHealthDiff;
            }

            return 0;
        } else {
            return 0;
        }
    }
}
