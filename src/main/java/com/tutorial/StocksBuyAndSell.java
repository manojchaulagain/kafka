package com.tutorial;

public class StocksBuyAndSell {

    public static void main(String[] args) {
        int p = new StocksBuyAndSell().maxProfit(new int[]{
                5, 1, 3, 2, 4, 11
        });
        System.out.println(p);
    }


    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minSoFar > prices[i]) {
                minSoFar = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
            }
        }
        return maxProfit;
    }
}
