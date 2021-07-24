package com.tutorial;

public class MaximumDifference {

    public static void main(String[] args) {
        int[] arr = { 2, 7, 9, 5, 1, 3, 5 };

        int max_so_far = Integer.MIN_VALUE;
        int min_so_far = Integer.MAX_VALUE;

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > max_so_far) {
                max_so_far = arr[i];
                min_so_far = arr[i];
            } else {
                max_so_far = Math.max(arr[i], max_so_far);
                min_so_far = Math.min(arr[i], min_so_far);
            }
            System.out.println(max_so_far - min_so_far);
        }
    }
}
