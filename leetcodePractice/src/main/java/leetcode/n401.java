package leetcode;

import java.util.*;

public class n401 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryWatch soln = new BinaryWatch();
        System.out.println(soln.readBinaryWatch(2));
    }

}

class BinaryWatch {
    private int[] hours = {1, 2, 4, 8};
    private int[] mins = {1, 2, 4, 8, 16, 32};
        
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> list = new ArrayList<String>();
        if (num == 0) {
            list.add("0:00");
            return list;
        }
        
        for (int i = 0; i <= num; i++) {
            ArrayList<String> hourList = new ArrayList<String>();
            ArrayList<String> minList = new ArrayList<String>();
            
            helper(i, 0, 0, this.hours, hourList, 12);
            helper(num - i, 0, 0, this.mins, minList, 60);
            
            System.err.println(minList);
            for (String hour : hourList) {
                for (String min : minList) {
                    if (min.length() == 1) {
                        list.add(hour + ":0" + min);
                    } else {
                        list.add(hour + ":" + min);
                    }
                }
            }
        }
        
        return list;
    }
    
    public void helper(int n, int pos, int sum, int[] choices, List<String> current, int max) {
        if (n == 0 || pos >= choices.length) {
            if (n == 0 && sum < max) {
                current.add(Integer.toString(sum));
            }
            return;
        }
        
        // add
        helper(n - 1, pos + 1, sum + choices[pos], choices, current, max);
        
        // don't add
        helper(n, pos + 1, sum, choices, current, max);
    }
}