package class7_hashTableAndString;

import java.util.HashSet;

public class removeCertainChar {
    public String remove(String large, String small) {
        // write your solution here
        
        HashSet<Character> set = buildSet(small);
        
        char[] result = large.toCharArray(); 
        int slow = 0;
        
        for (int i = 0; i < result.length; i++) {
            if (!set.contains(result[i])) {
                result[slow++] = result[i];
            }
        }
        
        return new String(result, 0, slow);
    }
    
    public HashSet<Character> buildSet (String str) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set;
    }
}
