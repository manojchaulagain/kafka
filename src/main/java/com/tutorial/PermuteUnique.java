package com.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermuteUnique {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public static void permute(int[] nums, int index, List<Integer> cur, List<List<Integer>> list) {
        if(nums.length == index) {
            list.add(new ArrayList<>(cur));
        }
        for(int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            swap(nums, i, index);
            permute(nums, index + 1, cur, list);

            swap(nums, index, i);
            cur.remove(cur.size() - 1);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            if(map.containsKey(n)) {
                int c = map.get(n) + 1;
                map.put(n, c);
            } else {
                map.put(n, 1);
            }
        }

        bt(list, cur, nums.length, map);
        return list;
    }

    private static void bt(List<List<Integer>> list, List<Integer> cur, int size, Map<Integer, Integer> map) {

        if(cur.size() == size) {
            list.add(new ArrayList<>(cur));
            return;
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if(count == 0) {
                continue;
            }

            cur.add(num);
            map.put(num, count - 1);
            bt(list, cur, size, map);

            cur.remove(cur.size() -1);
            map.put(num, count);

        }

    }
}
