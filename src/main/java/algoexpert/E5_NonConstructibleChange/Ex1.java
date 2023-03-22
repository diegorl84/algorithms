package algoexpert.E5_NonConstructibleChange;

import java.util.Arrays;

/**
 * {1,2,3,5,7,22}
 */
public class Ex1 {
    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChange = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > currentChange +1){
                return currentChange +1;
            }else{
                currentChange += coins[i];
            }
        }
        return currentChange + 1;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(nonConstructibleChange(coins));

    }
}
