/**
 * Created by sheshnath on 5/17/2017.
 * problem link: https://leetcode.com/problems/longest-valid-parentheses/#/description
 */

import java.util.Stack;
public class LongestValidParanthesis {
    public int longestValidParentheses(String s) {
        int length = 0;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }
            else{
                if(!st.isEmpty()) {
                   if(s.charAt(st.peek()) == '('){
                    st.pop();
                   }
                    else{
                        st.push(i);
                       }
                }
                else{
                    st.push(i);
                }
            }
        }

        if(st.isEmpty()){
            length = s.length();
        }
        else{
            int a = s.length();
            int b = 0;
            while(!st.isEmpty()){
                b  = st.peek();
                st.pop();
                length = Math.max(length, a-b-1);
                a = b;
            }
            length = Math.max(length,a);
        }

        return length;
    }
}
