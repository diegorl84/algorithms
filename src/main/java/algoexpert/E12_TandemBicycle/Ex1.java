package algoexpert.E12_TandemBicycle;

import java.util.Arrays;

/**
 * Time: O( n log(n) ) for sorting
 */
public class Ex1 {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if(fastest){
           reverse(blueShirtSpeeds);
        }
        int sum = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (redShirtSpeeds[i] > blueShirtSpeeds[i]) {
                sum += redShirtSpeeds[i];
            } else {
                sum += blueShirtSpeeds[i];
            }
        }

        return sum;
    }

    public void reverse(int[] array){
        int start = 0;
        int end = array.length -1;
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
