package algoexpert.M24_NumberOfWaysTOTraverseGraph;


import org.junit.Assert;
import org.junit.Test;

/**
 * Time complexity: O(n+m)
 * Space: O(n+m)
 */
public class Ex2 {
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i == 0 || j == 0){
                    matrix[i][j] = 1;
                }
            }
        }

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                matrix[row][col] = matrix[row -1 ][col] + matrix[row][col -1];
            }
        }
        return matrix[height-1][width -1];

    }

    @Test
    public void TestCase1() {
        Assert.assertEquals(10,numberOfWaysToTraverseGraph(4,3));
    }
}
