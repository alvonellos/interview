package com.alvonellos.interview.games.codinggame.clashofbots;

import java.util.List;

import static com.alvonellos.interview.games.codinggame.clashofbots.Player.log;

public class Engine {
    private GameState state;

    public Engine(GameState state) {
        this.state = state;
    }

    public static Action predictAction(GameState state, Robot robot) {
        int x = (int) robot.getPosition().getX();
        int y = (int) robot.getPosition().getY();
        log("predict action: ", String.valueOf(x), ", ", String.valueOf(y));

        List<Robot> immediateNeighbors = robot.getNeighbors(true);
        int numAllies = (int) immediateNeighbors.stream().filter(j -> j.getType() == RobotType.ALLY).count();
        int numEnemies = (int) immediateNeighbors.stream().filter(j -> j.getType() == RobotType.ENEMY).count();
        log("Immediate neighbors: ", String.valueOf(immediateNeighbors.size()), "numEnemies, numAllies: ", String.valueOf(numEnemies), ", ", String.valueOf(numAllies));

        //self destruct if health is low and there's more enemies than allies
        if(numAllies < numEnemies && robot.getHealth() < 4) {
            log(robot.toString(), "case health below four");
            return Action.SELFDESTRUCTION;
        }

        //if there's no immediate enemies, seek enemies
        if(numEnemies == 0) {
            log(robot.toString(),"case no nearby enemies");
            List<Robot> neighbors = robot.getNeighbors(false);
            neighbors.removeIf(r -> r.getType().equals(RobotType.ALLY));
            numEnemies = (int) neighbors.stream().filter(j -> j.getType() == RobotType.ENEMY).count();
            if(numEnemies == 0) {
                log(robot.toString(), "case no extended enemies");
                return Action.GUARD;
            } else {
                log(robot.toString(), "case extended enemies present");
                Robot enemy = robot.getNextTarget(neighbors);
                if(enemy == null)
                    return Action.GUARD;

                switch (Direction.getDirectionTo(robot.getPosition(), enemy.getPosition())) {
                    case UP:
                        return Action.MOVE_UP;
                    case DOWN:
                        return Action.MOVE_DOWN;
                    case LEFT:
                        return Action.MOVE_LEFT;
                    case RIGHT:
                        return Action.MOVE_RIGHT;
                    default:
                        return Action.GUARD;
                }
            }

        }

        //if there are immediate enemies, attack
        if(numEnemies > 0) {
            List<Robot> neighbors = robot.getNeighbors(false);
            Robot enemy = robot.getNextTarget(neighbors);
            if(enemy == null)
                return Action.GUARD;

            log("identified enemy: ", enemy.toString());
            switch (Direction.getDirectionTo(robot.getPosition(), enemy.getPosition())) {
                case UP:
                    return Action.ATTACK_UP;
                case DOWN:
                    return Action.ATTACK_DOWN;
                case LEFT:
                    return Action.ATTACK_LEFT;
                case RIGHT:
                    return Action.ATTACK_RIGHT;
                default:
                    return Action.GUARD;
            }
        }

        return Action.GUARD;
    }

}

