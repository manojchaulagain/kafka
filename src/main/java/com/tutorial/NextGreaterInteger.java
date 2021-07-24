package com.tutorial;

import java.util.Arrays;

public class NextGreaterInteger {

    public static void main(String[] args) {
        new NextGreaterInteger().nextGreater(new int[] {
                5, 4, 3, 1, 2
        });
    }

    public void nextGreater(int[] arr) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);
        int max = arr[arr.length - 1];
        int index = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(max > arr[i]) {
                cache[i] = index;
            }

            if(arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(Arrays.toString(cache));
        for(int i = 0; i < cache.length; i++) {
            if(cache[i] >= 0) {
                int temp = arr[i];
                arr[i] = arr[cache[i]];
                arr[cache[i]] = temp;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
