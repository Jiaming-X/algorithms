package class8_stringII;

import java.util.*;

public class allAnagram {
    List<Integer> allAnagrams(String s, String l) {
        // Write your solution here.
        
        HashMap<Character, Integer> map = buildMap(s);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int match = 0;
        char[] strs = l.toCharArray();
        
        for (int i = 0; i < l.length(); i++) {
            char aChar = strs[i];
            Integer count = map.get(aChar);
            if (count != null) {
                map.put(aChar, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            
            if (i >= s.length()) {
                char tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count + 1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        
        return result;
    }
    
    HashMap<Character, Integer> buildMap(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (Character aChar : s.toCharArray()) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 0);
            }
            map.put(aChar, map.get(aChar) + 1);
        }
        return map;
    }
}
