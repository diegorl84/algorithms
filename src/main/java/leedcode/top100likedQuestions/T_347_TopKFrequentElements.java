package leedcode.top100likedQuestions;

import org.junit.Test;

import java.util.*;

public class T_347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        List<Integer>[] top = new ArrayList[nums.length + 1];

        int[] ans = new int[k];
        for(int num: nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        // Create list of arrays [key,counter]  from map and order it by counter asc,  Integer.compare(b[1], a[1]) then take the first k-th rows.
        // Iterate map O(k), organize O(k log k), k number of unique numbers, worse case k =n
//        List<int[]> list = new ArrayList<>();
//        for(int key : counter.keySet()){
//            list.add(new int[]{key, counter.get(key)});
//        }
//        Collections.sort(list, (a,b) -> Integer.compare(b[1], a[1]));
//
//        for (int i = 0; i < k; i++) {
//            ans[i] = list.get(i)[0];
//        }


        for(int key : counter.keySet()){
            int freq = counter.get(key);
            if(top[freq] == null){
                top[freq] = new ArrayList<>();
            }
            top[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (top[i] != null)
                for (int val : top[i]){
                    res[index++] = val;
                    if(index == k)
                        return res;
                }

        return ans;
    }
    @Test
    public void test(){
        topKFrequent(new int[]{3,2,2,1,1,1}, 2);
    }
}
