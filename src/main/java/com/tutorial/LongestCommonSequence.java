package com.tutorial;

import javax.swing.plaf.IconUIResource;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSequence {

    public static void main(String[] args) {
        new LongestCommonSequence().longestSequence(new int[] {
                2,6,1,9,4,5,3
        });
    }

    public int longestSequence(int[] arr) {
        Set<Integer> ns = new HashSet<>();
        for (int i : arr) {
            ns.add(i);
        }
        int c = 0;
        for (int i : arr) {
            if (ns.contains(i - 1)) continue;
            int count = 0;
            while (ns.contains(i)) {
                i++;
                count++;
            }
            c = Math.max(c, count);
        }
        System.out.println(c);
        return c;
    }
}
