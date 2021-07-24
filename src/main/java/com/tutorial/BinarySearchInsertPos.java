package com.tutorial;

public class BinarySearchInsertPos {

    public static void main(String[] args) {

//        int[] arr = new int[]{
//                1, 3, 5, 5, 5, 5, 5, 5, 5, 67, 123, 125
//        };
        int[] arr = new int[]{
                5, 5
        };
        System.out.println(new BinarySearchInsertPos().findInsertPosition(arr, 0, arr.length - 1, 5));
    }

    public int findInsertPosition(int[] arr, int l, int r, int target) {
        if (l > r) return l;
        int m = l + (r - l) / 2;
        if (target <= arr[m])
            return findInsertPosition(arr, l, m - 1, target);
        return findInsertPosition(arr, m + 1, r, target);
    }
}
