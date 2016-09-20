package class25;

import java.util.HashMap;

public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        // Write your solution here.
        
        HashMap<String, Integer> map = getBitMap(dict);
        
        int max = 0;
        for (int i = 0; i < dict.length; i++) {
            for (int j = i + 1; j < dict.length; j++) {
                int bitA = map.get(dict[i]);
                int bitB = map.get(dict[j]);
                
                if ((bitA & bitB) != 0) {
                    continue;
                }
                max = Math.max(max, dict[i].length() * dict[j].length());
            }
        }
        
        return max;
    }
    
    private HashMap<String, Integer> getBitMap(String[] dict) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (String str : dict) {
            int bitmap = 0;
            for (int i = 0; i < str.length(); i++) {
                bitmap |= (1 << ((int) str.charAt(i) - 'a'));
            }
            map.put(str, bitmap);
        }
        
        return map;
    }
    
}
