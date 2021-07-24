package com.tutorial;

import java.util.Arrays;

public class TestCache {

    public static void main(String[] args) {
        new TestCache().findNextMin(new int[] {
                5, 3, 1
        });
    }
    public void findNextMin(int[] arr) {
        int[] cache = new int[arr.length];
        Arrays.fill(cache, -1);
        int index = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[index] < arr[i]) {
                cache[i] = index;
                index = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(cache));
    }
}
