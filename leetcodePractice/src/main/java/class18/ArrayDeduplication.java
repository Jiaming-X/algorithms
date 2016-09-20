package class18;

import java.util.Arrays;

public class ArrayDeduplication {
    public int[] dedup(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 2) {
            return array;
        }
        int slow = 0;
        int fast = 1;
        
        while (fast < array.length) {
            if (array[slow] == array[fast]) {
                continue;
            }
            array[slow] = array[fast++];
        }
        
        return Arrays.copyOf(array, slow + 1);
    }
}
