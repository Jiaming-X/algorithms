package class24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class pairI {
//    public List<List<Integer>> allPairs(int[] array, int target) {
//        // Write your solution here.
//        
//        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
//        Arrays.sort(array);
//        int left = 0, right = array.length - 1;
//        
//        while (left < right) {
//          if (array[left] + array[right] == target) {
//            result.add(Arrays.asList(left, right));
//            left++;
//          } else if (array[left] + array[right] > target) {
//            right--;
//          } else {
//            left++;
//          }
//        }
//        
//        return result;
//    }

    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here.
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < array.length; i++) {
          List<Integer> indices = map.get(target - array[i]);
          
          if (indices != null) {
            for (Integer num : indices) {
              result.add(Arrays.asList(num, i));
            }
          }
          if (!map.containsKey(array[i])) {
            map.put(array[i], new ArrayList<Integer>());
          }
          map.get(array[i]).add(i);
        }
        
        return result;
      }    
}
