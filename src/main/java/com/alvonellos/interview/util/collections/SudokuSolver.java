package com.alvonellos.interview.util.collections;

public class SudokuSolver {
    public static void solveSudoku(char[][] puzzleBoard) {
        assert(puzzleBoard.length == 9 && puzzleBoard[0].length == 9);
        helper(puzzleBoard);
    }
    private static boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) { // row
            for (int j = 0; j < 9; j++) { // col
                if (board[i][j] != '.') {
                    continue; // skip filled cells
                }

                for (char k = '1'; k <= '9'; k++) { // try 1-9
                    if (isValid(board, i, j, k)) { // check if valid
                        board[i][j] = k; // fill in the cell
                        if (helper(board)) { // recursively solve the rest
                            return true;
                        }
                        board[i][j] = '.'; // reset the cell
                    }
                }
                return false; // if no valid number is found, return false
            }
        }

        return true; //return true if all cells are checked
    }

    /**
     * Check if the number is valid in the current row, column and 3x3 sub-box
     * @param board the board to check against
     * @param row the row to check
     * @param col the column to check
     * @param c the character to check
     * @return
     */
    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) { //loop through each pos 0 - 9
            if (board[i][col] != '.' && board[i][col] == c) { //check if the number is already in the column
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == c) {
                return false; // check if the number is already in the row
            }

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false; // check if the number is already in the 3x3 sub-box
            }
        }
        return true;
    }
}
