package com.alvonellos.interview.games.codinggame.clashofbots;

import javax.swing.*;
import java.util.Map;

public enum Effect {
    NONE(0.0f),
    GUARD(1.0f),
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