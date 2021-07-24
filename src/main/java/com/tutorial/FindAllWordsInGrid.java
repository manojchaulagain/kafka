package com.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllWordsInGrid {

    static class GridLocation {
        int row;
        int col;

        GridLocation(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static Map<Character, List<GridLocation>> map = new HashMap<>();

    public static void main(String[] args) {
        char[][] grid = {
                {'D', 'B', 'C', 'S'},
                {'N', 'Y', 'A', 'O'},
                {'A', 'B', 'O', 'N'},
                {'S', 'B', 'D', 'Y'}
        };

        String[] words = {"BOY", "CANDY", "SONY", "BAND"};
        generateHashMap(grid);
        checkForWords(grid, words);
    }

    private static Map<String, Boolean> checkForWords(char[][] grid, String[] words) {
        Map<String, Boolean> status = new HashMap<>();
        for (String word : words) {
            status.put(word, containsWord(grid, word));
        }
        return status;
    }

    private static Boolean containsWord(char[][] grid, String word) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        return true;
    }

    private static void generateHashMap(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                List<GridLocation> gridLocations;
                if (map.containsKey(grid[i][j])) {
                    gridLocations = map.get(grid[i][j]);
                } else {
                    gridLocations = new ArrayList<>();
                }
                gridLocations.add(new GridLocation(i, j));
                map.put(grid[i][j], gridLocations);
            }
        }
    }
}
