/**
 * Created by sheshnath on 5/10/2017.
 * problem link: https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int m = matrix.length;
        for(int i=0; i<m; i++){
            for(int j =0; j<i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i =0; i<m; i++){
            for(int j=0; j<m/2; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[i][m-1-j];
               matrix[i][m-1-j] = temp;
            }
        }
        for(int i=0; i<m; i++){
            for(int j =0; j<m; j++){
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }
}
