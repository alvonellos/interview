package com.alvonellos.interview.games.codinggame.clashofbots;

public enum Effect {
    GUARD(0.5f),
    COLLISION(1.0f),
    ATTACK(2.0f),
    SELFDESTRUCTION(4.0f);

    private final float effectValue;

    Effect(float effectValue) {
        this.effectValue = effectValue;
    }

    public float getEffectValue() {
        return effectValue;
    }
}