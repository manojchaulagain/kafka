package com.tutorial;

public class MinPlatforms {

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + new MinPlatforms().minPlatforms(arr, dep));
    }

    public int minPlatforms(int[] arr, int[] dep) {
        int count = 1;
        int minCount = 1;
        int i = 1;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else  {
                count--;
                j++;
            }
            minCount = Math.max(minCount, count);
        }
        return minCount;
    }
}
