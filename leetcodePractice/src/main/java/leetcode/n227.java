package leetcode;

import java.util.LinkedList;

public class n227 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calculator soln = new Calculator();
        
        System.out.println(soln.calculate("0-0"));
        
    }

}

class Calculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] pos = new int[1];
        int len = s.length();
        int result = 0;
        deque.offerLast(getNextNum(pos, s));
        
        while (pos[0] < len) {
            System.out.println(s.charAt(pos[0]));
            if (s.charAt(pos[0]) == '+') {
                int num = getNextNum(pos, s);
                deque.offerLast(num);
            } else if (s.charAt(pos[0]) == '-'){
                int num = getNextNum(pos, s);
                deque.offerLast(num * (-1));
            } else if (s.charAt(pos[0]) == '*'){
                int num = getNextNum(pos, s);
                deque.offerLast(num * deque.pollLast());
            } else if (s.charAt(pos[0]) == '/'){
                int num = getNextNum(pos, s);
                deque.offerLast(deque.pollLast() / num);
            } else {
                pos[0]++;
            }
        }
        
        while (!deque.isEmpty()) {
            result += (deque.pollFirst());
        }
        return result;
    }
    
    public int getNextNum(int[] pos, String s) {
        int num = 0;
        int len = s.length();
        
        if (s.charAt(pos[0]) == '+' || s.charAt(pos[0]) == '-' || s.charAt(pos[0]) == '*' || s.charAt(pos[0]) == '/') {
            pos[0]++;
        }
        
        while (pos[0] < len && ' ' == s.charAt(pos[0])) {
            pos[0]++;
        }
        while (pos[0] < len && '0' <= s.charAt(pos[0]) && s.charAt(pos[0]) <= '9') {
            num = num * 10 + (s.charAt(pos[0]) - '0');
            pos[0]++;
        }
        
        return num;
    }
}