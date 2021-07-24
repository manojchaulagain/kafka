package com.tutorial;

import java.util.Arrays;

public class ArraysToHighAndLow {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int i = 1, j = 2;

        while(i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 2;
            j += 2;
        }

        System.out.println(Arrays.toString(arr));
    }

}
