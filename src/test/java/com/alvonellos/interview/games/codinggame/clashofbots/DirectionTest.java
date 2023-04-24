package com.alvonellos.interview.games.codinggame.clashofbots;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void getDirectionTo_shouldReturnRight_whenYourPointIsToTheLeftOfTheirPoint() {
        Point yourPoint = new Point(2, 2);
        Point theirPoint = new Point(3, 2);

        Direction direction = Direction.getDirectionTo(yourPoint, theirPoint);

        assertEquals(Direction.RIGHT, direction);
    }

    @Test
    void getDirectionTo_shouldReturnLeft_whenYourPointIsToTheRightOfTheirPoint() {
        Point yourPoint = new Point(3, 2);
        Point theirPoint = new Point(2, 2);

        Direction direction = Direction.getDirectionTo(yourPoint, theirPoint);

        assertEquals(Direction.LEFT, direction);
    }

    @Test
    void getDirectionTo_shouldReturnDown_whenYourPointIsAboveTheirPoint() {
        Point yourPoint = new Point(2, 2);
        Point theirPoint = new Point(2, 3);

        Direction direction = Direction.getDirectionTo(yourPoint, theirPoint);

        assertEquals(Direction.DOWN, direction);
    }

    @Test
    void getDirectionTo_shouldReturnUp_whenYourPointIsBelowTheirPoint() {
        Point yourPoint = new Point(2, 3);
        Point theirPoint = new Point(2, 2);

        Direction direction = Direction.getDirectionTo(yourPoint, theirPoint);

        assertEquals(Direction.UP, direction);
    }

    @Test
    void getDirectionTo_shouldReturnNone_whenYourPointAndTheirPointAreTheSame() {
        Point yourPoint = new Point(2, 2);
        Point theirPoint = new Point(2, 2);

        Direction direction = Direction.getDirectionTo(yourPoint, theirPoint);

        assertEquals(Direction.NONE, direction);
    }
}
