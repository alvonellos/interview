package com.alvonellos.interview.games.codinggame.clashofbots;

public enum Action {
    GUARD("GUARD", Effect.GUARD),
    MOVE_LEFT("MOVE LEFT", Effect.COLLISION),
    MOVE_RIGHT("MOVE RIGHT", Effect.COLLISION),
    MOVE_UP("MOVE UP", Effect.COLLISION),
    MOVE_DOWN("MOVE DOWN", Effect.COLLISION),
    ATTACK_LEFT("ATTACK LEFT", Effect.ATTACK),
    ATTACK_RIGHT("ATTACK RIGHT", Effect.ATTACK),
    ATTACK_UP("ATTACK UP", Effect.ATTACK),
    ATTACK_DOWN("ATTACK DOWN", Effect.ATTACK),
    SELFDESTRUCTION("SELFDESTRUCTION", Effect.SELFDESTRUCTION);

    private final String actionString;

    Action(String actionString, Effect guard) {
        this.actionString = actionString;
    }

    public String getActionString() {
        return actionString;
    }
}
