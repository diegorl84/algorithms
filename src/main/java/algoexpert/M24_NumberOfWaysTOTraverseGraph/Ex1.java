package algoexpert.M24_NumberOfWaysTOTraverseGraph;


import org.junit.Assert;
import org.junit.Test;

/**
 * Time complexity: 2^(n+m)
 * Space: O(n+m) heap memory
 */
public class Ex1 {
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        return get(width, height);
    }
    public static int get(int x, int y) {
        if(x == 1 || y == 1){
            return 1;
        }
        return get(x , y - 1) +  get(x -1, y);
    }

    public static void main(String[] args) {

        System.out.println(numberOfWaysToTraverseGraph(4, 3));
    }
    @Test
    public void TestCase1() {
        Assert.assertEquals(10,numberOfWaysToTraverseGraph(4,3));
    }
}
