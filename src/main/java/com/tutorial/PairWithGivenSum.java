package com.tutorial;

import java.util.*;

public class PairWithGivenSum {

    static class Pair {
        int item1;
        int item2;

        Pair(int item1, int item2) {
            this.item1 = item1;
            this.item2 = item2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;
        findAllPairsWithGivenSum(arr, target).forEach(p -> System.out.println("(" + p.item1 + ", " + p.item2 + ")"));
    }

    private static List<Pair> findAllPairsWithGivenSum(int[] arr, int target) {
        List<Pair> pairs = new ArrayList<>();
        Set<Integer> map = new HashSet<>();
        for (int num : arr) {
            if (map.contains(target - num)) {
                pairs.add(new Pair(num, target - num));
            }
            map.add(num);
        }
        return pairs;
    }
}
