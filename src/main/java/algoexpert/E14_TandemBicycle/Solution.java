package algoexpert.E14_TandemBicycle;

import java.util.Arrays;
import java.util.Collections;

class Program {
    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
    ) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (fastest) {
            reverse(blueShirtSpeeds);
        }
        int sum = 0;
        for(int i = 0; i < redShirtSpeeds.length; i++) {
            sum += Math.max(blueShirtSpeeds[i], redShirtSpeeds[i]);
        }

        return sum;
    }

    public void reverse(int[] array) {
        int l = 0;
        int r = array.length -1;

        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            l++;
            r--;
        }
    }
}
