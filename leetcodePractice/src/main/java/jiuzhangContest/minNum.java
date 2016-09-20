package jiuzhangContest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class minNum {
    public String minNumber(int[] nums) {
        // Write your code here
        PriorityQueue<String> minHeap = new PriorityQueue<String>(nums.length, new myComparator());

        StringBuilder sb = new StringBuilder();
        for (Integer one : nums) {
            minHeap.offer(Integer.toString(one));
        }
        while (!minHeap.isEmpty()) {
            String one = minHeap.poll();
            System.out.println(one);
            sb.append(one);
        }
        return sb.toString();
    }
    static class myComparator implements Comparator<String> {
        @Override
        public int compare(String e1, String e2) {
            if (e1.equals(e2)) {
                return 0;
            }
            int i = 0;
            char[] char1 = e1.toCharArray();
            char[] char2 = e2.toCharArray();
            
            while (i < char1.length && i < char2.length) {
                if (char1[i] != char2[i]) {
                    return char1[i] < char2[i] ? -1 : 1;
                }
                i++;
            }
            if (i < char1.length) {
                return -1;
            }
            return 1;
        }
        
        public int getSize(int i) {
            int result = 0;
            while (i > 0) {
                i = i / 10;
                result += 1;
            }
            return result;
        }
    }  
}
