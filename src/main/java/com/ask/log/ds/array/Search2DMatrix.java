package com.ask.log.ds.array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Search2DMatrix {
    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1,1}}, 0));
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{1}}, 1));
        System.out.println(search2DMatrix.searchMatrix(new int[][]{{-9,-7,-7,-5,-3},{-1,0,1,3,3},{5,7,9,11,12},{13,14,15,16,18},{19,21,22,22,22}}, -4));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = identifyRow(matrix, target);
        return searchInRow(matrix[row], target, 0, matrix[row].length-1);
    }

    private boolean searchInRow(int[] matrix, int target, int left, int right) {
        if (matrix.length ==1) {
            return matrix[matrix.length-1] == target;
        }
        if (left < right) {
        if (left < 0 || right > matrix.length-1) {
            return false;
        }
        if (matrix[left] == target || matrix[right] == target) {
            return true;
        }

            int mid = (left + right) / 2;
            if (matrix[mid] == target) {
                return true;
            }
            if (target < matrix[mid]) {
                return searchInRow(matrix, target, left, mid-1);
            }
            return searchInRow(matrix, target, mid + 1, right);
        }
        return false;
    }

    private int identifyRow(int[][] matrix, int target) {
        for (int i = 1; i < matrix.length; i++) {
            if (target < matrix[i][0]) {
                return i - 1;
            }
        }
        return matrix.length - 1;
    }
}
