package class18;

import java.util.*;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
}
 

public class zigZag {
    
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here.
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        if (root == null) {
            return result;
        }
        int layer = 0;
        deque.offerFirst(root);
        
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size;i ++) {                
                if (layer == 0) {
                    TreeNode node = deque.pollLast();
                    
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                    result.add(node.key);
                } else {
                    TreeNode node = deque.pollFirst();
                    
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    } 
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                    result.add(node.key);
                }
            }
            layer = 1 - layer;
        }
        
        return result;
    }

}
