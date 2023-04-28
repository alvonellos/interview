package com.alvonellos.interview.games.codinggame.clashofbots;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Direction {
    UP("UP"),
    DOWN("DOWN"),
    LEFT("LEFT"),
    RIGHT("RIGHT"),
    NONE("NONE");
    private final String directionString;

    Direction(String directionString) {
        this.directionString = directionString;
    }

    public static Direction getDirectionTo(Point yourPoint, Point theirPoint) {
        return getDirectionTo(
                yourPoint.x,
                yourPoint.y,
                theirPoint.x,
                theirPoint.y
        );
    }

    public static Direction getDirectionTo(int yourX, int yourY, int theirX, int theirY) {
        if (yourX < theirX) {
            return RIGHT;
        } else if (yourX > theirX) {
            return LEFT;
        } else if (yourY < theirY) {
            return DOWN;
        } else if (yourY > theirY) {
            return UP;
        } else {
            return NONE;
        }
    }


    private static boolean isCollision(int x, int y, int[][] map) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            // Out of bounds
            return true;
        } else if (map[y][x] != 0) {
            // Collision with another robot
            return true;
        } else {
            return false;
        }
    }
}
