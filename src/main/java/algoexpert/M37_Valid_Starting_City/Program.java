package algoexpert.M37_Valid_Starting_City;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;

/**
 *
 */
public class Program {
    public static void main(String[] args) {
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int[] visited = new int[distances.length];
        int currentFuel = 0;
        int startingCity = 0;

        int i = 0;
        while (i < distances.length) {
            currentFuel += fuel[i] * mpg;
            if (distances[i] <= currentFuel) {
                currentFuel -= distances[i];
                i++;
            } else {
                currentFuel = 0;
                startingCity = i+1;
                i = startingCity;
            }

        }

        return startingCity;
    }

    @Test
    public void TestCase() {
        int[] distances = new int[]{5, 25, 15, 10, 15};
        int[] fuel = new int[]{1, 2, 1, 0, 3};
        int mpg = 10;
        System.out.println(validStartingCity(distances, fuel, mpg));
    }

}
