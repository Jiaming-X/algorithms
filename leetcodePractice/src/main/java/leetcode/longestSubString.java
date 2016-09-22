package leetcode;

import java.util.HashMap;

public class longestSubString {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slow = 0;
        int fast = 0;
        int max = 0;
        char[] inputs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (; fast < inputs.length; fast++) {
            if (map.containsKey(inputs[fast])) {
                map.put(inputs[fast], map.get(inputs[fast]) + 1);
            } else if (map.size() < 2) {
                map.put(inputs[fast], 1);
            } else { // delete one char
                while (map.containsKey(inputs[slow]) && map.get(inputs[slow]) > 0) {
                    map.put(inputs[slow], map.get(inputs[slow]) - 1);
                    if (map.get(inputs[slow]) == 0) {
                        map.remove(inputs[slow]);
                    }
                    slow++;
                }
                map.put(inputs[fast], 1);
            }
            max = Math.max(max, fast - slow + 1);
        }
        
        return max;
    }
}
