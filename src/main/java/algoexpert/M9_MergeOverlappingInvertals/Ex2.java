package algoexpert.M9_MergeOverlappingInvertals;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex2 {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int pos = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (result.get(pos)[0] <= intervals[i][0] &&
                    intervals[i][0] <= result.get(pos)[1]) {
                result.get(pos)[1] = Math.max(result.get(pos)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
                pos++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = mergeOverlappingIntervals(new int[][] {
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        });

        Arrays.stream(result).forEach(e -> Arrays.stream(e).forEach(System.out::println));

    }
}
