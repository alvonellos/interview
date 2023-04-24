package com.alvonellos.interview.games.codinggame.clashofbots;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ActionTest {

    @Test
    public void testGetActionString() {
        assertEquals("GUARD", Action.GUARD.getActionString());
        assertEquals("MOVE LEFT", Action.MOVE_LEFT.getActionString());
        assertEquals("MOVE RIGHT", Action.MOVE_RIGHT.getActionString());
        assertEquals("MOVE UP", Action.MOVE_UP.getActionString());
        assertEquals("MOVE DOWN", Action.MOVE_DOWN.getActionString());
        assertEquals("ATTACK LEFT", Action.ATTACK_LEFT.getActionString());
        assertEquals("ATTACK RIGHT", Action.ATTACK_RIGHT.getActionString());
        assertEquals("ATTACK UP", Action.ATTACK_UP.getActionString());
        assertEquals("ATTACK DOWN", Action.ATTACK_DOWN.getActionString());
        assertEquals("SELFDESTRUCTION", Action.SELFDESTRUCTION.getActionString());
    }

    @Test
    public void testEnumValues() {
        Action[] actions = Action.values();
        assertEquals(10, actions.length);
        assertEquals(Action.GUARD, actions[0]);
        assertEquals(Action.MOVE_LEFT, actions[1]);
        assertEquals(Action.MOVE_RIGHT, actions[2]);
        assertEquals(Action.MOVE_UP, actions[3]);
        assertEquals(Action.MOVE_DOWN, actions[4]);
        assertEquals(Action.ATTACK_LEFT, actions[5]);
        assertEquals(Action.ATTACK_RIGHT, actions[6]);
        assertEquals(Action.ATTACK_UP, actions[7]);
        assertEquals(Action.ATTACK_DOWN, actions[8]);
        assertEquals(Action.SELFDESTRUCTION, actions[9]);
    }

}
