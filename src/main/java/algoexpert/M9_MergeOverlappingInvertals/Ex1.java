package algoexpert.M9_MergeOverlappingInvertals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1 {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for (int i = 0; i < intervals.length; i++){
            int[] nextInterval = intervals[i];

            if(currentInterval[1] >= nextInterval[0] ){
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }else{
                result.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = mergeOverlappingIntervals(new int[][] {
                {1, 2},
                {2, 3},
                {4, 8},
                {4, 5},
                {4, 7}
        });

        Arrays.stream(result).forEach(e -> Arrays.stream(e).forEach(System.out::println));

    }
}
