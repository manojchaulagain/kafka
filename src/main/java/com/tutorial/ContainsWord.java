package com.tutorial;

import scala.Char;

public class ContainsWord {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCEFSADEESE";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, r, c, visited, 0)) {
                        return true;
                    }
                }
            }

        }
        return false;

    }

    private static boolean dfs(char[][] board, String word, int r, int c, boolean[][] visited, int index) {
        if (index >= word.length() - 1) return true;
        if (!checkBoundary(board, r, c) || board[r][c] != word.charAt(index) || visited[r][c]) return false;


        visited[r][c] = true;
        boolean top = dfs(board, word, r - 1, c, visited, index + 1);
        boolean right = dfs(board, word, r, c + 1, visited, index + 1);
        boolean bottom = dfs(board, word, r + 1, c, visited, index + 1);
        boolean left = dfs(board, word, r, c - 1, visited, index + 1);
        return top || left || bottom || right;

    }

    private static boolean checkBoundary(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

}
