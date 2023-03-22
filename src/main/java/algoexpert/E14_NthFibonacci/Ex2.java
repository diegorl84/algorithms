package algoexpert.E14_NthFibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * Use of memoization or caching. Two call (n-1) and (n-2) could start calling the same getNthFib. With caching
 * the value is saved in a Map and is call if exist.
 * Time complexity: O(n)
 * Space complexity : O(n)
 */
public class Ex2 {

    public static int getNthFib(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        return getNthFibCaching(n, cache);
    }

    public static int getNthFibCaching(int n, Map<Integer, Integer> cache) {
        if (!cache.containsKey(n)) {
            cache.put(n, getNthFibCaching(n - 1, cache) + getNthFibCaching(n - 2, cache));
        }
        return cache.get(n);
    }
}
