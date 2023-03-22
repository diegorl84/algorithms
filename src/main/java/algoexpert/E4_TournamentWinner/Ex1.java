package algoexpert.E4_TournamentWinner;

import java.util.*;

/**
 * Time complexity: O(n)
 * Space:
 */
public class Ex1 {
    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        int resultIdx = 0;
        Map<String,Integer> finals = new HashMap<>();

        for(List<String> game: competitions){

            if(results.get(resultIdx) == 1){
                if(finals.containsKey(game.get(0))){
                    int previousResult = finals.get(game.get(0));
                    finals.put(game.get(0), previousResult + 3 );
                }else{
                    finals.put(game.get(0), 3 );
                }
            }else{
                if(finals.containsKey(game.get(1))){
                    int previousResult = finals.get(game.get(1));
                    finals.put(game.get(1), previousResult + 3 );
                }else{
                    finals.put(game.get(1), 3 );
                }
            }

            resultIdx++;
        }
        String winner = "";
        int max = 0;
        System.out.println(finals);
        for(String key : finals.keySet()){
            if(finals.get(key) > max){
                winner = key;
                max = finals.get(key);
            }
        }
        return winner;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> compe = new ArrayList<>();
        ArrayList<String> g1 = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> g2 = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> g3 = new ArrayList<>(Arrays.asList("Python", "HTML"));

        compe.add(g1);
        compe.add(g2);
        compe.add(g3);

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0,0,1));

        tournamentWinner(compe,results);
    }
}
