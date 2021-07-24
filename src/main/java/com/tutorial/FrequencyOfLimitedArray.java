package com.tutorial;

import java.util.Arrays;

public class FrequencyOfLimitedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 2, 3, 4, 6
        };
        new FrequencyOfLimitedArray().findFrequencies(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.println(i + 1 + " -> " + Math.abs(arr[i]));
        }
    }

    public void findFrequencies(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            if (arr[i] <= 0) {
                i++;
                continue;
            }
            int temp = arr[arr[i] - 1];
            if (temp > 0) {
                arr[i] = temp;
                arr[arr[i] - 1] = -1;
            } else {
                arr[arr[i] - 1] -= 1;
                arr[i] = 0;
                i++;
            }
        }

    }


}
