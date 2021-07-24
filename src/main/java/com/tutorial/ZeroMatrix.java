package com.tutorial;

import java.util.Arrays;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 5, 3, 4},
                {5, 0, 6, 7},
                {10, 2, 6, 8},
                {11, 22, 34, 41},
        };

        zeroMatrix(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void zeroMatrix(int[][] matrix) {
        int firstRow = matrix[0][0];

        // First Row
        for(int c = 0; c < matrix[0].length; c++) {
            if(matrix[0][c] == 0) {
                firstRow = 0;
                break;
            }
        }

        // First Col
        for(int r = 0; r < matrix.length; r++) {
            if(matrix[r][0] == 0) {
                matrix[0][0] = 0;
                break;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[r].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }
        if(firstRow == 0) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
