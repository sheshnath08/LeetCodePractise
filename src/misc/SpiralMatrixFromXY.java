package misc;

/**
 * Created by sheshnath on 5/10/2017.
 * print matrix in spiral matrix starting from x,y
 */
public class SpiralMatrixFromXY {
    static void spiralMatrix(int matrix[][], int x, int y){
        int m = matrix.length;
        int n = matrix[0].length;
//        int top = x;
//        int bottom = (n-1)-x;
//        int left = y;
//        int right = (m-1)-x;
//        int dir = x%2;
//
//        while(top<=bottom && left<= right){
//            //print first row
//            if(dir==0){
//                for(int i =left; i<=right;i++){
//                    System.out.println(matrix[top][i]);
//                }
//                top++;
//                dir = 1;
//            }
//            //print last column
//            else if(dir == 1){
//                for(int i = top; i<=bottom; i++){
//                    System.out.println(matrix[i][right]);
//                }
//                right--;
//                dir = 2;
//            }
//            //print last row
//            else if(dir ==2){
//                for(int i = right; i >=left; i--){
//                    System.out.println(matrix[bottom][i]);
//                }
//                bottom--;
//                dir = 3;
//            }
//            //print first column
//            else if(dir == 3){
//                for(int i = bottom; i>=top; i--){
//                    System.out.println(matrix[i][left]);
//                }
//                left++;
//                dir = 0;
//            }
//        }

        int row_low = x;
        int row_high = (m-1)-x;
        int column_low = y;
        int column_high = (n-1)-x;

        while(row_low<=row_high && column_low<=column_high){
            //print the first row available from column
            for(int i = column_low; i<=column_high; i++){
                System.out.println(matrix[row_low][i]);
            }
            row_low++;

            //print the last column
            for(int i = row_low; i<=row_high; i++){
                System.out.println(matrix[i][column_high]);
            }
            column_high--;

            if(x<=row_high){
                //print last row
                for(int i = column_high; i>=column_low; i--){
                    System.out.println(matrix[row_high][i]);
                }
                row_high--;

            }

            if(column_low<=column_high){
                //print fist column
                for(int i = row_high; i>=row_low; i--){
                    System.out.println(matrix[i][column_low]);
                }
                column_low++;
            }

        }

    }

    public static void main(String args[]){
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        spiralMatrix(matrix,1,3);
    }
}
