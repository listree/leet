package com.meta;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 1091. Shortest Path in Binary Matrix (Medium)
 * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
 * If there is no clear path, return -1.
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 * Runtime 37 ms Beats 8.64%
 * Memory 45.61 MB Beats 54.31%
 */
public class ShortestPathBinaryMatrix {
    public final static void main(String[] args) {
        Set<RC> visited = new HashSet<RC>();
        visited.add(new RC(0,0, 10));
        System.out.println(visited.contains(new RC(0,0, 10)));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        // BFS based on
        Queue<RCL> queue = new LinkedList<RCL>();
        queue.add(new RCL(0,0,1));
        Set<RC> visited = new HashSet<RC>();
        visited.add(new RC(0,0, n));
        RC[] directions = new RC[]{
                new RC(-1,0, n),
                new RC(1, 0, n),
                new RC(1,1, n),
                new RC(0,1, n),
                new RC(-1,1, n),
                new RC(1,-1, n),
                new RC(0,-1, n ),
                new RC(-1,-1, n),
        };

        while( !queue.isEmpty() ) {
            RCL rcl = queue.poll();
            if( rcl.r == n-1 && rcl.c == n-1)
                return rcl.l;

            for(int i = 0 ; i < 8; i++ ) {
                int newR = rcl.r + directions[i].r;
                int newC = rcl.c + directions[i].c;
                RC newRC = new RC(newR, newC, n);
                if( newR < 0 || newR >= n || newC < 0 || newC >= n ||
                        visited.contains(newRC) || grid[newR][newC] == 1 )
                    continue; // ignore
                visited.add(newRC);
                queue.add(new RCL(newR, newC, rcl.l + 1));
            }

        }

        return -1;
    }

    public static class RCL {
        public int r;
        public int c;
        public int l;
        RCL(int r, int c, int l) {
            this.r = r;
            this.c = c;
            this.l = l;
        }
    }

    public static class RC {
        public int r;
        public int c;
        public int n;
        RC(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }

        @Override
        public boolean equals(Object obj) {

            if( obj instanceof RC ){
                RC that = (RC) obj;
                return this.r == that.r && this.c == that.c;
            }
            return false;

        }
        @Override
        public int hashCode() {
            return r * n + c;
        }
    }

}
