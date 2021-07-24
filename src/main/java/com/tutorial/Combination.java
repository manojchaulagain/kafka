package com.tutorial;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        combine(5, 2);

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        combine(new ArrayList<>(), 1, k, n, l);
        System.out.println(l.size());
        return l;

    }

    public static void combine(List<Integer> cur, int c, int k, int n, List<List<Integer>> list) {
        if (cur.size() == k) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i = c; i <= n; i++){
            cur.add(i);
            combine(cur, i + 1, k, n, list);
            cur.remove(cur.size() - 1);
        }
    }
}
