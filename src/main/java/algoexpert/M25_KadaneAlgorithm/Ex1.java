package algoexpert.M25_KadaneAlgorithm;


import org.junit.Assert;
import org.junit.Test;

/**
 * Time complexity: 2^(n+m)
 * Space: O(n+m) heap memory
 */

public class Ex1 {
    public static int kadanesAlgorithm(int[] array) {
       int maxEndingHere = array[0];
       int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(num + maxEndingHere, num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    @Test
    public void TestCase1() {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        Assert.assertEquals(19,kadanesAlgorithm(input));
    }
}
