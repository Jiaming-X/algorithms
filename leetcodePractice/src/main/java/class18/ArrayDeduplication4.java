package class18;

import java.util.Arrays;

public class ArrayDeduplication4 {
    public int[] dedup(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 1) {
            return array;
        }
        
        int slow = -1; // [0, slow] in the stack, slow = -1 if stack if empty
        
        for (int fast = 1; fast < array.length; fast++) {
            
            if (slow == -1 || array[slow] != array[fast]) {
                array[++slow] = array[fast];
            } else {
                
                while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        
        return Arrays.copyOf(array, slow + 1);
    }
}
