package com.tutorial;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        bt(k, 0, 1, n, new ArrayList<>(), list);
        System.out.println(list.size());
        return list;
    }

    public static void bt(int k, int sum, int s, int n, List<Integer> l, List<List<Integer>> list) {
        if (list.size() > k || sum > n) {
            return;
        }
        if (list.size() == k && n == sum) {
            list.add(new ArrayList<>(l));
            return;
        }

        for (int i = s; i <= 9; i++) {
            sum += i;
            l.add(i);
            bt(k, sum, i + 1, n, l, list);
            sum -= i;
            l.remove(l.size() - 1);
        }
    }
}
