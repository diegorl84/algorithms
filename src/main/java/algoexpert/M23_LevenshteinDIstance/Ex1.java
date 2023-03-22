package algoexpert.M23_LevenshteinDIstance;


/**
 * Time complexity: O(nm) lengths of strings
 * Space complexity: O(nm) map[n][m]
 */
public class Ex1 {
    public static int levenshteinDistance(String str1, String str2) {
        int[][] map = new int[str1.length() + 1][str2.length() + 1];
        map[0][0] = 0;
        for(int i =1; i <= str2.length() ; i++){
            map[0][i] = i;
        }

        for(int i =1; i <= str1.length() ; i++){
            map[i][0] = i;
        }


        for(int i = 1; i <= str1.length() ; i++ ){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    map[i][j] = map[i-1][j-1];
                }else{
                    int min = getMin(i, j, map) +1;
                    map[i][j] = min;
                }
            }
        }

        return map[str1.length()][str2.length()];
    }

    static int getMin(int i, int j, int[][] map){
        int left = map[i][j-1];
        int top = map[i-1][j];
        int diag = map[i-1][j-1];
        return Math.min(left, Math.min(top, diag));
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("abc", "yabd"));
    }
}
