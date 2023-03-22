package algoexpert.M35_TwoColorable;

import org.junit.Test;

import java.util.Stack;


public class Program2 {
    public final static String RED = "RED";
    public final static String BLUE = "BLUE";
    public boolean twoColorable(int[][] edges) {
        String[] colorNodes = new String[edges.length];
        colorNodes[0] = RED;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (stack.size() > 0) {
            int node = stack.pop();
            for (int neighbor : edges[node]) {
                if (colorNodes[neighbor] == null) {
                    colorNodes[neighbor] = colorNodes[node] == RED ? BLUE : RED;
                    stack.push(neighbor);
                } else if (colorNodes[neighbor] == colorNodes[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void TestCase2() {
        int[][] edges = {{1,2,3},{0},{0},{0}};
        System.out.println(twoColorable(edges));
    }
}
