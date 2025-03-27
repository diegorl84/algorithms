package algoexpert.E12_MinimumWaitingTime;

import java.util.Arrays;

public class Solution {
    /**
     * Time complexity: O(nlog n)
     * Space complexity: O(v)
     */
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWaitingTime = 0;
        int current = queries[0];
        for (int i = 1; i <= queries.length - 1; i++) {
            totalWaitingTime = totalWaitingTime + current;
            current += queries[i];
        }
        return totalWaitingTime;
    }

    public static int minimumWaitingTime_2(int[] queries) {
        Arrays.sort(queries);
        int total = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int qL = queries.length - (i + 1);
            total += duration * qL;

        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(minimumWaitingTime_2(new int[]{3, 2, 1, 2, 6}));
    }
}
