package algoexpert.M33_CycleIngraph;


import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Recursive:
 * Time: O( wh )
 * Space
 */

public class Program {

    public boolean cycleInGraph(int[][] edges) {
        int[] visited = new int[edges.length];
        int[] inStack = new int[edges.length];

        for (int node = 0; node < edges.length; node++) {
           if(visited[node] == 1){
               continue;
           }
           boolean inCycle = dfs(node, edges, visited, inStack);
           if(inCycle){
               return true;
           }
        }
        return false;

    }

    public boolean dfs(int node, int[][] edges, int[] visited, int[] inStack){
        visited[node] = 1;
        inStack[node] = 1;

        boolean containsCycle = false;

        int[] neighbors = edges[node];
        for (int neighbor : neighbors){
            if(visited[neighbor] == 0){
                containsCycle = dfs(neighbor, edges, visited, inStack);
            }

            if(containsCycle){
                return true;
            } else if(inStack[neighbor] == 1){
                return true;
            }
        }
        inStack[node] = 0;
        return false;
    }

    @Test
    public void TestCase1() {
        int[][] input =
                new int[][] {
                        {1, 3},
                        {2, 3, 4},
                        {0},
                        {},
                        {2, 5},
                        {}
                };
        boolean expected = true;
        var actual = new Program().cycleInGraph(input);
        Assert.assertTrue(expected == actual);
    }

    @Test
    public void TestCase2() {
        int[][] input =
                new int[][] {
                        {1, 2},
                        {2},
                        {}
                };
        boolean expected = false;
        var actual = new Program().cycleInGraph(input);
        Assert.assertTrue(expected == actual);
    }
}
