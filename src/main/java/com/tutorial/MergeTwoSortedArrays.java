package com.tutorial;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] x = {1, 4, 7, 8, 10};
        int[] y = {2, 3, 9};

        int left = 0;
        int right = 0;
        while (left < x.length) {
            if (x[left] > y[right]) {
                swap(x, y, left, right);
                int index = right;
                for (int i = 0; i < y.length; i++) {
                    if (y[index] > y[i]) {
                        swap(y, index, i);
                        index++;
                    }
                }
            }
            left++;

        }

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int[] arr1, int[] arr2, int i1, int i2) {
        int temp = arr1[i1];
        arr1[i1] = arr2[i2];
        arr2[i2] = temp;
    }
}
