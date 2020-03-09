package com.home.nahusha.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) ||
                        !seen.add(num + " in col " + j) || 
                        !seen.add(num + " in block " + i/3 + "-" + j/3))
                        return false; 
                }
            }
        }
        seen.forEach(s -> System.out.println(s));
        return true;
    }
    public static void main(String[] args) {
		SudokuSolver ss = new SudokuSolver();
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(ss.isValidSudoku(board));
	}
}