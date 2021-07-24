package com.tutorial;

import scala.Int;

public class MinCoins {

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] coins = {1, 5, 6, 8};
        int money = 11;
        System.out.println(minCoins(coins, money, 0));


    }

    private static int minCoins(int[] coins, int money, int index) {
        if(money == 0) return 1;

        for(int i = index; i < coins.length; i++) {
            return minCoins(coins, money - coins[i], i + 1) + minCoins(coins,  money, i + 1);
        }
        return 0;
    }
}
