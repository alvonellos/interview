import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * https://www.codingame.com/ide/puzzle/clash-of-bots
 *
 **/
class Player {

    public static void log(String... msg) {
        Arrays.stream(msg).forEach(x -> System.err.print(x));
        System.err.println();
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        log("init");
        // game loop
        while (true) {
            GameState gameState = GameState.parseInput(in);
            log("parsed game state");
            StringBuffer commands = new StringBuffer();
            for (Robot robot : gameState.robots) {
                Action action = Engine.predictAction(gameState, robot);
                commands.append(action.getActionString());
                commands.append(System.lineSeparator());
            }
            System.out.print(commands.toString());
        }
    }

    static class GameState {
        private List<Robot> robots;

        public GameState(List<Robot> robots) {
            this.robots = robots;
        }

        public List<Robot> getRobots() {
            return robots;
        }

        public static GameState parseInput(Scanner in) {
            int numberOfRobots = in.nextInt();
            log("identified: ", String.valueOf(numberOfRobots), " robots");
            List<Robot> robots = new ArrayList<>(numberOfRobots);

            for (int r = 0; r < numberOfRobots; r++) {
                int[][] cells = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        cells[i][j] = in.nextInt();
                    }
                }
                robots.add(new Robot(RobotType.ALLY, new GameBoard(cells)));
                in.nextLine(); // consume the rest of the line after the integers
            }
            return new GameState(robots);
        }
    }

    static class Robot {
        // A helper class to store a robot and its score
        class RobotScore implements Comparable<RobotScore> {
            private Robot robot;
            private double score;

            public RobotScore(Robot robot, double score) {
                this.robot = robot;
                this.score = score;
            }

            public Robot getRobot() {
                return robot;
            }

            public double getScore() {
                return score;
            }

            @Override
            public int compareTo(RobotScore other) {
                return Double.compare(other.getScore(), this.score);
            }
        }
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

        private static final int centerX = 2;
        private static final int centerY = 2;

        public Robot(RobotType type, GameBoard board) {
            this(type, new Point(centerX, centerY), board);
        }

        public Robot(RobotType type, Point position, GameBoard board) {
            this.type = type;
            this.position = position;
            this.board = board;
            log("new robot: ", type.toString(), position.toString(), type.equals(RobotType.ALLY) && board != null ? this.getBoard().printBoard() : "");
        }

        public Robot getNextTarget(List<Robot> neighbors) {
            // Determine the criteria for selecting the target
            double maxDistance = 100; // Maximum distance from robot to target
            double maxHealth = 100; // Maximum health of a target
            double maxOffense = 100; // Maximum offensive capability of a target

            // Assign scores to each potential target based on the criteria
            List<RobotScore> scores = new ArrayList<>();
            for (Robot target : neighbors) {
                double distanceScore = 1 - (this.distanceTo(target) / maxDistance);
                double healthScore = target.getHealth() / maxHealth;
                double totalScore = distanceScore + healthScore;
                scores.add(new RobotScore(target, totalScore));
            }

            // Sort the list of neighbors by score
            Collections.sort(scores);

            // Return the highest-scoring target
            if (scores.size() > 0) {
                return scores.get(0).getRobot();
            } else {
                return null;
            }
        }

        public List<Robot> getNeighbors(boolean immediate) {
            List<Robot> neighbors = new ArrayList<>();
            if(board == null) {
                log("board is null");
                return Collections.EMPTY_LIST;
            }

            for (int i = 0; i < board.getHeight(); i++) {
                for (int j = 0; j < board.getWidth(); j++) {
                    if (crit_points[i][j] == 1 && immediate) {
                        int cell = board.getCell(j, i);
                        switch(RobotType.getRobotType(cell)) {
                            case ENEMY:
                                log("identified enemy nearby: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ENEMY, new Point(j, i), board));
                                break;
                            case ALLY:
                                log("identified ally nearby: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ALLY, new Point(j, i), board));
                                break;
                            default:
                                break;
                        }
                    } else if (crit_points[i][j] == 2 && !immediate) {
                        int cell = board.getCell(j, i);
                        switch(RobotType.getRobotType(cell)) {
                            case ENEMY:
                                log("identified enemy one step away: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ENEMY, new Point(j, i), board));
                                break;
                            case ALLY:
                                log("identified ally one step away: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ALLY, new Point(j, i), board));
                                break;
                            default:
                                break;
                        }
                    } else if (crit_points[i][j] == 3 && !immediate) {
                        int cell = board.getCell(j, i);
                        switch(RobotType.getRobotType(cell)) {
                            case ENEMY:
                                log("identified enemy far far away: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ENEMY, new Point(j, i), board));
                                break;
                            case ALLY:
                                log("identified ally far far away: ", "" + j, "" + i);
                                neighbors.add(new Robot(RobotType.ALLY, new Point(j, i), board));
                                break;
                            default:
                                break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return neighbors;
        }

        public double distanceTo(Robot target) {
            double xDiff = Math.abs(target.getPosition().getX() - this.getPosition().getX());
            double yDiff = Math.abs(target.getPosition().getY() - this.getPosition().getY());
            return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
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

        public int getHealth() {
            return Math.abs(board.getCell(centerX, centerY));
        }

        public int getHealth(int x, int y) {
            return Math.abs(board.getCell(x, y));
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
                return RobotType.ALLY;
            } else {
                return RobotType.EMPTY;
            }
        }
    }

    static class GameBoard {
        private int[][] cells;

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

        public String printBoard() {
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

    enum Direction {
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
    }

    enum Action {
        GUARD("GUARD"),
        MOVE_LEFT("MOVE LEFT"),
        MOVE_RIGHT("MOVE RIGHT"),
        MOVE_UP("MOVE UP"),
        MOVE_DOWN("MOVE DOWN"),
        ATTACK_LEFT("ATTACK LEFT"),
        ATTACK_RIGHT("ATTACK RIGHT"),
        ATTACK_UP("ATTACK UP"),
        ATTACK_DOWN("ATTACK DOWN"),
        SELFDESTRUCTION("SELFDESTRUCTION");

        private final String actionString;

        Action(String actionString) {
            this.actionString = actionString;
        }

        public String getActionString() {
            return actionString;
        }
    }

    static class Engine {
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

}

