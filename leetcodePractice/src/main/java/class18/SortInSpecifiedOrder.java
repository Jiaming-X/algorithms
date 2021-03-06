package class18;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortInSpecifiedOrder {
    
    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here.
        Integer[] A1_t = toIntegerArray(A1);
        Arrays.sort(A1_t, new MyComparator(A2));
        
        return toIntArray(A1_t);
    }
    
    public int[] toIntArray(Integer[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
    
    public Integer[] toIntegerArray(int[] array) {
        Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
    
    static class MyComparator implements Comparator<Integer> {
        private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        public MyComparator(int[] array) {
            for (int i = 0; i < array.length; i++) {
                this.map.put(array[i], i);
            }
        } 
        
        @Override
        public int compare (Integer one, Integer two) {
            Integer val1 = this.map.get(one);
            Integer val2 = this.map.get(two);
            
            if (val1 != null && val2 != null) {
                return val1.compareTo(val2);
            } else if (val1 == null && val2 == null) {
                return one.compareTo(two);
            }
            return val1 != null ? -1 : 1;
        }
    }
}
