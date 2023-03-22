package algoexpert.M5_SpiralTraverse;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static List<Integer> spiralTraverse(int[][] array) {
        int startRow = 0;
        int endRow = array.length - 1;
        int startCol = 0;
        int endCol = array[0].length - 1;

        List<Integer> numbers = new ArrayList<>();

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                numbers.add(array[startRow][col]);
            }
            for (int row = startRow + 1; row <= endRow; row++) {
                numbers.add(array[row][endCol]);
            }
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                numbers.add(array[endRow][col]);
            }
            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                numbers.add(array[row][startCol]);
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;

        }

        return numbers;
    }
}
