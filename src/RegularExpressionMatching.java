/**
 * Created by sheshnath on 5/9/2017.
 * problem link: https://leetcode.com/problems/regular-expression-matching/#/description
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if(p.length() == 0)
            return s.length() == 0;

        int m = s.length();
        int n = p.length();

        boolean t[][] = new boolean[m+1][n+1];
        t[0][0] = true;

        ///fill the first row i.e matching patter with empty string
        for(int i = 1; i<=n; i++){
            if(p.charAt(i-1) == '*'){
                t[0][i] = t[0][i-2];
            }
            else{
                t[0][i] = false;
            }
        }

        // fill the first column
        for(int i = 1; i<=m; i++){
            t[i][0] = false;
        }

        for(int i =1 ;i <=m; i++){
            for(int j = 1; j<=n; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    t[i][j] = t[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*' ){
                    t[i][j] = t[i][j-2];
                    if(p.charAt(j-2) == '.' || p.charAt(j-2)== s.charAt(i-1)){
                        t[i][j] = t[i][j] | t[i-1][j];
                    }
                }
                else {
                    t[i][j] = false;
                }
            }
        }

        return t[m][n];
    }
}
