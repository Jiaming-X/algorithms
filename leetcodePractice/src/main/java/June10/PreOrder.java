package June10;
import java.util.ArrayList;
import java.util.Stack;

public class PreOrder {
    static Stack<TreeNode> st = new Stack<TreeNode>();
    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        
        TreeNode root = n4;
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n7;
        n7.left = n6;
        n6.left = n5;
        n7.right = n9;
        n9.left = n8;
        
        st.push(root);
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            if(cur == null) continue;
            if(cur.tag == -1){
                arr.add(cur.val);
            }else{
            	postpush(cur);
            }
        }
        
        for(int i: arr){
            System.out.println(i);
        }
        
    }
    
    static void prepush(TreeNode root){
        st.push(root.right);
        st.push(root.left);
        root.tag = -1;
        st.push(root);
    }
    
    static void inpush(TreeNode root){
        st.push(root.right);
        root.tag = -1;
        st.push(root);
        st.push(root.left);
        
    }
    
    static void postpush(TreeNode root){
        root.tag = -1;
        st.push(root);
        st.push(root.right);
        st.push(root.left);
        
    }
    
    
    static class TreeNode{
        int val;
        int tag = 0;
        TreeNode left, right;
        
        public TreeNode(int val){
            this.val = val;
        }
    }
}