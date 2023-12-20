package algoexpert.M36_TaskAssignment;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * k= workers
 * array = duration of tasks
 * 1) must complete 2 tasks and work on one at a time
 */
public class Program {
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        HashMap<Integer, LinkedList<Integer>> indices = getMap(tasks);
        Collections.sort(tasks); // n log n

        int l = 0;
        int r = tasks.size() - 1;
        while(l < r){
            ArrayList<Integer> pair = new ArrayList<>();
            pair.add(indices.get(tasks.get(l)).pollLast());
            pair.add(indices.get(tasks.get(r)).pollLast());
            l++;
            r--;
            pairs.add(pair);
        }
        return pairs;
    }

    public HashMap<Integer, LinkedList<Integer>> getMap(ArrayList<Integer> tasks) {
        HashMap<Integer, LinkedList<Integer>> indices = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (indices.containsKey(tasks.get(i))) {
                indices.get(tasks.get(i)).add(i);
            } else {
                indices.put(tasks.get(i), new LinkedList<>(Arrays.asList(i)));
            }
        }
        return indices;
    }

    @Test
    public void TestCase2() {
        int k = 3;
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));
        System.out.println(taskAssignment(k, tasks));
    }
}
