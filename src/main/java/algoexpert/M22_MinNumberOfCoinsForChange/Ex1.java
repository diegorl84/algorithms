package algoexpert.M22_MinNumberOfCoinsForChange;


/**
 * Time complexity: O(nd) number of denominations
 * Space complexity: O(n) n equal to target
 */
public class Ex1 {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] ways = new int[n+1];
        for(int i= 0; i< ways.length;i++){
            ways[i] = Integer.MAX_VALUE;
        }
        ways[0] = 0;
        int toCompare = 0;
        for(int denom: denoms){
            for(int amount = 0; amount < ways.length ; amount++){
                if(denom <= amount){
                    toCompare = ways[amount - denom] == Integer.MAX_VALUE ? ways[amount -denom] :ways[amount - denom] + 1;
                    ways[amount] = Math.min(ways[amount], toCompare );
                }
            }
        }
        return ways[n] == Integer.MAX_VALUE ? -1 : ways[n];
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(7, new int[]{1,5,10}));
        /**
         * 2x6 3x1
         * 2x3 3x3
         * 3x5
         */


    }
}
