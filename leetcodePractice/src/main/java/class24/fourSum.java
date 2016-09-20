package class24;

import java.util.HashMap;

public class fourSum {

    static class Pair {
        int left;
        int right;
        
        public Pair (int left, int right) {
            this.left = left;
            this.right = right;
        }   
    }
    
    public boolean exist(int[] array, int target) {
        // Write your solution here.
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sum = array[i] + array[j];
                
                if (map.containsKey(target - sum) && map.get(target - sum).right < i) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, new Pair(i, j));
                }
            }
        }
        return false;
    }
}
