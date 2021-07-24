package com.tutorial;

public class TrappingRainWater {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 2 };
        int n = arr.length;

        System.out.println("Maximum water that "
                + "can be accumulated is "
                + new TrappingRainWater().trapRainWater(arr));
    }

    public int trapRainWater(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int lmax = arr[l];
        int rmax = arr[r];
        int res = 0;
        while (l <= r) {
            if (arr[l] < arr[r]) {
                if (arr[l] > lmax) {
                    lmax = arr[l];
                } else {
                    res += lmax - arr[l];
                }
                l++;
            } else {
                if (arr[r] > rmax) {
                    rmax = arr[r];
                } else {
                    res += rmax - arr[r];
                }
                r--;
            }
        }
        return res;
    }
}
