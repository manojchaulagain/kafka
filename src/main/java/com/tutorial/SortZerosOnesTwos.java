package com.tutorial;

import java.util.Arrays;

public class SortZerosOnesTwos {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0};

        int start = 0, mid = 0;
        int end = arr.length - 1;
        int pivot = 1;

        while (mid <= end) {
            if (arr[mid] < pivot) {
                swap(arr, start, mid);
                start++;
                mid++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, end);
                end--;
            } else {
                mid++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
