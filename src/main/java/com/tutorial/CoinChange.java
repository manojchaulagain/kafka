package com.tutorial;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int x = coinChange(new int[]{186, 419, 83, 408}, 6249);
        System.out.println(x);
    }
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length + 1][amount + 1];

        for(int i = 0; i <= coins.length; i++) {
            for(int j = 0; j <= amount; j++) {
                if(i == 0 || j == 0) {
                    if(i == 0)
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    if (j == 0)
                        dp[i][j] = 0;
                } else {
                    if(coins[i - 1] > j) {
                        dp[i][j] = dp[i -1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], (j / coins[i - 1]) + dp[i - 1][j % coins[i - 1]]);
                    }
                }
            }
        }
        return Math.abs(dp[coins.length][amount]) > amount ? -1 : dp[coins.length][amount];
    }
}
