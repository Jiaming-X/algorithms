package class99;

import java.util.HashMap;

public class isomorphision {
    public boolean isomorphic(String s, String t) {
        // Write your solution here.
        if (s.length() != t.length()) {
          return false;
        } else if (s.length() == 0 && t.length() == 0) {
          return true;
        }
        
        HashMap<Character, Integer> map =  new HashMap<Character, Integer>();
        boolean[] used = new boolean[256];
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(sStr[i]) && !used[(int)tStr[i]]) {
                map.put(sStr[i], (int)(tStr[i] - sStr[i]));
                used[(int)tStr[i]] = true;
            } else {
                if (map.containsKey(sStr[i]) && map.get(sStr[i]) != (int)(tStr[i] - sStr[i])) {
                    return false;
                }
                if (!map.containsKey(sStr[i]) && used[(int)tStr[i]]) {
                    return false;
                }
            }
        }
        return true;
      }
}
