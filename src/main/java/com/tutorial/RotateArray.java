package com.tutorial;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 4, 5
        };
        System.out.println(Arrays.toString(arr));
        new RotateArray().rotateArray(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    public void rotateArray(int[] arr, int d) {
        for(int i = 0; i < d; i++) {
            int j = 0;
            int t = arr[j];
            while(j < arr.length - 1) {
                arr[j] = arr[j + 1];
                j++;
            }
            arr[j] = t;
        }
    }
}


