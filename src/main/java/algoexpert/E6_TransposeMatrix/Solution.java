package algoexpert.E6_TransposeMatrix;

import java.util.Arrays;

public class Solution {

    /**
     * Time complexity: O(rows), O(rows*cols)
     * Space complexity: O(1)
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int [][] transposeMatrix = new int[matrix[0].length][matrix.length];
        int rows = matrix[0].length - 1;
        int cols = matrix.length;

        for (int i = 0; i < rows; i++) {
            int[] row = new int[cols];
            transposeMatrix[i] = row;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }

        }
        return transposeMatrix;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println(transposeMatrix(matrix));

    }
}
