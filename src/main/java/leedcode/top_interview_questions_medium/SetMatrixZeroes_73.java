package leedcode.top_interview_questions_medium;

public class SetMatrixZeroes_73 {

    public static void setZeroes(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = matrix.length -1 ; row >= 0; row--) {
            for (int col = matrix[0].length -1 ; col >= 0; col--) {
               if(matrix[0][col] == 0 || matrix[row][0] == 0){
                   matrix[row][col] = 0;
               }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + ",");
            }
            System.out.println();
        }

    }
}
