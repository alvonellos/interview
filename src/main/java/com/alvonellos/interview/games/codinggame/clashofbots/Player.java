package com.alvonellos.interview.games.codinggame.clashofbots;

import java.security.SecureRandom;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * https://www.codingame.com/ide/puzzle/clash-of-bots
 **/
public class Player {
    static class BotPlayer {
        Engine engine;

        public BotPlayer(Scanner in) {
            this.engine = new Engine(in);
        }

        public void play() {
            while (true) {
                String commands = engine.calculateCommands();
                System.err.println(commands);
            }
        }

        public enum RobotType {
            ALLY,
            ENEMY,
            EMPTY;

            public static RobotType getRobotType(int cell) {
                if (cell < 0) {
                    return RobotType.ENEMY;
                } else if (cell > 0) {
                    return ALLY;
                } else {
                    return RobotType.EMPTY;
                }
            }
        }

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
            MOVE_LEFT("MOVE LEFT", Effect.COLLISION, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, true, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            MOVE_RIGHT("MOVE RIGHT", Effect.COLLISION, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, true, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            MOVE_UP("MOVE UP", Effect.COLLISION, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, true, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            MOVE_DOWN("MOVE DOWN", Effect.COLLISION, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, true, false, false},
                    {false, false, false, false, false},
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
            ATTACK_LEFT("ATTACK LEFT", Effect.ATTACK, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, true, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            ATTACK_RIGHT("ATTACK RIGHT", Effect.ATTACK, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, true, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            ATTACK_UP("ATTACK UP", Effect.ATTACK, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, true, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
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
            ATTACK_DOWN("ATTACK DOWN", Effect.ATTACK, new boolean[][]{
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, false, false, false},
                    {false, false, true, false, false},
                    {false, false, false, false, false},
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
            SELFDESTRUCTION("SELFDESTRUCTION", Effect.SELFDESTRUCTION, new boolean[][]{
                    {false, false, false, false, false},
                    {false, true, true, true, false},
                    {false, true, true, true, false},
                    {false, true, true, true, false},
                    {false, false, false, false, false},
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

                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[0].length; j++) {
                        if (filter.test(map[i][j]) && effectRadius[i][j]) {
                            newMap[i][j] = this.getEffectPredicate().apply(map[i][j]);
                        }
                    }
                }
                return newMap;
            }
        }

        public enum Direction {
            UP("UP"),
            DOWN("DOWN"),
            LEFT("LEFT"),
            RIGHT("RIGHT"),
            NONE("NONE");
            private final String directionString;

            Direction(String directionString) {
                this.directionString = directionString;
            }

            public static Direction getDirectionTo(Point yourPoint, Point theirPoint) {
                return getDirectionTo(
                        yourPoint.x,
                        yourPoint.y,
                        theirPoint.x,
                        theirPoint.y
                );
            }

            public static Direction getDirectionTo(int yourX, int yourY, int theirX, int theirY) {
                if (yourX < theirX) {
                    return RIGHT;
                } else if (yourX > theirX) {
                    return LEFT;
                } else if (yourY < theirY) {
                    return DOWN;
                } else if (yourY > theirY) {
                    return UP;
                } else {
                    return NONE;
                }
            }


            private static boolean isCollision(int x, int y, int[][] map) {
                if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
                    // Out of bounds
                    return true;
                } else if (map[y][x] != 0) {
                    // Collision with another robot
                    return true;
                } else {
                    return false;
                }
            }
        }

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

        class GameStatistics implements Comparable<GameStatistics> {
            int[][] cells;

            public GameStatistics(int[][] cells) {
                this.cells = cells;
            }

            public boolean checkCells() {
                return Arrays.stream(cells).flatMapToInt(Arrays::stream).allMatch(
                        cell -> cell > -10 && cell < 10 && (cell > 0 || cell < 0 || cell == 0)
                );
            }

            public boolean isGameOver() {
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[0].length; j++) {
                        if (cells[i][j] > 0) {
                            return false;
                        }
                    }
                }
                return true;
            }

            public boolean isGameWon() {
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[0].length; j++) {
                        if (cells[i][j] < 0) {
                            return false;
                        }
                    }
                }
                return true;
            }

            public int numAllies() {
                return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
            }

            public int numEnemies() {
                return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
            }

            public int sumAllyHealth() {
                return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
            }

            public int sumEnemyHealth() {
                return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
            }

            public boolean isWinning() {
                int numAllies = numAllies();
                int numEnemies = numEnemies();
                int sumAllyHealth = sumAllyHealth();
                int sumEnemyHealth = sumEnemyHealth();

                if (numAllies > numEnemies) {
                    return true;
                } else {
                    if (numAllies == numEnemies) {
                        if (sumAllyHealth > sumEnemyHealth) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }


            @Override
            public int compareTo(GameStatistics o) {
                if(o == null) {
                    return 1;
                }

                if (this.isWinning() && o.isWinning()) {
                    // Compare number of allies
                    int numAlliesDiff = this.numAllies() - o.numAllies();
                    if (numAlliesDiff != 0) {
                        return numAlliesDiff;
                    }

                    // Compare sum of ally health
                    int sumAllyHealthDiff = this.sumAllyHealth() - o.sumAllyHealth();
                    if (sumAllyHealthDiff != 0) {
                        return sumAllyHealthDiff;
                    }

                    // Compare number of enemies
                    int numEnemiesDiff = this.numEnemies() - o.numEnemies();
                    if (numEnemiesDiff != 0) {
                        return numEnemiesDiff;
                    }

                    // Compare sum of enemy health
                    int sumEnemyHealthDiff = this.sumEnemyHealth() - o.sumEnemyHealth();
                    if (sumEnemyHealthDiff != 0) {
                        return sumEnemyHealthDiff;
                    }

                    return 0;
                } else if(this.isWinning() && !o.isWinning()) {
                    return -1;
                } else if(!this.isWinning() && o.isWinning()) {
                    return 1;
                } else {
                    //no clear answer, so calculate scores
                    int numAllies = this.numAllies();
                    int numEnemies = this.numEnemies();
                    int sumAllyHealth = this.sumAllyHealth();
                    int sumEnemyHealth = this.sumEnemyHealth();

                    if (numAllies > numEnemies) {
                        return 1;
                    } else if (numAllies < numEnemies) {
                        return -1;
                    } else {
                        if (sumAllyHealth > sumEnemyHealth) {
                            return 1;
                        } else if (sumAllyHealth < sumEnemyHealth) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }


        class Engine {
            private GameState state;

            public Engine(GameState state) {
                this.state = state;
            }

            public Engine(Scanner in) {
                this.state = new GameState(parseInput(in));
            }

            public GameState getState() {
                return state;
            }

            public Action getOptimalAction(GameState state, Robot robot) {
                RedBlackBST<GameStatistics, Action> possibleActions = new RedBlackBST<>();
                Arrays
                        .stream(Action.values())
                        .forEach(action -> {
                            int[][] currentMap = robot.getBoard().getCells();
                            int[][] newMap = action.applyAction(currentMap, x -> true);

                            GameStatistics currentState = new GameStatistics(currentMap);
                            GameStatistics newState = new GameStatistics(newMap);

                            //if the current state is worse or equal than the new state
                            if (currentState.compareTo(newState) <= 0) {
                                possibleActions.put(currentState, action);
                            }

                        });

                //TODO: prune tree with heuristic

                return possibleActions.get(possibleActions.max());
            }

            public List<Robot> parseInput(Scanner in) {
                int numberOfRobots = in.nextInt();
                log("identified: ", String.valueOf(numberOfRobots), " robots");
                List<Robot> robots = new ArrayList<>(numberOfRobots);

                int[][] board = new int[5][5];
                for (int r = 0; r < numberOfRobots; r++) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            board[i][j] = in.nextInt();
                        }
                    }
                    robots.add(new Robot(board));
                    in.nextLine(); // consume the rest of the line after the integers
                }
                return robots;
            }

            public String calculateCommands() {
                StringBuilder sb = new StringBuilder();
                for (Robot robot : state.robots) {
                    sb.append(getOptimalAction(this.state, robot));
                    sb.append(System.lineSeparator());
                }
                return sb.toString();
            }

        }

        class GameBoard {
            private int[][] cells;

            public GameBoard() {
                this.cells = new int[5][5];
                Arrays.fill(cells, 0);
                this.cells[2][2] = 10;
            }

            public GameBoard(int[][] cells) {
                this.cells = cells;
            }

            public int getCell(int x, int y) {
                return cells[y][x];
            }

            public void setCell(int x, int y, int value) {
                cells[y][x] = value;
            }

            public int getWidth() {
                return cells[0].length;
            }

            public int getHeight() {
                return cells.length;
            }

            public int[][] getCells() {
                return cells;
            }

            @Override
            public String toString() {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[0].length; j++) {
                        sb.append(cells[i][j]).append(" ");
                    }
                    sb.append(System.lineSeparator());
                }
                return sb.toString();
            }
        }

