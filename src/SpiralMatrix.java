
/**
 * Created by sheshnath on 5/7/2017.
 *
 * problem link: https://leetcode.com/problems/spiral-matrix/#/description
 *
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
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
