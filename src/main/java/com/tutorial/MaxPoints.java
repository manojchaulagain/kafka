package com.tutorial;

public class MaxPoints {

    public int findMaxPoints(int[] arr, int k) {
        int maxSum = 0;
        for(int i = arr.length - 1; i > arr.length - 1 - k; i--) {
            maxSum += arr[i];
        }


        System.out.println(arr.length - 1+ k);
        for(int i = arr.length- 1 - k + 1, j = 0; i < arr.length; i++, j++) {
            maxSum = Math.max(maxSum, maxSum - arr[i] + arr[j]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPoints().findMaxPoints(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}
