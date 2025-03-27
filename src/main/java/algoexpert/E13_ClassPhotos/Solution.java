package algoexpert.E13_ClassPhotos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static boolean classPhotos(List<Integer> redShirtHeights, List<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int color = 0;
        boolean result = true;
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (redShirtHeights.get(i) > blueShirtHeights.get(i) && color != 1) {
                color = -1;
            } else if (redShirtHeights.get(i) < blueShirtHeights.get(i) && color != -1) {
                color = 1;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> redShirtHeights = Arrays.asList(5, 6, 7, 2, 3, 1, 2, 3); // 1,2,4,5,6,9
        List<Integer> blueShirtHeights = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);// 1,3,4,5,8,9
        System.out.println(classPhotos(redShirtHeights, blueShirtHeights));
    }
}



