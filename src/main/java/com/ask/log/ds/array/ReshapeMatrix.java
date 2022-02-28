package com.ask.log.ds.array;

/**
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 * Example 2:
 *
 *
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4
 * Output: [[1,2],[3,4]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 */
public class ReshapeMatrix {

    public static void main(String[] args) {
        ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
       int[][] result = reshapeMatrix.matrixReshape(new int[][]{{1,2}, {3,4}}, 4 , 1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        int row = 0;
        int column = 0;

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {
                if (row < r) {
                    if(column < c) {
                        result[row][column] = mat[i][j];
                        column++;
                    } else {
                        row++;
                        column=0;
                        result[row][column] = mat[i][j];
                        column++;
                    }

                }
            }
        }
        return result;
    }
}
