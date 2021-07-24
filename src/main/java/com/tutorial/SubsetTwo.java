package com.tutorial;

import java.util.*;

public class SubsetTwo {

    public static void main(String[] args) {
        List<List<Integer>> sets = new ArrayList<>();
        subsetsWithDup(new int[]{0}, 0, new ArrayList<>(), sets, false);
        for (List<Integer> nums : sets) {
            System.out.println(Arrays.toString(nums.toArray()));

        }
    }

    private static void subsetsWithDup(int[] nums, int index, List<Integer> cur, List<List<Integer>> sets, boolean prev) {
        if(index == nums.length) {
            sets.add(new ArrayList<>(cur));
            return;
        }

        subsetsWithDup(nums, index + 1, cur, sets, false);
        if (index >= 1 && nums[index] == nums[index - 1] && !prev)
            return;

        cur.add(nums[index]);
        subsetsWithDup(nums, index + 1, cur, sets, true);
        cur.remove(cur.size() - 1);
    }
}
