package com.alvonellos.interview.games.codinggame.transpose;

import java.util.*;
import java.io.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

    public static int[][] loadArray(Scanner in) {
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = in.nextInt();
                array[i][j] = value;
            }
        }
        return array;
    }

    public static void saveArray(PrintStream printStream, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        printStream.println(rows);
        printStream.println(cols);
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                printStream.print(array[i][j] + (j == cols-1? "" : " "));
            }
            printStream.println();
        }
    }

    public static int[][] transpose(int[][] array)  {
        int[][] result = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[j][i] = array[i][j];
            }
        }
        return result;
    }

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int[][] input = loadArray(in);
        int[][] output = transpose(input);
        saveArray(System.out, output);
    }
}