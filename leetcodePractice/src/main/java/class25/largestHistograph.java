package class25;

import java.util.LinkedList;

public class largestHistograph {
    public int largest(int[] array) {
        // Write your solution here.
        /*
         * 1. Stack for looking back.
         * 2 .All number is stored in ascending order.
         * 
         */
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        
        for (int i = 0; i <= array.length; i++) {
            int currHeight = array.length != i ? array[i] : 0; 
            
            while (!stack.isEmpty() && array[stack.peekFirst()] >= currHeight) {
                int height = array[stack.pollFirst()];
                
                int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
                max = Math.max(max, height * (i - left));
            }
            stack.offerFirst(i);
        }
        
        return max;
    }
}
