package com.alvonellos.interview.games.codinggame.clashofbots;

public enum RobotType {
    ALLY,
    ENEMY,
    EMPTY;

    public static RobotType getRobotType(int cell) {
        if (cell < 0) {
            return RobotType.ENEMY;
        } else if (cell > 0) {
            return RobotType.ALLY;
        } else {
            return RobotType.EMPTY;
        }
    }
}
