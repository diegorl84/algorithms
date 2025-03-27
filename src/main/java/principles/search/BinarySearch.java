package principles.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity : O(Log n) Auxiliary Space : The above implementation of Binary Search is
 * recursive and requires O(Log n) space. With iterative Binary Search, we need only O(1) space.
 * Applications of Exponential Search:
 *
 * <p>Exponential Binary Search is particularly useful for unbounded searches, where size of array
 * is infinite. Please refer Unbounded Binary Search for an example. It works better than Binary
 * Search for bounded arrays, and also when the element to be searched is closer to the first
 * element.
 */
public class BinarySearch {

    public static int search(int arr[], int target) {
        int l = 0;
        int r = arr.length - 1;
        return search(arr, l, r, target);
    }

    public static int search(int[] arr, int l, int r, int target) {

        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                return search(arr, l, mid - 1, target);
            } else {
                return search(arr, mid + 1, r, target);
            }
        }

        return -1;
    }

    static int binarySearch(List<Integer> sortedList, int target) {
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) == target) {
                return mid;
            } else if (sortedList.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Integer> list1b = Arrays.asList();
        int res1b = binarySearch(list1b, 5);
        List<Integer> list2b = Arrays.asList(1, 2, 3, 4, 5);
        int res2b = binarySearch(list2b, 3);
        List<Integer> list3b = Arrays.asList(10, 20, 30, 40, 50);
        int res3b = binarySearch(list3b, 25);
        List<Integer> list4b = Arrays.asList(2, 4, 6, 8, 10);
        int res4b = binarySearch(list4b, 10);
        List<Integer> list5b = Arrays.asList(1, 3, 5, 7, 9);
        int res5b = binarySearch(list5b, 1);
        int res6b = binarySearch(list5b, 9);
        List<Integer> list7b = Arrays.asList(1, 2, 3, 4, 5);
        int res7b = binarySearch(list7b, 6);

        System.out.println(res1b);
        System.out.println(res2b);
        System.out.println(res3b);
        System.out.println(res4b);
        System.out.println(res5b);
        System.out.println(res6b);
        System.out.println(res7b);
    }



//    @Test
//    public void test() {
//        int arr[] = {2, 3, 4, 10, 40, 50, 100, 101, 105, 107, 200, 1000, 1002, 1003, 1010, 1020, 1030};
//        System.out.println(search(arr, 1002));
//    }
}
