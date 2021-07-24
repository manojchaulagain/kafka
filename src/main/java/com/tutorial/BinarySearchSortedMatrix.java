package com.tutorial;

import java.util.Arrays;

public class BinarySearchSortedMatrix {


    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        new BinarySearchSortedMatrix().findTarget(m, 20);
    }

    public void findTarget(int[][] m, int target) {
        int s = m.length;
        for (int i = 0; i < s; i++) {
            if (target >= m[i][0] && target <= m[i][m[i].length - 1]) {
                int x = Arrays.binarySearch(m[i], target);
                if (x > -1)
                    System.out.println("Found at point: " + i + " " + x);
                else
                    System.out.println("-1");
                return;
            }
        }
        System.out.println("-1");

    }
}
