package class18;

import java.util.Arrays;

public class solution {

    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayDeduplication3 solution = new ArrayDeduplication3();
        int[] inputs = {1, 2, 2, 3, 3, 3};
        int[] outputs = solution.dedup(inputs);
        System.out.println(Arrays.toString(outputs));
        
        ArrayDeduplication4 solution2 = new ArrayDeduplication4();
        int[] inputs2 = {1, 2, 3, 3, 3, 2, 2};
        int[] outputs2 = solution.dedup(inputs2);
        System.out.println(Arrays.toString(outputs));
    }
    */
    public static void main(String[] args) {
//        zigZag solution = new zigZag();
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node8 = new TreeNode(8);
//        
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node11 = new TreeNode(11);
//        
//        node5.left = node3;
//        node5.right = node8;
//        node3.left = node1;
//        node3.right = node4;
//        node8.right = node11;
//        
//        for (Integer num : solution.zigZag(node5)) {
//            System.out.println(num);
//        }
        SortInSpecifiedOrder soln = new SortInSpecifiedOrder();
        int[] result =  soln.sortSpecial(new int[]{2, 1, 2, 5, 7, 1, 9, 3}, new int[]{2, 1, 3});
        for (Integer num : result) {
            System.out.println(num);
        }
    }
}
