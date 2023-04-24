package com.alvonellos.interview.games.codinggame.clashofbots;

import java.security.SecureRandom;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.Point;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * https://www.codingame.com/ide/puzzle/clash-of-bots
 *
 **/
public class Player {

    static final long RANDOM_SEED = 42;
    static final Random random = new Random(RANDOM_SEED);
    static class CONSTANTS {

    }

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

            String commands = gameState.getRobots().stream().map(robot -> Engine.predictAction(gameState, robot)).map(action -> action.getActionString() + System.lineSeparator()).collect(Collectors.joining());
            System.out.print(commands);
        }
    }


}

