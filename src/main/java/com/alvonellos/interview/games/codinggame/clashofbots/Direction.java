package com.alvonellos.interview.games.codinggame.clashofbots;

import java.awt.*;

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
}
