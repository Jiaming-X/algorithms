package class18;

import java.util.Arrays;

public class ArrayDeduplication3 {
    
    
    public int[] dedup(int[] array) {
        // Write your solution here.
      if (array == null || array.length <= 1) {
          return array;
      }
      int slow = 0;  // [0, slow] is the current solution
      boolean flag = false;
      
      for (int fast = 1; fast < array.length; fast++) {  // current number
          if (array[slow] == array[fast]) {
              flag = true;
          } else if (flag) {
              array[slow] = array[fast];
              flag = false;
          } else {
              array[++slow] = array[fast];
          }
      }
        
      return Arrays.copyOf(array, flag ? slow : slow + 1);
    }
}
