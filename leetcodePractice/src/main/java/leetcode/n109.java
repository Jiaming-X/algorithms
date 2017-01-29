package leetcode;

import java.util.*;

public class n109 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] inorder = {1, 3, 2};
        int[] postorder = {3, 2, 1};
        
        ReconstructUsingInorderPostorder soln = new ReconstructUsingInorderPostorder();
        
        System.out.println(soln.buildTree(inorder, postorder));
    }

}


class ReconstructUsingInorderPostorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
     
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd) {
            return null;
        } else if(inBegin == inEnd) {
            return new TreeNode(inorder[inBegin]);
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int pos = this.map.get(postorder[postEnd]);
        
        int leftLen = pos - inBegin;
        int rightLen = inEnd - pos;
        
        root.left = helper(inorder, inBegin, pos - 1, postorder, postBegin, postBegin + leftLen - 1);
        root.right = helper(inorder, pos + 1, inEnd, postorder, postEnd - rightLen + 1, postEnd - 1);
        return root;
    }
}