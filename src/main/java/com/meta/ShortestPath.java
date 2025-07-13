package com.meta;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 1091. Shortest Path in Binary Matrix (Medium)
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 *
 */
public class ShortestPath {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] != 0 ) return -1;
        if(grid[m-1][n-1] != 0 ) return -1;

        return bfs(grid, 0, 0, m ,n );

    }

    // java.lang.StackOverflowError

    int bfs(int[][] grid, int i, int j, int m, int n) {
        if( i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0 )
            return -1;

        int x1 = bfs(grid, i-1, j-1, m, n);
        int x2 = bfs(grid, i, j-1, m, n);
        int x3 = bfs(grid, i+1, j-1, m, n);
        int x4 = bfs(grid, i-1, j, m, n);
        int x5 = bfs(grid, i+1, j, m, n);
        int x6 = bfs(grid, i-1, j+1, m, n);
        int x7 = bfs(grid, i, j+1, m, n);
        int x8 = bfs(grid, i+1, j+1, m, n);

        if( x1 == -1 && x2 == -1 && x3 == -3 && x4 == -1 && x5 == -1 && x6 == -1 && x7 == -3 && x8 == -1)
            return -1;

        int min = 0;
        if( x1 > -1)
            min = Math.min(min, x1);
        if( x2 > -1)
            min = Math.min(min, x2);
        if( x3 > -1)
            min = Math.min(min, x3);
        if( x4 > -1)
            min = Math.min(min, x4);
        if( x5 > -1)
            min = Math.min(min, x5);
        if( x6 > -1)
            min = Math.min(min, x6);
        if( x7 > -1)
            min = Math.min(min, x7);
        if( x8 > -1)
            min = Math.min(min, x8);

        return min;

    }

}
