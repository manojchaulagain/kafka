package com.tutorial;

import java.util.Arrays;

public class RearrangePosNeg {

    public static void main(String[] args) {
        int[] arr = new int[]{
                12, 11, -13, -5, 6, -7, 5, -3, -6
        };
        System.out.println(Arrays.toString(arr));
        new RearrangePosNeg().rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void rearrange(int[] arr) {
        for(int i = 0, j = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

    }
}
