package org.example;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * */
public class ClimbingStairs {
    public static void main(String [] args){
        System.out.println(new ClimbingStairs().climbStairsRecur(3));
    }
    public int climbStairs(int n) {
        int result = 0;
        if (n <= 1) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int totalWays = 0;

        for (int i = 2; i <= n; i++) {
            totalWays = first + second;
            first = second;
            second = totalWays;
        }


        return totalWays;
    }

    public int climbStairsRecur(int n) {
        if (n <= 1) {
            return 1;
        }
        return climbStairsRecur(n-1)+climbStairsRecur(n-2);
    }
}
