package class8_stringII;

import java.util.ArrayList;

public class stringReplacement {
    public String replace(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }
    
    
//    public String replace(String input, String s, String t) {
//        // Write your solution here.
//        if (s.length() >= t.length()) {
//            return shortenReplacement(input, s, t);
//        } else {
//            return longerReplacement(input, s, t);
//        }
//    }
    
    /*
     * longer replacement;
     */
    public String longerReplacement(String input, String s, String t) {
        char[] inputs = input.toCharArray();
        ArrayList<Integer> result = matches(inputs, s);
        char[] outputs = new char[input.length() + result.size() * (t.length() - s.length())];
        
        int lastIndex = result.size() - 1;
        int slow = inputs.length - 1;
        int fast = outputs.length - 1;
        
        while (slow >= 0) {
            if (lastIndex >= 0 && slow == result.get(lastIndex)) {
                replaceString(outputs, fast - t.length() + 1, t);
                slow -= s.length();
                fast -= t.length();
                lastIndex--;
            } else {
                outputs[fast--] = inputs[slow--];
            }
        }
        
        return new String(outputs);
    }
    
    public ArrayList<Integer> matches(char[] inputs, String s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0;
        
        while (i <= inputs.length - s.length()) {
            if (i + s.length() - 1 < inputs.length && equalString(inputs, i, s)) {
                result.add(i + s.length() - 1);
                i += s.length();
            } else {
                i++;
            }
        }
        
        return result;
    }
    
    /*
     * shorten replacement;
     */
    public String shortenReplacement(String input, String s, String t){
        char[] inputs = input.toCharArray();
        int slow = 0, fast = 0;
        
        while (fast < input.length()) {
            if (fast + s.length() - 1 < input.length() && equalString(inputs, fast, s)) {
                replaceString(inputs, slow, t);
                slow += t.length();
                fast += t.length();
            } else {
                inputs[slow++] = inputs[fast++];
            }
        }
        
        return new String(inputs, 0, slow);
    }
    
    public void replaceString(char[] inputs, int slow, String t) {
        for (int i = 0; i < t.length(); i++) {
            inputs[slow + i] = t.charAt(i);
        }
    }
    
    public boolean equalString(char[] inputs, int fast, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (inputs[fast + i] != s.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean equalString (char[] inputs, int i, int j, String pattern) {
        char[] patterns = pattern.toCharArray();
        
        for (int k = i; k <= j; k++) {
            if (inputs[k] != patterns[k - i]) {
                return false;
            }
        }
        return true;
    }
}
