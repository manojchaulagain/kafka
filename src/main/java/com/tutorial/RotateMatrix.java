package com.tutorial;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateMatrix r = new RotateMatrix();
        r.print(arr);
        r.rotateMatrix(arr);
        System.out.println();
        r.print(arr);
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotateMatrix(int[][] arr) {
        for(int r = 0; r < (arr.length + 1) / 2; r++) {
            for(int c = 0; c < arr.length / 2; c++) {
                int temp = arr[r][c];

            }

        }

    }
}
