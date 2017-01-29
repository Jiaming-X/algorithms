package leetcode;

import java.util.*;

public class n93 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RestoreIP soln = new RestoreIP();
        System.out.println(soln.restoreIpAddresses("010010"));
    }

}

class RestoreIP {
    /*
        1. Document your assumptions
        2. Explain your approach and how you intend to solve the problem
            DFS, in a specific format
                one level: one block
        3. Provide code comments where applicable
        4. Explain the big-O run time complexity of your solution. Justify your answer.
        5. Identify any additional data structures you used and justify why you used them.
        6. Only provide your best answer to each part of the question.
    */
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return result;
        }
        helper(result, s, "", 4, 0);
        return result;
    }
    
    public void helper(List<String> result, String s, String curr, int level, int pos) {
        if (level == 0) {
            if (pos == s.length()) {
                result.add(curr);
            }
            return;
        }
        
        String block = "";
        int num = 0;
        for (int i = 0; i < 3 && pos + i < s.length(); i++) {
            num = num * 10 + (s.charAt(pos + i) - '0');
            block = block + (s.charAt(pos + i));
            

            if (num > 255 || (i > 0 && s.charAt(pos) == '0')) {
                continue;
            }
            
            if (level == 4) {
                helper(result, s, block, level - 1, pos + i + 1);
            } else {
                helper(result, s, curr + "." + block, level - 1, pos + i + 1);
            }
        }
    }
}
