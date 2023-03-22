package algoexpert.M35_TwoColorable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;


public class Program {
    public final static String RED = "RED";
    public final static String BLUE = "BLUE";
    public boolean twoColorable(int[][] edges) {
        String[] colorNodes = new String[edges.length];
        String color = RED;
        for (int node = 0; node < edges.length; node++) {
            if(colorNodes[node] != null){
                continue;
            }
            colorNodes[node] = color;
            boolean colored = dfs(0, edges, colorNodes, color.equals(BLUE) ? RED : BLUE);
            if(!colored) return false;
        }

        return true;
    }

    public boolean dfs(int node, int[][] edges, String[] colorNodes, String color){
        int[] neighbors = edges[node];
        boolean colored = true;
        for (int neighbor : neighbors){
            if(!colored){
                return false;
            }
            if(colorNodes[neighbor] == null){
                colorNodes[neighbor] = color;
                colored = dfs(neighbor, edges, colorNodes, color.equals(BLUE) ? RED : BLUE);
            }else if(!colorNodes[neighbor].equals(color)){
                return false;
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
