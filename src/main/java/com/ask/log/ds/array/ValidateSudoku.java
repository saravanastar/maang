package com.ask.log.ds.array;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidateSudoku {
    public static void main(String[] args) {
        char[][] input = new char[][]{{'.','.','5','.','.','.','.','.','.'},
                                      {'.','.','.','8','.','.','.','3','.'},
                                      {'.','5','.','.','2','.','.','.','.'},
                                      {'.','.','.','.','.','.','.','.','.'},
                                      {'.','.','.','.','.','.','.','.','9'},
                                      {'.','.','.','.','.','.','4','.','.'},
                                      {'.','.','.','.','.','.','.','.','7'},
                                      {'.','1','.','.','.','.','.','.','.'},
                                      {'2','4','.','.','.','.','9','.','.'}};

        ValidateSudoku validateSudoku = new ValidateSudoku();
        System.out.println(validateSudoku.isValidSudoku(input));


    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!isValidGrid(board, i ,j) || !isValidRow(board, i ,j) || !isValidColumn(board, i ,j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidRow(char[][] board, int row, int column) {
        char charToCheck = board[row][column];
        int currentColumn = 0;
        while (currentColumn < board[row].length) {
            if (currentColumn == column || board[row][currentColumn] == '.') {
                currentColumn++;
                continue;
            }
            if (board[row][currentColumn] == charToCheck) {
                return false;
            }
            currentColumn++;
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int row, int column) {
        char charToCheck = board[row][column];
        int currentRow = 0;
        while (currentRow < board.length) {
            if (currentRow == row || board[currentRow][column] == '.') {
                currentRow++;
                continue;
            }
            if (board[currentRow][column] == charToCheck) {
                return false;
            }
            currentRow++;
        }
        return true;
    }

    private boolean isValidGrid(char[][] board, int row, int column) {
        int[] lookup = new int[9];
        int gridRowStart = (row/3)*3;
        int gridColumnStart = (column/3)*3;
        for (int i = gridRowStart; i < gridRowStart+3; i++) {
            for (int j = gridColumnStart; j < gridColumnStart+3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = Integer.parseInt(String.valueOf(board[i][j]));
                if (lookup[value] == 1) {
                    return false;
                }
                lookup[value] = 1;
            }
        }
        return true;

        }
    
}
