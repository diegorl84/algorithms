package algoexpert.M33_CycleIngraph;


import org.junit.Assert;
import org.junit.Test;


public class Ex2 {

    public int[][] removeIslands(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            if(matrix[0][col] == 1){
                convert(matrix, 0, col );
            }
        }
        System.out.println("first horitzontal");
        for (int col = 0; col < matrix[0].length; col++) {
            if(matrix[matrix.length -1 ][col] == 1){
                convert(matrix, matrix.length -1 , col );
            }
        }
        System.out.println("Last horitzontal");
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][0] == 1){
                convert(matrix, row, 0 );
            }
        }
        System.out.println("first ver");
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row][matrix[0].length -1] == 1){
                convert(matrix, row , matrix[0].length -1);
            }
        }
        System.out.println("last ver");

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == -1){
                    matrix[row][col] = 1;
                }else if(matrix[row][col] == 1){
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }

    private void convert(int[][] matrix, int row, int col){
        matrix[row][col] = -1;
        if(col + 1 < matrix[row].length && matrix[row][col + 1] == 1 ){
            convert(matrix, row, col +1);
        }
        if(col - 1 >= 0 && matrix[row][col - 1] == 1){
            convert(matrix, row, col -1);
        }

        if(row + 1 < matrix.length && matrix[row + 1][col] == 1 ){
            convert(matrix, row + 1, col);
        }
        if(row - 1 >= 0 && matrix[row - 1][col] == 1){
            convert(matrix, row -1 , col);
        }
    }

    @Test
    public void TestCase1() {
        int[][] input =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1},
                        {0, 0, 1, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 1, 1, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        int[][] expected =
                new int[][] {
                        {1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 0, 0, 1, 0},
                        {1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1},
                };
        int[][] actual = new Ex2().removeIslands(input);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                Assert.assertTrue(actual[i][j] == expected[i][j]);
            }
        }
    }
}
