package algoexpert.E10_MinimumWaitingTime;

import java.util.Arrays;

public class Ex1 {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int waitingTime = 0;
        int result =0;
        for(int i = 1; i < queries.length ; i++) {
            waitingTime = waitingTime + queries[i-1];
            result += waitingTime;
        }
        return result;
    }
}
