package com.alvonellos.interview.games.codinggame.clashofbots;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EffectTest {

    @Test
    public void testGuardEffectValue() {
        assertEquals(0.5f, Effect.GUARD.getEffectValue(), 0.0f);
    }

    @Test
    public void testCollisionEffectValue() {
        assertEquals(1.0f, Effect.COLLISION.getEffectValue(), 0.0f);
    }

    @Test
    public void testAttackEffectValue() {
        assertEquals(2.0f, Effect.ATTACK.getEffectValue(), 0.0f);
    }

    @Test
    public void testSelfDestructionEffectValue() {
        assertEquals(4.0f, Effect.SELFDESTRUCTION.getEffectValue(), 0.0f);
    }
}
