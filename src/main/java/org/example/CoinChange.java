package org.example;


import java.util.Arrays;
import java.util.Collections;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 * */
public class CoinChange {
    public static void main (String args []){
        int coins [] = {5,1,2};
        int coins1 [] = {2};
        int coins2 [] = {1};
        System.out.println(new CoinChange().coinChange(coins,11));
    }

    public int coinChange(int[] coins, int amount) {
       int [] dp = new int[amount+1];
       Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }
}
