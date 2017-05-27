package misc;

/**
 * Created by sheshnath on 5/26/2017.
 * problem link: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree
 */
public class IsValidBinaryTreeSerialization {

    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        int degree = -1;
        for(String str:strs){
            degree++;
            if(degree>0){
                return false;
            }
            if(!str.equals("#")){
                degree-=2;
            }
        }
        return degree==0;
    }

}
