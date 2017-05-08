/**
 * Created by sheshnath on 5/7/2017.
 * problem link: https://leetcode.com/problems/spiral-matrix-ii/#/description
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

 For example,
 Given n = 3,
 You should return the following matrix:

 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]

 */

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int count =1;

        int row_low = 0;
        int row_high = n-1;
        int column_low = 0;
        int column_high = n-1;

        while(row_low<=row_high && column_low<=column_high){
            //adding the first row available from column
            for(int i = column_low; i<=column_high; i++){
                matrix[row_low][i] = count++;
            }
            row_low++;

            //adding the last column
            for(int i = row_low; i<=row_high; i++){
                matrix[i][column_high] = count++;
            }
            column_high--;

            if(row_low<=row_high){
                //adding last row
                for(int i = column_high; i>=column_low; i--){
                    matrix[row_high][i] = count++;
                }
                row_high--;

            }

            if(column_low<=column_high){
                //adding fist column
                for(int i = row_high; i>=row_low; i--){
                    matrix[i][column_low] = count++;
                }
                column_low++;
            }

        }

        return matrix;
    }
}
