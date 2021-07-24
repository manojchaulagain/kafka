package com.tutorial;

import java.util.Arrays;

public class SortWave {

    public static void main(String[] args) {
        int[] arr = new int[]{
                2, 4, 7, 8, 9, 10};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i = i + 2) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }
}
