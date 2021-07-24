package com.tutorial;

public class BuySellStockKTransactions {

    public static void main(String[] args) {
        System.out.println(new BuySellStockKTransactions().maxProfit(new int[]{
                2, 5, 7, 1, 4, 3, 1, 3
        }, 3));
    }

    public int maxProfit(int[] arr, int k) {

        int[][] dp = new int[k + 1][arr.length];
        for (int dayOfTransaction = 0; dayOfTransaction <= k; dayOfTransaction++) {
            for (int priceCurDay = 0; priceCurDay < arr.length; priceCurDay++) {
                if (dayOfTransaction == 0 || priceCurDay == 0) {
                    dp[dayOfTransaction][priceCurDay] = 0;
                } else {
                    int index = 0;
                    int max = dp[dayOfTransaction][priceCurDay - 1];
                    while (index < priceCurDay) {
                        max = Math.max(arr[priceCurDay] - arr[index] + dp[dayOfTransaction - 1][index], max);
                        index++;
                    }
                    dp[dayOfTransaction][priceCurDay] = max;
                }
            }
        }
        return dp[k][arr.length - 1];
    }
}
