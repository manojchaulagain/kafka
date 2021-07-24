package com.tutorial;

public class FindWordGrid {

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String word = "ABCESEEDASFE";

        System.out.println(containsWord(grid, word));
    }

    private static boolean containsWord(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                boolean[][] visited = new boolean[R][C];
                if (board[r][c] == word.charAt(0) && dfs(r, c, board, R, C, visited, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int r, int c, char[][] grid, int R, int C, boolean[][] visited, String word, int index) {
        if (word.length() == index) return true;

        if (r < 0 || c < 0 || r >= R || c >= C || grid[r][c] != word.charAt(index) || visited[r][c]) {
            return false;
        }

        //check left
        visited[r][c] = true;

        boolean result = dfs(r, c - 1, grid, R, C, visited, word, index + 1)
                || dfs(r, c + 1, grid, R, C, visited, word, index + 1)
                || dfs(r - 1, c, grid, R, C, visited, word, index + 1)
                || dfs(r + 1, c, grid, R, C, visited, word, index + 1);

        visited[r][c] = false;
        return result;

    }
}
