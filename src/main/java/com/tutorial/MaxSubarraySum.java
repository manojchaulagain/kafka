package com.tutorial;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 4, 20, 3, 10, 5
        };
        new MaxSubarraySum().maxSubArraySum(arr, 10);
    }


    public void print(Map<Integer, Integer> m) {
        m.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public void maxSubArraySum(int[] arr, int a) {
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for (int i : arr) {
            curSum += i;
            map.put(curSum, 1 + map.getOrDefault(curSum, 0));
            System.out.println("-------------------------");
            System.out.println(curSum);
            print(map);
            System.out.println("-------------------------");
        }
    }
}
