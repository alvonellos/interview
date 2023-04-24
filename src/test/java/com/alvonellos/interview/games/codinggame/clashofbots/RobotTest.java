package com.alvonellos.interview.games.codinggame.clashofbots;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static com.alvonellos.interview.games.codinggame.clashofbots.RobotType.ALLY;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    private static final int[][] example_board = new int[][]{
            {3, 3, 3, 3, 3}, //0
            {3, 2, 1, 2, 3}, //1
            {3, 1, 0, 1, 3}, //2
            {3, 2, 1, 2, 3}, //3
            {3, 3, 3, 3, 3}  //4
          // 0  1  2  3  4
    };


    @Test
    void getNextTarget() {
    }

    @Test
    void getNeighbors() {
    }

    @Test
    public void testDistanceTo_SamePosition() {
        double expectedDistance = 0.0;
        double actualDistance = robot1.distanceTo(robot2);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void testDistanceTo_AdjacentPosition() {
        Robot robot1 = new Robot(new Coordinate(2, 2));
        Robot robot2 = new Robot(new Coordinate(2, 3));
        double expectedDistance = 1.0;
        double actualDistance = robot1.distanceTo(robot2);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void testDistanceTo_DiagonalPosition() {
        Robot robot1 = new Robot(new Coordinate(2, 2));
        Robot robot2 = new Robot(new Coordinate(3, 3));
        double expectedDistance = 2.0;
        double actualDistance = robot1.distanceTo(robot2);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void testDistanceTo_RemotePosition() {
        Robot robot1 = new Robot(new Coordinate(2, 2));
        Robot robot2 = new Robot(new Coordinate(4, 4));
        double expectedDistance = 4.0;
        double actualDistance = robot1.distanceTo(robot2);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }
    @Test
    void getType() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void getBoard() {
    }

    @Test
    void getHealth() {
    }

    @Test
    void testGetHealth() {
    }
}