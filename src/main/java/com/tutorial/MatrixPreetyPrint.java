package com.tutorial;

import java.util.Arrays;

public class MatrixPreetyPrint {

    public static void main(String[] args) {
        MatrixPreetyPrint mp = new MatrixPreetyPrint();
        mp.print(mp.buildArrayAgain(9));
    }

    public void print(int[][] arr) {
        Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public int[][] buildArr(int a) {
        int l = a * 2 - 1;
        int[][] arr = new int[l][l];
        for (int i = 0; i < a; i++)
            fillOuter(arr, i);
        return arr;
    }

    public void fillOuter(int[][] arr, int li) {
        int i = arr.length - li;
        int j = arr[0].length - li;
        for (int r = li; r < i; r++) {
            int x = i - 1;
            for (int c = li; c < j; c++) {
                int y = j - 1;
                if (r == li || r == x || c == li || c == y) {
                    arr[r][c] = (i + li) / 2 - li + 1;
                }
            }
        }

    }

    public int[][] buildArrayAgain(int a) {
        int l = a * 2 - 1;
        int[][] arr = new int[l][l];
        int i = 0;
        while (i < a) {
            fillRow(arr, i, a - i, i);
            fillRow(arr, arr.length - 1 - i, a - i, i);
            fillCol(arr, i, a - i, i);
            fillCol(arr, arr.length - 1 - i, a - i, i);

            i++;
        }
        return arr;
    }

    public void fillRow(int[][] arr, int r, int v, int index) {
        for (int i = index; i < arr[r].length - index; i++) {
            arr[r][i] = v;
        }

    }

    public void fillCol(int[][] arr, int c, int v, int index) {
        for (int i = index; i < arr.length - index; i++) {
            arr[i][c] = v;
        }
    }

}
