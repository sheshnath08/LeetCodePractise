/**
 * Created by sheshnath on 5/24/2017.
 * problemLink: https://leetcode.com/problems/same-tree/#/description
 */
public class SameTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null && q!=null){
            return false;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }

        if(isleaf(p)&&isleaf(q)){
            if(p.val == q.val){
                return true;
            }
            return false;
        }


        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }

    boolean isleaf(TreeNode p){
        if(p.left == null && p.right==null){
            return true;
        }
        return false;
    }
}
