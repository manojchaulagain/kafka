package com.tutorial;

public class FindMaxInArray {

    public static void main(String[] args) {
        System.out.println(new FindMaxInArray().findMax(new int[]{
                1, 2, 3, 8, 7, 6
        }));
    }

    public int findMax(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (l == r - 1 && arr[l] >= arr[r]) return arr[l];

            if (l == r - 1 && arr[l] < arr[r]) return arr[r];

            if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1])
                return arr[m];

            if (arr[m] > arr[m + 1] && arr[m] < arr[m - 1]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return arr[l];
    }
}
