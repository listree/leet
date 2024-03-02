package com.backtracking;

/**
 * https://leetcode.com/problems/sudoku-solver/
 * 37. Sudoku Solver
 * Hard
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        dfs(board, 0); // start scanning for 1th row, 1th column
    }

    private boolean dfs(char[][] board, int s) {
        if (s == 81)
            return true;

        final int i = s / 9;
        final int j = s % 9;

        if (board[i][j] != '.')
            return dfs(board, s + 1);

        for (char c = '1'; c <= '9'; ++c) {
            if (isValid(board, i, j, c)) {
                board[i][j] = c;
                if (dfs(board, s + 1))
                    return true;
                board[i][j] = '.'; // !!! revert back, check next digit !!!
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int cubeRow = 3 * (row / 3);
        int cubeCol = 3 * (col / 3);
        for (int i = 0; i < 9; ++i) {
            if (board[i][col] == c ||
                board[row][i] == c ||
                board[cubeRow + i / 3][cubeCol + i % 3] == c
            )
            return false;
        }
        return true;
    }

}
