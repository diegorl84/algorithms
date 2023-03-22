package algoexpert.M30_RiverSize;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Time complexity: 2^(n+m)
 * Space: O(n+m) heap memory
 */

public class Program {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> rivers = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] ==1){
                    int river = getLength(row,col,matrix);
                    rivers.add(river);
                }
            }

        }
        return rivers;
    }

    public static int getLength(int row, int col, int[][] matrix) {
        int size = 1;
       matrix[row][col] = 0;
       if(col + 1 < matrix[row].length && matrix[row][col+1] == 1){
           size = size + getLength(row, col +1, matrix);
       }
        if(row + 1 < matrix.length && matrix[row+1][col] == 1){
            size = size + getLength(row+1, col, matrix);
        }
        return size;
    }


    @Test
    public void TestCase1() {
        int[][] input = {
                {1, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 1}
  };
        int[] expected = {1, 2, 2, 2, 5};
        List<Integer> output = Program.riverSizes(input);
        Collections.sort(output);
       Assert.assertTrue(compare(output, expected));
    }

    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
