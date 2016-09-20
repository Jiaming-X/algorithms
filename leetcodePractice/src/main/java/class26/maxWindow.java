package class26;

import java.util.*;

/*
 *   0  1  2  3  4
 *  {1, 2, 3, 2, 4, 2, 1}
 *  
 *  k = 4
 *  
 *  {8, 2} <- , 2
 *  
 *  
 */

public class maxWindow {
    public List<Integer> maxWindows(int[] array, int k) {
          // Write your solution here.
      
      LinkedList<Element> deque = new LinkedList<Element>();
      ArrayList<Integer> result = new ArrayList<Integer>();
      
      for (int i = 0; i < array.length; i++) {
          if (!deque.isEmpty() && deque.peekFirst().pos <= i - k) {
              deque.pollFirst();
          }
          while (!deque.isEmpty() && deque.peekLast().val < array[i]) {
              deque.pollLast();
          }
          deque.offerLast(new Element(array[i], i));
          if (k <= i + 1) {
              result.add(deque.peekFirst().val);    
          }
      }
        
      return result;
    }
    
    public class Element {
        int val;
        int pos;
        
        public Element (int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
