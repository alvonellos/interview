package com.alvonellos.interview.games.codinggame.clashofbots;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.alvonellos.interview.games.codinggame.clashofbots.Player.log;
import static com.alvonellos.interview.games.codinggame.clashofbots.RobotType.ALLY;
import static com.alvonellos.interview.games.codinggame.clashofbots.RobotType.ENEMY;

public class Robot {

    private List<Robot> neighbors = new ArrayList<>();
    private List<Robot> targets = new ArrayList<>();
    private RobotType type;
    private Point position;
    private GameBoard board;

    private static final int[][] crit_points = new int[][]{
            {3, 3, 3, 3, 3},
            {3, 2, 1, 2, 3},
            {3, 1, 0, 1, 3},
            {3, 2, 1, 2, 3},
            {3, 3, 3, 3, 3}
    };

    public Robot(RobotType type, Point position, GameBoard board) {
        this.type = type;
        this.position = position;
        this.board = board;
        log("new robot: ", type.toString(), position.toString(), type.equals(ALLY) && board != null ? this.getBoard().toString() : "");
    }
    public double distanceTo(Robot target) {
        //Manhattan Distance
        double xDiff = Math.abs(target.getPosition().getX() - this.getPosition().getX());
        double yDiff = Math.abs(target.getPosition().getY() - this.getPosition().getY());
        return xDiff + yDiff;
    }

    public int reachAble(Point position) {
    }

    public RobotType getType() {
        return type;
    }

    public Point getPosition() {
        return position;
    }

    public GameBoard getBoard() {
        return board;
    }
    public int getHealth(int x, int y) {
        return Math.abs(board.getCell(x, y));
    }

    public boolean isAlive() {
        return getHealth(position.x, position.y) > 0;
    }

    public boolean isBlockedTop() {
        return isBlocked(position.x - 1, position.y);
    }

    public boolean isBlockedBottom() {
        return isBlocked(position.x, position.y + 1);
    }

    public boolean isBlockedLeft() {
        return isBlocked(position.x, position.y - 1);
    }

    public boolean isBlockedRight() {
        return isBlocked(position.x + 1, position.y);
    }

    private boolean isBlocked(int x, int y) {
        return this.board.getCell(x, y) != 0;
    }
}