        class GameState {
            private List<Robot> robots;

            public GameState(List<Robot> robots) {
                this.robots = robots;
            }

            public List<Robot> getRobots() {
                return robots;
            }


            class GameStatistics implements Comparable<GameStatistics> {
                int[][] cells;

                public GameStatistics(int[][] cells) {
                    this.cells = cells;
                }

                public boolean checkCells() {
                    return Arrays.stream(cells).flatMapToInt(Arrays::stream).allMatch(
                            cell -> cell > -10 && cell < 10 && (cell > 0 || cell < 0 || cell == 0)
                    );
                }

                public boolean isGameOver() {
                    for (int i = 0; i < cells.length; i++) {
                        for (int j = 0; j < cells[0].length; j++) {
                            if (cells[i][j] > 0) {
                                return false;
                            }
                        }
                    }
                    return true;
                }

                public boolean isGameWon() {
                    for (int i = 0; i < cells.length; i++) {
                        for (int j = 0; j < cells[0].length; j++) {
                            if (cells[i][j] < 0) {
                                return false;
                            }
                        }
                    }
                    return true;
                }

                public int numAllies() {
                    return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
                }

                public int numEnemies() {
                    return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
                }

                public int sumAllyHealth() {
                    return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x > 0).sum();
                }

                public int sumEnemyHealth() {
                    return Arrays.stream(cells).flatMapToInt(Arrays::stream).filter(x -> x < 0).sum();
                }

