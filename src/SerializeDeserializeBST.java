import java.util.Stack;

/**
 * Created by sheshnath on 5/26/2017.
 * problem Link: https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeDeserializeBST {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(sb, root);
        return sb.toString();
    }

    public void preorder(StringBuilder sb, TreeNode root){
        if(root == null){
            return;
        }
        sb.append(root.val).append(",");
        preorder(sb,root.left);
        preorder(sb,root.right);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data==null || data.length()==0){
            return null;
        }

        String vals[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        for(int i = 1; i< vals.length; i++){
            TreeNode temp = null;
            while(!st.isEmpty() && Integer.parseInt(vals[i])>st.peek().val){
                temp = st.pop();
            }
            if(temp!=null){
                temp.right = new TreeNode(Integer.parseInt(vals[i]));
                st.push(temp.right);
            }
            else{
                temp = st.peek();
                temp.left = new TreeNode(Integer.parseInt(vals[i]));
                st.push(temp.left);
            }

        }
        return root;
    }
}
