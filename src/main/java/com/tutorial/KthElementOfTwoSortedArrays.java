package com.tutorial;

public class KthElementOfTwoSortedArrays {
    public static void main(String[] args) {
        int a = new KthElementOfTwoSortedArrays().kthElement(
                new int[]{100, 112, 256, 349, 770},
                new int[]{72, 86, 113, 119, 265, 445, 892},
                4
        );

        System.out.println(a);
    }

    public int kthElement(int[] arr1, int[] arr2, int k) {
        int i = 0;
        int j = 0;
        int l = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                j += 1;
                l += 1;
                if (l == k) return arr2[j - 1];
            } else {
                i += 1;
                l += 1;
                if (l == k) return arr1[i - 1];
            }
        }
        return -1;
    }
}
