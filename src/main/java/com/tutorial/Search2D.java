package com.tutorial;

public class Search2D {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        };
        int[][] matrix = {{1}};
        System.out.println(new Search2D().searchMatrix(matrix, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;
        while (t <= b) {
            int mid = t + (b - t) / 2;

            if (matrix[mid][0] > target) {
                b = mid - 1;
            } else if (matrix[mid][matrix[mid].length - 1] < target) {
                t = mid + 1;
            } else {
                t = mid;
                break;
            }
        }
        if (t > b) return false;

        int l = 0;
        int r = matrix[t].length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[t][mid] > target) {
                r = mid - 1;
            } else if (matrix[t][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
