package com.tutorial;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{
                "cat",
                "dog",
                "ogd",
                "god",
                "atc"
        }).forEach((k, v) -> System.out.println(k + " -> " + Arrays.toString(v.toArray())));
    }

    public Map<String, List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        //O(n + n)
        for (String s : arr) { // O(n)
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr); // O(nlog(m))
            String a = String.valueOf(sArr);
            List<String> l = map.getOrDefault(a, new ArrayList<>());
            l.add(s);
            map.put(a, l);
        }

        System.out.println((5 & 1 + 7 & 1) % 2);

        return map;
    }

    public int addTwoNums(int a, int b) {
        int carry = 0;
        int res = 0;
        while(a > 0 && b > 0) {
            int sum = (a & 1 + b & 1) + carry;
            res = 2 * res + sum % 2;
            carry = sum / 2;
            a >>= 1;
            b >>= 1;
        }

        return res;
    }
}
