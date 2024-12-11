package algoexpert.E4_TournamentWinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Time complexity: O(n) when n is number of competitions, O(k) where m is number of teams
     * Space complexity: O(k) where m is number of teams
     */
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scores = new HashMap<>();
        String winnerTeam;
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                winnerTeam = competitions.get(i).get(0);
            } else {
                winnerTeam = competitions.get(i).get(1);
            }
            if (scores.containsKey(winnerTeam)) {
                scores.put(winnerTeam, scores.get(winnerTeam) + 3);
            } else {
                scores.put(winnerTeam, 3);
            }
        }
        int maxValue = 0;
        String maxW = "";
        for (Map.Entry<String, Integer> entry: scores.entrySet()){
            if(entry.getValue() > maxValue){
                maxValue = entry.getValue();
                maxW = entry.getKey();
            }
        }
        return maxW;
    }

    /**
     * Time complexity: O(n) when n is number of competitions
     * Space complexity: O(k) where m is number of teams
     */
    public static String tournamentWinner2(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> scores = new HashMap<>();
        String currentBestTeam = "";
        String winnerTeam;
        for (int i = 0; i < competitions.size(); i++) {
            if (results.get(i) == 1) {
                winnerTeam = competitions.get(i).get(0);
            } else {
                winnerTeam = competitions.get(i).get(1);
            }
            if (scores.containsKey(winnerTeam)) {
                scores.put(winnerTeam, scores.get(winnerTeam) + 3);
            } else {
                scores.put(winnerTeam, 3);
            }
            if(scores.get(winnerTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winnerTeam;
            }
        }
        return currentBestTeam;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<String>> compe = new ArrayList<>();
        ArrayList<String> g1 = new ArrayList<>(Arrays.asList("HTML", "Java"));
        ArrayList<String> g2 = new ArrayList<>(Arrays.asList("Java", "Python"));
        ArrayList<String> g3 = new ArrayList<>(Arrays.asList("Python", "HTML"));

        compe.add(g1);
        compe.add(g2);
        compe.add(g3);

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 1, 1));
        System.out.println(tournamentWinner(compe, results));

    }
}
