package com.tutorial;

import java.util.*;

public class SubArrayWithZeroSum {

    static class Pair {
        int startIndex;
        int endIndex;

        Pair(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        findAllPairsWithGivenSum(arr).forEach(p -> System.out.println("(" + p.startIndex + ", " + p.endIndex + ")"));
    }

    private static List<Pair> findAllPairsWithGivenSum(int[] arr) {
        int sum = 0;
        List<Pair> pairs = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        insert(map, 0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int n : list) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, n + 1, i + 1)));
                    pairs.add(new Pair(n, i));
                }
            }
            insert(map, sum, i);
        }

        return pairs;
    }

    private static <K, V> void insert(Map<K, List<V>> map, K key, V val) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(val);
    }
}
