package algoexpert.E11_ClassPhotos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Time complexity: Ordering O(n log n), for comparing O(2n) --> O(nlog(n))
 * Space complexity: O(1)
 */
public class Ex1 {
    public boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {

        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
            for (int i = 0; i < redShirtHeights.size(); i++) {
                if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < blueShirtHeights.size(); i++) {
                if (blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }

        // Write your code here.
        return true;
    }

    public static void main(String[] args) {
        int[] red = new int[]{5,5,4,9,2};
        Arrays.sort(red);
        Arrays.stream(red).forEach(System.out::println);
    }
}
