package com.alvonellos.interview.games.codinggame.clashofbots;

import javax.swing.*;
import java.util.Map;

public enum Effect {
    GUARD(1),
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

    public static Map<GameState, Effect> getAffect(Action action, GameState gameState) {
        switch (action) {
            case GUARD:
                return GameState.calculateOutcome(gameState, GUARD);
            case ATTACK_DOWN:
            case ATTACK_LEFT:
            case ATTACK_RIGHT:
            case ATTACK_UP:
                return Map.of(GameState.advancePro, ATTACK);
            case MOVE_DOWN:
            case MOVE_LEFT:
            case MOVE_RIGHT:
            case MOVE_UP:
                return Map.of(GameState.advancePro, ATTACK);
            case SELFDESTRUCTION:
                return Map.of(GameState.advancePro, SELFDESTRUCTION);
            default:
                return null;
        }
    }
}