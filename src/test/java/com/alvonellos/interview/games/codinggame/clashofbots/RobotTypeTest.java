package com.alvonellos.interview.games.codinggame.clashofbots;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTypeTest {

    @Test
    void testGetRobotTypeWithPositiveCell() {
        int cell = 1;
        RobotType expected = RobotType.ALLY;
        RobotType actual = RobotType.getRobotType(cell);
        assertEquals(expected, actual);
    }

    @Test
    void testGetRobotTypeWithNegativeCell() {
        int cell = -1;
        RobotType expected = RobotType.ENEMY;
        RobotType actual = RobotType.getRobotType(cell);
        assertEquals(expected, actual);
    }

    @Test
    void testGetRobotTypeWithZeroCell() {
        int cell = 0;
        RobotType expected = RobotType.EMPTY;
        RobotType actual = RobotType.getRobotType(cell);
        assertEquals(expected, actual);
    }
}
