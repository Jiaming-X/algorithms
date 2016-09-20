package class8_stringII;

import java.util.HashMap;
import java.util.HashSet;

public class longestSubString {
    public int longest(String input) {
        // Write your solution here.
        if (input == null || input.length() < 1) {
            return 0;
        }
        
        HashSet<Character> set = new HashSet<Character>();
        char[] inputs = input.toCharArray();
        int max = 0;
        int slow = 0, fast = 0;
        
        while (fast < input.length()) {
            if (set.contains(inputs[fast])) {
                set.remove(inputs[slow++]);
            } else {
                set.add(inputs[fast]);
                max = Math.max(max, fast - slow + 1);
                fast++;
            }
        }
        
        return max;
    }
}
