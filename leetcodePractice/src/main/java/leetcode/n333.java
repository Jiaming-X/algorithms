package leetcode;

public class n333 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LargestBST soln = new LargestBST();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        System.out.println(soln.largestBSTSubtree(node));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class LargestBST {
    private int result = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.result;
    }

    public Entry helper(TreeNode root, int min, int max) {
        if (root == null) {
            return new Entry(true, 0);
        } else if (root.val <= min || root.val >= max) {
            System.out.println("hello");
            System.out.println(min);
            System.out.println(max);
            return new Entry(false, 0);
        }

        Entry left = helper(root.left, min, root.val);
        Entry right = helper(root.right, root.val, max);


        System.out.println(">");
        System.out.println(root.left.val);
        System.out.println(left.isBST);
        // is BST
        if (left.isBST && right.isBST) {
            System.out.println(">");
            this.result = Math.max(this.result, left.num + right.num + 1);
            return new Entry(true, left.num + right.num + 1);
        }
        return new Entry(false, 0);
    }

    class Entry {
        boolean isBST;
        int num;
        public Entry(boolean isBST, int num) {
            this.isBST = isBST;
            this.num = num;
        }
    }
}