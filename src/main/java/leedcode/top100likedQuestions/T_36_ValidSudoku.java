package leedcode.top100likedQuestions;

import java.util.HashSet;
import java.util.Set;

public class T_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            Set<Character> currentNumbers = new HashSet<>();
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] != '.' &&  !currentNumbers.add(board[row][col]) ){
                    return false;
                }
            }
        }
        for (int col = 0; col < board[0].length; col++) {
            Set<Character> currentNumbers = new HashSet<>();
            for (int row = 0; col < board.length; col++) {
                if(board[row][col] != '.' &&  !currentNumbers.add(board[row][col]) ){
                    return false;
                }
            }
        }

        return false;

    }
}
