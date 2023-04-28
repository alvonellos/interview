package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.alvonellos.interview.games.codinggame.clashofbots.Player.log;

public class Engine {
    private GameState state;

    public Engine(GameState state) {
        this.state = state;
    }

    public static Action getOptimalAction(GameState state, Robot robot) {
        RedBlackBST<GameStatistics, Action> possibleActions = new RedBlackBST<>();
        Arrays
                .stream(Action.values())
                .forEach(action -> {
                    int[][] currentMap = robot.getBoard().getCells();
                    int[][] newMap = action.applyAction(currentMap, x -> true);

                    GameStatistics currentState = new GameStatistics(currentMap);
                    GameStatistics newState = new GameStatistics(newMap);

                    //if the current state is worse or equal than the new state
                    if(currentState.compareTo(newState) <= 0) {
                        possibleActions.put(currentState, action);
                    }

                });

        //TODO: prune tree with heuristic

        return possibleActions.get(possibleActions.max());
    }

}

