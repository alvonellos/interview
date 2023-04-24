package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.alvonellos.interview.games.codinggame.clashofbots.Player.log;
import static com.alvonellos.interview.games.codinggame.clashofbots.RobotType.ALLY;

public class GameState {
    private List<Robot> robots;

    public GameState(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public static GameState parseInput(Scanner in) {
        int numberOfRobots = in.nextInt();
        log("identified: ", String.valueOf(numberOfRobots), " robots");
        List<Robot> robots = new ArrayList<>(numberOfRobots);

        for (int r = 0; r < numberOfRobots; r++) {
            int[][] cells = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    cells[i][j] = in.nextInt();
                }
            }
            robots.add(new Robot(ALLY, new GameBoard(cells)));
            in.nextLine(); // consume the rest of the line after the integers
        }
        return new GameState(robots);
    }
}
