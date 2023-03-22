package algoexpert.M27_UnionFind;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Time complexity: 2^(n+m)
 * Space: O(n+m) heap memory
 */

public class Program {
    HashMap<Integer, Integer> parents = new HashMap<>();

    public void createSet(int value) {
      parents.put(value,value);
    }

    public Integer find(int value) {
        if(!parents.containsKey(value)){
            return null;
        }
        int currentParent = value;
        while(currentParent != parents.get(currentParent)){
            currentParent = parents.get(currentParent);
        }
        return currentParent;
    }

    public void union(int valueOne, int valueTwo) {
        if(!parents.containsKey(valueOne) || !parents.containsKey(valueTwo)){
            return;
        }
        int valueOneRoot = find(valueOne);
        int valueTwoRoot = find(valueTwo);
        parents.put(valueTwoRoot, valueOneRoot);

    }

    @Test
    public void TestCase1() {
        var unionFind = new Program();
        unionFind.createSet(10);
        unionFind.createSet(5);
        unionFind.union(10,5);
        Assert.assertTrue(unionFind.find(10) == 10);
        Assert.assertTrue(unionFind.find(5) == 10);
//        Assert.assertTrue(unionFind.find(5) == 5);
//        unionFind.union(5, 1);
//        Assert.assertTrue(unionFind.find(5) == unionFind.find(1));
    }
}
