package com.alvonellos.interview.games.codinggame.clashofbots;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public enum Action {
    GUARD("GUARD", Effect.GUARD, new boolean[][]{
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, false, false, false, false},
            {false, false, false, false, false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            return 0;
        }
    }),
    MOVE_LEFT("MOVE LEFT", Effect.COLLISION,  new boolean[][] {
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,true,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 1;
            } else { // cell < 0
                return cell + 1;
            }
        }
    }),
    MOVE_RIGHT("MOVE RIGHT", Effect.COLLISION, new boolean[][] {
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,true,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 1;
            } else { // cell < 0
                return cell + 1;
            }
        }
    }),
    MOVE_UP("MOVE UP", Effect.COLLISION, new boolean[][] {
            {false,false,false,false,false},
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 1;
            } else { // cell < 0
                return cell + 1;
            }
        }
    }),
    MOVE_DOWN("MOVE DOWN", Effect.COLLISION, new boolean[][] {
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,true,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 1;
            } else { // cell < 0
                return cell + 1;
            }
        }
    }),
    ATTACK_LEFT("ATTACK LEFT", Effect.ATTACK, new boolean[][] {
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,true,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 2;
            } else { // cell < 0
                return cell + 2;
            }
        }
    }),
    ATTACK_RIGHT("ATTACK RIGHT", Effect.ATTACK, new boolean[][] {
        {false,false,false,false,false},
        {false,false,false,false,false},
        {false,false,false,true,false},
        {false,false,false,false,false},
        {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 2;
            } else { // cell < 0
                return cell + 2;
            }
        }
    }),
    ATTACK_UP("ATTACK UP", Effect.ATTACK, new boolean[][] {
            {false,false,false,false,false},
            {false,false,true,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 2;
            } else { // cell < 0
                return cell + 2;
            }
        }
    }),
    ATTACK_DOWN("ATTACK DOWN", Effect.ATTACK, new boolean[][] {
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,false,false,false},
            {false,false,true,false,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 2;
            } else { // cell < 0
                return cell + 2;
            }
        }
    }),
    SELFDESTRUCTION("SELFDESTRUCTION", Effect.SELFDESTRUCTION, new boolean[][] {
            {false,false,false,false,false},
            {false,true,true,true,false},
            {false,true,true,true,false},
            {false,true,true,true,false},
            {false,false,false,false,false},
    }, new IntFunction<Integer>() {
        @Override
        public Integer apply(int cell) {
            if (cell == 0) {
                return 0;
            } else if (cell > 0) {
                return cell - 4;
            } else { // cell < 0
                return cell + 4;
            }
        }
    });

    private final String actionString;

    private final Effect effect;

    private final boolean[][] effectRadius;

    private IntFunction<Integer> effectPredicate;



    Action(String actionString, Effect effect, boolean[][] effectRadius, IntFunction<Integer> effectPredicate) {
        this.actionString = actionString;
        this.effect = effect;
        this.effectRadius = effectRadius;
        this.effectPredicate = effectPredicate;
    }

    public String getActionString() {
        return actionString;
    }

    public Effect getEffect() {
        return effect;
    }

    public boolean[][] getEffectRadius() {
        return effectRadius;
    }

    public IntFunction<Integer> getEffectPredicate() {
        return effectPredicate;
    }

    public int[][] applyAction(int[][] map, Predicate<Integer> filter) {
        int[][] newMap = Arrays.stream(map).map(el -> el.clone()).toArray($ -> map.clone());
        boolean[][] effectRadius = this.getEffectRadius();

        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if (filter.test(map[i][j]) && effectRadius[i][j]) {
                    newMap[i][j] = this.getEffectPredicate().apply(map[i][j]);
                }
            }
        }
        return newMap;
    }
}
