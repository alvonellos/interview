package com.alvonellos.interview.games.codinggame.clashofbots;

public enum Action {
    GUARD("GUARD", Effect.GUARD, new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    MOVE_LEFT("MOVE LEFT", Effect.COLLISION,  new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,1,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    MOVE_RIGHT("MOVE RIGHT", Effect.COLLISION, new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,1,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    MOVE_UP("MOVE UP", Effect.COLLISION, new int[][] {
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    MOVE_DOWN("MOVE DOWN", Effect.COLLISION, new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
    }),
    ATTACK_LEFT("ATTACK LEFT", Effect.ATTACK, new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,1,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    ATTACK_RIGHT("ATTACK RIGHT", Effect.ATTACK, new int[][] {
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,1,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
    }),
    ATTACK_UP("ATTACK UP", Effect.ATTACK, new int[][] {
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
    }),
    ATTACK_DOWN("ATTACK DOWN", Effect.ATTACK, new int[][] {
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,1,0,0},
            {0,0,0,0,0},
    }),
    SELFDESTRUCTION("SELFDESTRUCTION", Effect.SELFDESTRUCTION, new int[][] {
            {0,0,0,0,0},
            {0,1,1,1,0},
            {0,1,1,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0},
    });

    private final String actionString;

    private final Effect effect;

    private final int[][] effectRadius;



    Action(String actionString, Effect effect, int[][] effectRadius) {
        this.actionString = actionString;
        this.effect = effect;
        this.effectRadius = effectRadius;
    }

    public String getActionString() {
        return actionString;
    }
}
