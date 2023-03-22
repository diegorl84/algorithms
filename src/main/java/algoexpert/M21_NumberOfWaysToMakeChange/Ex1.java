package algoexpert.M21_NumberOfWaysToMakeChange;


/**
 * Time complexity: O(nd) number of denominations
 * Space complexity: O(n) n equal to target
 */
public class Ex1 {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int denom : denoms){
            for(int amount = 1; amount < n + 1; amount++){
                if(denom <= amount){
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(15, new int[]{2,3}));
        /**
         * 2x6 3x1
         * 2x3 3x3
         * 3x5
         */


    }
}
