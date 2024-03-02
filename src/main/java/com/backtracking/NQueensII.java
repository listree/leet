package com.backtracking;


import java.util.AbstractMap;

/**
 * https://leetcode.com/problems/n-queens-ii/description
 * 52. N-Queens II
 * Hard
 * Topics
 * Companies
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class NQueensII {


    public static void main(String[] args) {
        AbstractMap.SimpleEntry<Integer, String> entry
                = new AbstractMap.SimpleEntry<>(1, "one");


        NQueensII nQueensII = new NQueensII();
        nQueensII.totalNQueens(4); // 2
    }

    public int totalNQueens(int n) {

        return 0;

    }

}