                public boolean isWinning() {
                    int numAllies = numAllies();
                    int numEnemies = numEnemies();
                    int sumAllyHealth = sumAllyHealth();
                    int sumEnemyHealth = sumEnemyHealth();

                    if (numAllies > numEnemies) {
                        return true;
                    } else {
                        if (numAllies == numEnemies) {
                            if (sumAllyHealth > sumEnemyHealth) {
                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                }


                @Override
                public int compareTo(GameStatistics o) {
                    if (this.isWinning() && o.isWinning()) {
                        // Compare number of allies
                        int numAlliesDiff = this.numAllies() - o.numAllies();
                        if (numAlliesDiff != 0) {
                            return numAlliesDiff;
                        }

                        // Compare sum of ally health
                        int sumAllyHealthDiff = this.sumAllyHealth() - o.sumAllyHealth();
                        if (sumAllyHealthDiff != 0) {
                            return sumAllyHealthDiff;
                        }

                        // Compare number of enemies
                        int numEnemiesDiff = this.numEnemies() - o.numEnemies();
                        if (numEnemiesDiff != 0) {
                            return numEnemiesDiff;
                        }

                        // Compare sum of enemy health
                        int sumEnemyHealthDiff = this.sumEnemyHealth() - o.sumEnemyHealth();
                        if (sumEnemyHealthDiff != 0) {
                            return sumEnemyHealthDiff;
                        }

                        return 0;
                    } else if (this.isWinning() && !o.isWinning()) {
                        return -1;
                    } else if (!this.isWinning() && o.isWinning()) {
                        return 1;
                    } else {
                        //no clear answer, so calculate scores
                        int numAllies = this.numAllies();
                        int numEnemies = this.numEnemies();
                        int sumAllyHealth = this.sumAllyHealth();
                        int sumEnemyHealth = this.sumEnemyHealth();

                        if (numAllies > numEnemies) {
                            return 1;
                        } else if (numAllies < numEnemies) {
                            return -1;
                        } else {
                            if (sumAllyHealth > sumEnemyHealth) {
                                return 1;
                            } else if (sumAllyHealth < sumEnemyHealth) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        class Robot {

            private List<Robot> neighbors = new ArrayList<>();
            private List<Robot> targets = new ArrayList<>();
            private RobotType type;
            private Point position;
            private GameBoard board;

            public Robot(RobotType type, Point position, GameBoard board) {
                this.type = type;
                this.position = position;
                this.board = board;
                log("new robot: ", type.toString(), position.toString(), type.equals(RobotType.ALLY) && board != null ? this.getBoard().toString() : "");
            }

            public Robot(int[][] cells) {
                this(RobotType.ALLY, new Point(2,2), new GameBoard(cells));
            }

            public double distanceTo(Robot target) {
                //Manhattan Distance
                double xDiff = Math.abs(target.getPosition().getX() - this.getPosition().getX());
                double yDiff = Math.abs(target.getPosition().getY() - this.getPosition().getY());
                return xDiff + yDiff;
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

            public boolean isAllyRight() {
                return board.getCell(position.x + 1, position.y) > 0;
            }

            public boolean isAllyLeft() {
                return board.getCell(position.x - 1, position.y) > 0;
            }

            public boolean isEnemyRight() {
                return board.getCell(position.x + 1, position.y + 1) > 0;
            }

            public boolean isEnemyLeft() {
                return board.getCell(position.x - 1, position.y + 1) > 0;
            }

            public boolean isAllyTop() {
                return board.getCell(position.x, position.y - 1) > 0;
            }

            public boolean isAllyBottom() {
                return board.getCell(position.x, position.y + 1) > 0;
            }

            public boolean isEnemyTop() {
                return board.getCell(position.x, position.y - 1) > 0;
            }

            public boolean isEnemyBottom() {
                return board.getCell(position.x, position.y + 1) > 0;
            }

            public boolean isAllySurrounded() {
                return isAllyRight() && isAllyLeft() && isAllyTop() && isAllyBottom();
            }

            public boolean isEnemySurrounded() {
                return isEnemyRight() && isEnemyLeft() && isEnemyTop() && isEnemyBottom();
            }

            public boolean isBlockedTotally() {
                return isBlockedTop() && isBlockedBottom() && isBlockedLeft() && isBlockedRight();
            }

            private boolean isBlocked(int x, int y) {
                return this.board.getCell(x, y) != 0;
            }

        }

        class Node<T extends Comparable<? super T>> implements Comparable<Node<T>> {
            private static final boolean DEBUG = false;
            private Node<T> next;
            private Node<T> prev;

            private T datum;
            private boolean isHead = false;

            /**
             * Special constructor for one node with a boolean variable denoting whether this node is a head or not.
             *
             * @param isHead Is this the head?
             * @param datum  The data to store.
             */
            public Node(boolean isHead, T datum) {
                this.setDatum(datum);
                this.setHead(isHead);
                debug("ctor: Node(boolean isHead, T datum) " + this);
            }

            /**
             * Generic constructor for just one node with a datum;
             *
             * @param datum the data to store in the node
             */
            public Node(T datum) {
                this(false, datum);
                this.setDatum(datum);
                debug("ctor: Node(T datum) " + this);
            }

            /**
             * Generic constructor for two nodes with a datum and a next node.
             *
             * @param leftOrPrev  the left or previous node
             * @param rightOrNext the right or next node
             * @param datum       the datum of the node
             */
            public Node(Node<T> leftOrPrev, Node<T> rightOrNext, T datum) {
                this(false, datum);
                this.setLeft(leftOrPrev);
                this.setRight(rightOrNext);
                debug("ctor: Node(Node left, Node right, T datum) " + this);
            }

            /**
             * sets the right node of the current node
             *
             * @param right the node to set
             */
            private void setRight(Node<T> right) {
                this.setNext(right);
            }

            /**
             * sets the left node of the current node
             *
             * @param left the node to set
             */
            private void setLeft(Node<T> left) {
                this.prev = left;
            }


            /**
             * This constructor sets just a blank node with default values.
             */
            public Node() {
                this(false, null);
                this.isHead = false;
                this.datum = null;
                debug("ctor: Node() " + this);
            }


            public Node<T> getLeft() {
                return this.getPrev();
            }

            public Node<T> getRight() {
                return this.getNext();
            }

            /**
             * gets the next node
             *
             * @return the next node
             */
            public Node<T> getNext() {
                return this.next;
            }

            /**
             * Sets the next node
             *
             * @param next the next node
             */
            public void setNext(Node<T> next) {
                this.next = next;
            }

            /**
             * gets the previous node
             *
             * @return The previous node
             */
            public Node<T> getPrev() {
                return this.prev;
            }

            /**
             * Sets the previous node
             *
             * @param prev The previous node
             */
            public void setPrev(Node<T> prev) {
                this.prev = prev;
            }

            /**
             * sets whether or not this is the head.
             *
             * @param value true if it is the head, false if it is not.
             */
            public void setHead(boolean value) {
                this.isHead = value;
            }

            /**
             * Returns whether or not this node has been specified as the head.
             *
             * @return a boolean, true if it is the head, and false if it is not
             */
            public boolean getHead() {
                return this.isHead;
            }

            /**
             * Sets the datum stored in this object
             *
             * @param datum the datum.
             */
            public void setDatum(T datum) {
                this.datum = datum;
            }

            /**
             * Gets the datum stored in this object
             *
             * @return the datum
             */
            public T getDatum() {
                return this.datum;
            }


            // String representation of this object.
            public String toString() {
                String s = "";
                s += " This-> "; //+ addrString(this);
                s += " Prev-> "; //+ addrString(prev);
                s += " Next-> "; //+ addrString(next);
                String datums = (this.datum != null) ? this.datum.toString() : "null";
                s += " Datum->" + datums;
                s += " isHead->" + this.isHead;
                return s;

            }


            @Override
            public int compareTo(Node<T> o) {
                return this.getDatum().compareTo(o.getDatum());
            }

            @Override
            public boolean equals(Object o) {
                try {
                    return this.compareTo((Node<T>) o) == 0;
                } catch (ClassCastException e) {
                    return false;
                }
            }

            private void debug(String message) {
                if (DEBUG) {
                    System.err.println(message);
                }
            }

        }

        class Queue <T extends Comparable<T>> implements Iterable<T> {
            private final int size;
            private final T[] elements;

            public Queue() {
                this(100);
            }
            public Queue(int size) {
                this.size = size;
                this.elements = (T[]) new Comparable[size];
            }

            /**
             * Adds an element to the queue.
             * @param element
             */
            public void enqueue(T element) {
                if (isFull()) {
                    throw new IllegalStateException("Queue is full");
                }
                int index = 0;
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null) {
                        index = i;
                        break;
                    }
                }
                elements[index] = element;
            }

            /**
             * @return the element at the front of the queue.
             */
            public T dequeue() {
                if (isEmpty()) {
                    throw new IllegalStateException("Queue is empty");
                }
                T element = elements[0];
                for (int i = 0; i < size; i++) {
                    if (i == size - 1) {
                        elements[i] = null;
                    } else {
                        elements[i] = elements[i + 1];
                    }
                }
                return element;
            }

            /**
             * @return true if the queue is empty, false otherwise.
             */
            public boolean isEmpty() {
                for (int i = 0; i < size; i++) {
                    if (elements[i] != null) {
                        return false;
                    }
                }
                return true;
            }

            /**
             * Check if the queue is full
             * @return true if the queue is full, false otherwise
             */
            public boolean isFull() {
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null) {
                        return false;
                    }
                }
                return true;
            }

            /**
             *
             * Look at the first element in the queue without removing it.
             * @return
             */
            public T peek() {
                if (isEmpty()) {
                    throw new IllegalStateException("Queue is empty");
                }
                return elements[0];
            }

            /**
             * Returns an iterator over elements of type {@code T}.
             *
             * @return an Iterator.
             */
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int index = 0;
                    @Override
                    public boolean hasNext() {
                        return index < size;
                    }
                    @Override
                    public T next() {
                        return elements[index++];
                    }
                };
            }
        }

        class RedBlackBST<Key extends Comparable<Key>, Value> {

            private static final boolean RED = true;
            private static final boolean BLACK = false;

            private Node root;     // root of the BST

            // BST helper node data type
            private class Node {
                private Key key;           // key
                private Value val;         // associated data
                private Node left, right;  // links to left and right subtrees
                private boolean color;     // color of parent link
                private int size;          // subtree count

                public Node(Key key, Value val, boolean color, int size) {
                    this.key = key;
                    this.val = val;
                    this.color = color;
                    this.size = size;
                }
            }

            /**
             * Initializes an empty symbol table.
             */
            public RedBlackBST() {
            }

            /***************************************************************************
             *  Node helper methods.
             ***************************************************************************/
            // is node x red; false if x is null ?
            private boolean isRed(Node x) {
                if (x == null) return false;
                return x.color == RED;
            }

            // number of node in subtree rooted at x; 0 if x is null
            private int size(Node x) {
                if (x == null) return 0;
                return x.size;
            }


            /**
             * Returns the number of key-value pairs in this symbol table.
             *
             * @return the number of key-value pairs in this symbol table
             */
            public int size() {
                return size(root);
            }

            /**
             * Is this symbol table empty?
             *
             * @return {@code true} if this symbol table is empty and {@code false} otherwise
             */
            public boolean isEmpty() {
                return root == null;
            }


            /***************************************************************************
             *  Standard BST search.
             ***************************************************************************/

            /**
             * Returns the value associated with the given key.
             *
             * @param key the key
             * @return the value associated with the given key if the key is in the symbol table
             * and {@code null} if the key is not in the symbol table
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public Value get(Key key) {
                if (key == null) throw new IllegalArgumentException("argument to get() is null");
                return get(root, key);
            }

            // value associated with the given key in subtree rooted at x; null if no such key
            private Value get(Node x, Key key) {
                while (x != null) {
                    int cmp = key.compareTo(x.key);
                    if (cmp < 0) x = x.left;
                    else if (cmp > 0) x = x.right;
                    else return x.val;
                }
                return null;
            }

            /**
             * Does this symbol table contain the given key?
             *
             * @param key the key
             * @return {@code true} if this symbol table contains {@code key} and
             * {@code false} otherwise
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public boolean contains(Key key) {
                return get(key) != null;
            }

            /***************************************************************************
             *  Red-black tree insertion.
             ***************************************************************************/

            /**
             * Inserts the specified key-value pair into the symbol table, overwriting the old
             * value with the new value if the symbol table already contains the specified key.
             * Deletes the specified key (and its associated value) from this symbol table
             * if the specified value is {@code null}.
             *
             * @param key the key
             * @param val the value
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public void put(Key key, Value val) {
                if (key == null) throw new IllegalArgumentException("first argument to put() is null");
                if (val == null) {
                    delete(key);
                    return;
                }

                root = put(root, key, val);
                root.color = BLACK;
                // assert check();
            }

            // insert the key-value pair in the subtree rooted at h
            private Node put(Node h, Key key, Value val) {
                if (h == null) return new Node(key, val, RED, 1);

                int cmp = key.compareTo(h.key);
                if (cmp < 0) h.left = put(h.left, key, val);
                else if (cmp > 0) h.right = put(h.right, key, val);
                else h.val = val;

                // fix-up any right-leaning links
                if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
                if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
                if (isRed(h.left) && isRed(h.right)) flipColors(h);
                h.size = size(h.left) + size(h.right) + 1;

                return h;
            }

            /***************************************************************************
             *  Red-black tree deletion.
             ***************************************************************************/

            /**
             * Removes the smallest key and associated value from the symbol table.
             *
             * @throws NoSuchElementException if the symbol table is empty
             */
            public void deleteMin() {
                if (isEmpty()) throw new NoSuchElementException("BST underflow");

                // if both children of root are black, set root to red
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;

                root = deleteMin(root);
                if (!isEmpty()) root.color = BLACK;
                // assert check();
            }

            // delete the key-value pair with the minimum key rooted at h
            private Node deleteMin(Node h) {
                if (h.left == null)
                    return null;

                if (!isRed(h.left) && !isRed(h.left.left))
                    h = moveRedLeft(h);

                h.left = deleteMin(h.left);
                return balance(h);
            }


            /**
             * Removes the largest key and associated value from the symbol table.
             *
             * @throws NoSuchElementException if the symbol table is empty
             */
            public void deleteMax() {
                if (isEmpty()) throw new NoSuchElementException("BST underflow");

                // if both children of root are black, set root to red
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;

                root = deleteMax(root);
                if (!isEmpty()) root.color = BLACK;
                // assert check();
            }

            // delete the key-value pair with the maximum key rooted at h
            private Node deleteMax(Node h) {
                if (isRed(h.left))
                    h = rotateRight(h);

                if (h.right == null)
                    return null;

                if (!isRed(h.right) && !isRed(h.right.left))
                    h = moveRedRight(h);

                h.right = deleteMax(h.right);

                return balance(h);
            }

            /**
             * Removes the specified key and its associated value from this symbol table
             * (if the key is in this symbol table).
             *
             * @param key the key
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public void delete(Key key) {
                if (key == null) throw new IllegalArgumentException("argument to delete() is null");
                if (!contains(key)) return;

                // if both children of root are black, set root to red
                if (!isRed(root.left) && !isRed(root.right))
                    root.color = RED;

                root = delete(root, key);
                if (!isEmpty()) root.color = BLACK;
                // assert check();
            }

            // delete the key-value pair with the given key rooted at h
            private Node delete(Node h, Key key) {
                // assert get(h, key) != null;

                if (key.compareTo(h.key) < 0) {
                    if (!isRed(h.left) && !isRed(h.left.left))
                        h = moveRedLeft(h);
                    h.left = delete(h.left, key);
                } else {
                    if (isRed(h.left))
                        h = rotateRight(h);
                    if (key.compareTo(h.key) == 0 && (h.right == null))
                        return null;
                    if (!isRed(h.right) && !isRed(h.right.left))
                        h = moveRedRight(h);
                    if (key.compareTo(h.key) == 0) {
                        Node x = min(h.right);
                        h.key = x.key;
                        h.val = x.val;
                        // h.val = get(h.right, min(h.right).key);
                        // h.key = min(h.right).key;
                        h.right = deleteMin(h.right);
                    } else h.right = delete(h.right, key);
                }
                return balance(h);
            }

            /***************************************************************************
             *  Red-black tree helper functions.
             ***************************************************************************/

            // make a left-leaning link lean to the right
            private Node rotateRight(Node h) {
                assert (h != null) && isRed(h.left);
                // assert (h != null) && isRed(h.left) &&  !isRed(h.right);  // for insertion only
                Node x = h.left;
                h.left = x.right;
                x.right = h;
                x.color = h.color;
                h.color = RED;
                x.size = h.size;
                h.size = size(h.left) + size(h.right) + 1;
                return x;
            }

            // make a right-leaning link lean to the left
            private Node rotateLeft(Node h) {
                assert (h != null) && isRed(h.right);
                // assert (h != null) && isRed(h.right) && !isRed(h.left);  // for insertion only
                Node x = h.right;
                h.right = x.left;
                x.left = h;
                x.color = h.color;
                h.color = RED;
                x.size = h.size;
                h.size = size(h.left) + size(h.right) + 1;
                return x;
            }

            // flip the colors of a node and its two children
            private void flipColors(Node h) {
                // h must have opposite color of its two children
                // assert (h != null) && (h.left != null) && (h.right != null);
                // assert (!isRed(h) &&  isRed(h.left) &&  isRed(h.right))
                //    || (isRed(h)  && !isRed(h.left) && !isRed(h.right));
                h.color = !h.color;
                h.left.color = !h.left.color;
                h.right.color = !h.right.color;
            }

            // Assuming that h is red and both h.left and h.left.left
            // are black, make h.left or one of its children red.
            private Node moveRedLeft(Node h) {
                // assert (h != null);
                // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

                flipColors(h);
                if (isRed(h.right.left)) {
                    h.right = rotateRight(h.right);
                    h = rotateLeft(h);
                    flipColors(h);
                }
                return h;
            }

            // Assuming that h is red and both h.right and h.right.left
            // are black, make h.right or one of its children red.
            private Node moveRedRight(Node h) {
                // assert (h != null);
                // assert isRed(h) && !isRed(h.right) && !isRed(h.right.left);
                flipColors(h);
                if (isRed(h.left.left)) {
                    h = rotateRight(h);
                    flipColors(h);
                }
                return h;
            }

            // restore red-black tree invariant
            private Node balance(Node h) {
                // assert (h != null);

                if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
                if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
                if (isRed(h.left) && isRed(h.right)) flipColors(h);

                h.size = size(h.left) + size(h.right) + 1;
                return h;
            }


            /***************************************************************************
             *  Utility functions.
             ***************************************************************************/

            /**
             * Returns the height of the BST (for debugging).
             *
             * @return the height of the BST (a 1-node tree has height 0)
             */
            public int height() {
                return height(root);
            }

            private int height(Node x) {
                if (x == null) return -1;
                return 1 + Math.max(height(x.left), height(x.right));
            }

            /***************************************************************************
             *  Ordered symbol table methods.
             ***************************************************************************/

            /**
             * Returns the smallest key in the symbol table.
             *
             * @return the smallest key in the symbol table
             * @throws NoSuchElementException if the symbol table is empty
             */
            public Key min() {
                if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
                return min(root).key;
            }

            // the smallest key in subtree rooted at x; null if no such key
            private Node min(Node x) {
                // assert x != null;
                if (x.left == null) return x;
                else return min(x.left);
            }

            /**
             * Returns the largest key in the symbol table.
             *
             * @return the largest key in the symbol table
             * @throws NoSuchElementException if the symbol table is empty
             */
            public Key max() {
                if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
                return max(root).key;
            }

            // the largest key in the subtree rooted at x; null if no such key
            private Node max(Node x) {
                // assert x != null;
                if (x.right == null) return x;
                else return max(x.right);
            }


            /**
             * Returns the largest key in the symbol table less than or equal to {@code key}.
             *
             * @param key the key
             * @return the largest key in the symbol table less than or equal to {@code key}
             * @throws NoSuchElementException   if there is no such key
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public Key floor(Key key) {
                if (key == null) throw new IllegalArgumentException("argument to floor() is null");
                if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
                Node x = floor(root, key);
                if (x == null) throw new NoSuchElementException("argument to floor() is too small");
                else return x.key;
            }

            // the largest key in the subtree rooted at x less than or equal to the given key
            private Node floor(Node x, Key key) {
                if (x == null) return null;
                int cmp = key.compareTo(x.key);
                if (cmp == 0) return x;
                if (cmp < 0) return floor(x.left, key);
                Node t = floor(x.right, key);
                if (t != null) return t;
                else return x;
            }

            /**
             * Returns the smallest key in the symbol table greater than or equal to {@code key}.
             *
             * @param key the key
             * @return the smallest key in the symbol table greater than or equal to {@code key}
             * @throws NoSuchElementException   if there is no such key
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public Key ceiling(Key key) {
                if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
                if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
                Node x = ceiling(root, key);
                if (x == null) throw new NoSuchElementException("argument to ceiling() is too large");
                else return x.key;
            }

            // the smallest key in the subtree rooted at x greater than or equal to the given key
            private Node ceiling(Node x, Key key) {
                if (x == null) return null;
                int cmp = key.compareTo(x.key);
                if (cmp == 0) return x;
                if (cmp > 0) return ceiling(x.right, key);
                Node t = ceiling(x.left, key);
                if (t != null) return t;
                else return x;
            }

            /**
             * Return the key in the symbol table of a given {@code rank}.
             * This key has the property that there are {@code rank} keys in
             * the symbol table that are smaller. In other words, this key is the
             * ({@code rank}+1)st smallest key in the symbol table.
             *
             * @param rank the order statistic
             * @return the key in the symbol table of given {@code rank}
             * @throws IllegalArgumentException unless {@code rank} is between 0 and
             *                                  <em>n</em>–1
             */
            public Key select(int rank) {
                if (rank < 0 || rank >= size()) {
                    throw new IllegalArgumentException("argument to select() is invalid: " + rank);
                }
                return select(root, rank);
            }

            // Return key in BST rooted at x of given rank.
            // Precondition: rank is in legal range.
            private Key select(Node x, int rank) {
                if (x == null) return null;
                int leftSize = size(x.left);
                if (leftSize > rank) return select(x.left, rank);
                else if (leftSize < rank) return select(x.right, rank - leftSize - 1);
                else return x.key;
            }

            /**
             * Return the number of keys in the symbol table strictly less than {@code key}.
             *
             * @param key the key
             * @return the number of keys in the symbol table strictly less than {@code key}
             * @throws IllegalArgumentException if {@code key} is {@code null}
             */
            public int rank(Key key) {
                if (key == null) throw new IllegalArgumentException("argument to rank() is null");
                return rank(key, root);
            }

            // number of keys less than key in the subtree rooted at x
            private int rank(Key key, Node x) {
                if (x == null) return 0;
                int cmp = key.compareTo(x.key);
                if (cmp < 0) return rank(key, x.left);
                else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
                else return size(x.left);
            }

            /***************************************************************************
             *  Range count and range search.
             ***************************************************************************/

            /**
             * Returns all keys in the symbol table in ascending order as an {@code Iterable}.
             * To iterate over all of the keys in the symbol table named {@code st},
             * use the foreach notation: {@code for (Key key : st.keys())}.
             *
             * @return all keys in the symbol table in ascending order
             */
            public Iterable<Key> keys() {
                if (isEmpty()) return new Queue<>(this.size());
                return keys(min(), max());
            }

            /**
             * Returns all keys in the symbol table in the given range in ascending order,
             * as an {@code Iterable}.
             *
             * @param lo minimum endpoint
             * @param hi maximum endpoint
             * @return all keys in the symbol table between {@code lo}
             * (inclusive) and {@code hi} (inclusive) in ascending order
             * @throws IllegalArgumentException if either {@code lo} or {@code hi}
             *                                  is {@code null}
             */
            public Iterable<Key> keys(Key lo, Key hi) {
                if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
                if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

                Queue<Key> queue = new Queue<Key>(this.size());
                // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
                keys(root, queue, lo, hi);
                return queue;
            }

            // add the keys between lo and hi in the subtree rooted at x
            // to the queue
            private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
                if (x == null) return;
                int cmplo = lo.compareTo(x.key);
                int cmphi = hi.compareTo(x.key);
                if (cmplo < 0) keys(x.left, queue, lo, hi);
                if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
                if (cmphi > 0) keys(x.right, queue, lo, hi);
            }

            /**
             * Returns the number of keys in the symbol table in the given range.
             *
             * @param lo minimum endpoint
             * @param hi maximum endpoint
             * @return the number of keys in the symbol table between {@code lo}
             * (inclusive) and {@code hi} (inclusive)
             * @throws IllegalArgumentException if either {@code lo} or {@code hi}
             *                                  is {@code null}
             */
            public int size(Key lo, Key hi) {
                if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
                if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

                if (lo.compareTo(hi) > 0) return 0;
                if (contains(hi)) return rank(hi) - rank(lo) + 1;
                else return rank(hi) - rank(lo);
            }


            /***************************************************************************
             *  Check integrity of red-black tree data structure.
             ***************************************************************************/
            private boolean check() {
                if (!isBST()) System.out.println("Not in symmetric order");
                if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
                if (!isRankConsistent()) System.out.println("Ranks not consistent");
                if (!is23()) System.out.println("Not a 2-3 tree");
                if (!isBalanced()) System.out.println("Not balanced");
                return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
            }

            // does this binary tree satisfy symmetric order?
            // Note: this test also ensures that data structure is a binary tree since order is strict
            private boolean isBST() {
                return isBST(root, null, null);
            }

            // is the tree rooted at x a BST with all keys strictly between min and max
            // (if min or max is null, treat as empty constraint)
            // Credit: Bob Dondero's elegant solution
            private boolean isBST(Node x, Key min, Key max) {
                if (x == null) return true;
                if (min != null && x.key.compareTo(min) <= 0) return false;
                if (max != null && x.key.compareTo(max) >= 0) return false;
                return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
            }

            // are the size fields correct?
            private boolean isSizeConsistent() {
                return isSizeConsistent(root);
            }

            private boolean isSizeConsistent(Node x) {
                if (x == null) return true;
                if (x.size != size(x.left) + size(x.right) + 1) return false;
                return isSizeConsistent(x.left) && isSizeConsistent(x.right);
            }

            // check that ranks are consistent
            private boolean isRankConsistent() {
                for (int i = 0; i < size(); i++)
                    if (i != rank(select(i))) return false;
                for (Key key : keys())
                    if (key.compareTo(select(rank(key))) != 0) return false;
                return true;
            }

            // Does the tree have no red right links, and at most one (left)
            // red links in a row on any path?
            private boolean is23() {
                return is23(root);
            }

            private boolean is23(Node x) {
                if (x == null) return true;
                if (isRed(x.right)) return false;
                if (x != root && isRed(x) && isRed(x.left))
                    return false;
                return is23(x.left) && is23(x.right);
            }

            // do all paths from root to leaf have same number of black edges?
            private boolean isBalanced() {
                int black = 0;     // number of black links on path from root to min
                Node x = root;
                while (x != null) {
                    if (!isRed(x)) black++;
                    x = x.left;
                }
                return isBalanced(root, black);
            }

            // does every path from the root to a leaf have the given number of black links?
            private boolean isBalanced(Node x, int black) {
                if (x == null) return black == 0;
                if (!isRed(x)) black--;
                return isBalanced(x.left, black) && isBalanced(x.right, black);
            }

        }
    }


    static final long RANDOM_SEED = 42;
    static final Random random = new Random(RANDOM_SEED);

    public static void log(String... msg) {
        Arrays.stream(msg).forEach(x -> System.err.print(x));
        System.err.println();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BotPlayer botPlayer;
        botPlayer = new BotPlayer(in);
        log("init");
        botPlayer.play();
    }
}

