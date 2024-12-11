package algoexpert.E5_NonConstructibleChange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Time complexity: O(n log n) for sort
     * Space complexity: O(1)
     */
    public static int nonConstructibleChange(int[] coins) {
        int minChange = 0;
        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > minChange + 1) {
                return minChange + 1;
            }
            minChange += coin;
        }
        return minChange + 1;
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1, 1, 1, 1, 1};
        System.out.println(nonConstructibleChange(coins));

    }
}
