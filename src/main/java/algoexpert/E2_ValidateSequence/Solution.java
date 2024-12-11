package algoexpert.E2_ValidateSequence;

import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int arrayIdx = 0;
        int seqIdx = 0;

        while (arrayIdx < array.size() && seqIdx < sequence.size()){
            if(array.get(arrayIdx).equals(sequence.get(seqIdx))){
                seqIdx ++;
            }
            arrayIdx++;
        }
        return seqIdx == sequence.size();
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * This could throw an exception if Arrays.asList is used due to asList create a fixed-length
     */
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        for (Integer integer : array) {
            if (integer.equals(sequence.get(0))) {
                sequence.remove(0);
            }
            if (sequence.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = Arrays.asList(1, 6, -1, 10);
        System.out.println(isValidSubsequence(array, sequence));
    }
}
