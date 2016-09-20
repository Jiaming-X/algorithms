package class24;

import java.util.*;

public class validParenthesis {
    private char[] parenthesis = {'(', ')', '[', ']', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here.
        ArrayList<String> result = new ArrayList<String>();
        int[] count = {l, l, m, m, n, n};
        if (m + n + l == 0) {
          result.add("");
          return result;
        }
        int len = (l + m + n) * 2;
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<Character>();
        
        helper(count, stack, sb, result, len);
        return result;
    }
      
    public void helper (int[] count, LinkedList<Character> stack, StringBuilder sb, ArrayList<String> result, int len) {
        if (len == 0) {
            result.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (count[i * 2] > 0) {
                count[i * 2] = count[i * 2] - 1;
                sb.append(this.parenthesis[i * 2]);
                stack.offerLast(this.parenthesis[i * 2]);
                helper(count, stack, sb, result, len - 1);
                stack.pollLast();
                sb.deleteCharAt(sb.length() - 1);
                count[i * 2] = count[i * 2] + 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (!stack.isEmpty() && stack.peekLast() == this.parenthesis[i * 2] && count[i * 2 + 1] > count[i * 2]) {
                stack.pollLast();
                count[i * 2 + 1] = count[i * 2 + 1] - 1;
                sb.append(this.parenthesis[i * 2 + 1]);
                helper(count, stack, sb, result, len - 1);
                sb.deleteCharAt(sb.length() - 1);
                count[i * 2 + 1] = count[i * 2 + 1] + 1;
                stack.offerLast(this.parenthesis[i * 2]);
            }
        }
    }
}
