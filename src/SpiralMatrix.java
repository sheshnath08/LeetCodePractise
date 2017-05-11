
/**
 * Created by sheshnath on 5/7/2017.
 *
 * problem link: https://leetcode.com/problems/spiral-matrix/#/description
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 For example,
 Given the following matrix:

 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 You should return [1,2,3,6,9,8,7,4,5].
 *
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix, int r,int c) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m<=0){
            return res;
        }
        int n  = matrix[0].length;
        int row_low = 0;
        int row_high = m-1;
        int column_low = 0;
        int column_high = n-1;

        while(row_low<=row_high && column_low<=column_high){
            //print the first row available from column
            for(int i = column_low; i<=column_high; i++){
                res.add(matrix[row_low][i]);
            }
            row_low++;

            //print the last column
            for(int i = row_low; i<=row_high; i++){
                res.add(matrix[i][column_high]);
            }
            column_high--;

            if(row_low<=row_high){
                //print last row
                for(int i = column_high; i>=column_low; i--){
                    res.add(matrix[row_high][i]);
                }
                row_high--;

            }

            if(column_low<=column_high){
                //print fist column
                for(int i = row_high; i>=row_low; i--){
                    res.add(matrix[i][column_low]);
                }
                column_low++;
            }

        }

        return res;
    }
}
