package com.alvonellos.interview.games.codechef.validstackoperations;

/**
 * Problem
 * You have a stack which is initially empty. You receive instructions of the form 1 or 0. 1
 * denotes that you have to push in an element, and 0 denotes that you have to pop out an element.
 * But of course you can pop something out only if it exists in the stack. So your job is to
 * look at the instructions and see if they are valid (ie. you never have to pop from an empty
 * stack), or not.
 *
 * Input
 * The first line of the input contains a single integers TT, which denotes the number of testcases.
 * The first line of each testcase contains a single integer nn, which denotes the number of instructions.
 * The second line contains nn space separated integers, which are all 0 or 1.
 * Output
 * For each testcase output either "Valid" or "Invalid", in a new line.
 * Constraints
 * 1 \leq T \leq 101≤T≤10
 * 1 \leq n \leq 10^51≤n≤10
 * 5
 *
 * All instructions are either 0 or 1.
 * Sample Input
 * 2
 * 5
 * 1 1 0 0 1
 * 5
 * 1 0 0 1 1
 * Sample Output
 * Valid
 * Invalid
 * Explanation
 * Testcase 2: You first push something, and then pop it out. So now you have an empty stack,
 * but the next operation is a Pop, and hence this is Invalid.
 */

import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of test cases
        System.err.println("N: " + n);
        for(int i=0;i<n;i++) { // loop through each set of numbers
            int n2 = in.nextInt();

            Stack<Integer> nums = new Stack<Integer>();

            for(int j=0;j<n2;j++) {
                int num = in.nextInt();
                if(num == 1) {
                    nums.push(num);
                } else {
                    if(nums.isEmpty()) {
                        System.out.println("Invalid");
                        break;
                    } else {
                        nums.pop();
                    }
                }
                if(j == n2-1) {
                    System.out.println("Valid");
                }
            }
        }
    }
}
