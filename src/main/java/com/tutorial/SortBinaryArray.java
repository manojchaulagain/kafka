package com.tutorial;

import java.util.Arrays;

public class SortBinaryArray {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 1, 0};

        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[j] > arr[i]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }
}
