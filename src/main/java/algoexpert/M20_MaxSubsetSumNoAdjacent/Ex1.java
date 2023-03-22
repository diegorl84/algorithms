package algoexpert.M20_MaxSubsetSumNoAdjacent;

/**
 * O(n) time complexity
 */

public class Ex1 {
    public static int maxSubsetSumNoAdjacent(int[] array) {

        if(array.length == 0){
            return 0;
        }else if(array.length == 1){
            return array[0];
        }
        int current = 0;
        int first = array[0];
        int second = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            current = Math.max(first + array[i],  Math.max(second, array[i]));
            first = second;
            second = current;
        }
        return second > first ? second : first;
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{4, 3, 5, 200, 5, 3}));
    }
}