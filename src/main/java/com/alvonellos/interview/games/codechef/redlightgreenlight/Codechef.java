package com.alvonellos.interview.games.codechef.redlightgreenlight;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0;i<t;i++) {
            int N = in.nextInt();
            int K = in.nextInt();

            int[] heights = new int[N];
            for(int j=0;j<N;j++) {
                heights[j] = in.nextInt();
                System.err.print(heights[j] + " ");
            }

            System.out.println(Arrays.stream(heights).filter(i -> i > K).count());
        }
    }
}
