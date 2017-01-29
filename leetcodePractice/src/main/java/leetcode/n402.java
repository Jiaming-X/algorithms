package leetcode;

import java.util.LinkedList;

public class n402 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(removeKdigits("1432219", 3));
    }
    
    public static String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char[] input = num.toCharArray();
        LinkedList<Character> deque = new LinkedList<Character>();
        System.out.println(input);
        for (int i = 0; i < input.length; i++) {
            while (!deque.isEmpty() && input[i] < deque.peekLast() && k > 0) {
                k--;
                deque.pollLast();
            }
            deque.offerLast(input[i]);
        } 
        int len = deque.size();
        for (int i = 0; i < len; i++) {
            if (deque.peekFirst() != '0') {
                sb.append(deque.pollFirst());
            }
        }
        System.out.println(sb.toString());
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
