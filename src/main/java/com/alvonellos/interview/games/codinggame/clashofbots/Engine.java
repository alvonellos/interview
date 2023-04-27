package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.List;
import java.util.function.Predicate;

import static com.alvonellos.interview.games.codinggame.clashofbots.Player.log;

public class Engine {
    private GameState state;

    private RedBlackBST<GameStatistics, GameState> optimalTree = new RedBlackBST<GameStatistics, GameState>();

    public Engine(GameState state) {
        this.state = state;
    }

    public static Action predictAction(GameState state, Robot robot) {
        List<Action> possibleActions = state.getPossibleActions(robot);
        if (possibleActions.size() == 0) {
            return Action.GUARD;
        }
        return possibleActions.get(0);
    }

    private int[][] applyEffect(int[][] map, int[][] effect, Predicate<Integer> predicate) {
        int[][] newMap = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (predicate.test(map[i][j])) {
                    newMap[i][j] = map[i][j] + effect[i][j];
                } else {
                    newMap[i][j] = map[i][j];
                }
            }
        }
        return newMap;
    }

}

