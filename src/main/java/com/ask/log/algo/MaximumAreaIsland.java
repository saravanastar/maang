package com.ask.log.algo;

public class MaximumAreaIsland {
    public static void main(String[] args) {
        MaximumAreaIsland maximumAreaIsland = new MaximumAreaIsland();
        int[][] input = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] input1 = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int[][] input2 = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int[][] input3 = new int[][]{{1}};
        System.out.println(maximumAreaIsland.maxAreaOfIsland(input3));

    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (!visited[row][column] && grid[row][column] == 1) {
                    int islandSize = consecOnes(grid, row, column, visited);
                    result = Math.max(islandSize, result);
                }
            }
        }
        return result;
    }

    private int consecOnes(int[][] grid, int row, int column, boolean[][] visited) {
        if (row < 0 || column < 0 || row > grid.length-1 || column > grid[0].length-1 || grid[row][column] == 0 || visited[row][column]) {
            return 0;
        }
        visited[row][column] = true;
        return 1 + consecOnes(grid, row + 1, column, visited) + consecOnes(grid, row, column + 1, visited) + consecOnes(grid, row-1, column , visited) +
                consecOnes(grid, row, column-1 , visited);
    }
}
