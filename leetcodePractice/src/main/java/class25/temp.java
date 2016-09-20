package class25;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class temp {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        int ai = 0, bi = 0, ci = 0;
        
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(2 * k, 
                new Comparator<List<Integer>>(){
            @Override
            public int compare (List<Integer> l1, List<Integer> l2) {
            long dis1 = distance(l1, a, b, c);
            long dis2 = distance(l2, a, b, c);
            
            if (dis1 == dis2) {
              return 0;
            }
            return dis1 < dis2 ? -1 : 1;
            }
            
            private long distance (List<Integer> list, int[] a, int[] b, int[] c) {
                long dis = 0;
                
                dis += a[list.get(0)] * a[list.get(0)];
                dis += b[list.get(1)] * b[list.get(1)];
                dis += c[list.get(2)] * c[list.get(2)];
                
                return dis;
              }
        } 
                );
        
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> curr = Arrays.asList(0, 0, 0);
        set.add(curr);
        minHeap.offer(curr);
        
        while (k > 0) {
          curr = minHeap.poll();
          List<Integer> n = Arrays.asList(curr.get(0) + 1, curr.get(1), curr.get(2));
          if (n.get(0) < a.length && set.add(n)) {
            minHeap.add(n);
          }
          
          n = Arrays.asList(curr.get(0), curr.get(1) + 1, curr.get(2));
          if (n.get(1) < b.length && set.add(n)) {
            minHeap.add(n);
          }
          
          n = Arrays.asList(curr.get(0), curr.get(1), curr.get(2) + 1);
          if (n.get(2) < c.length && set.add(n)) {
            minHeap.offer(n);
          }      
          k--;
        }
        curr.set(0, a[curr.get(0)]);
        curr.set(1, b[curr.get(1)]);
        curr.set(2, c[curr.get(2)]);
        return curr;
      }

      
//        static class myComparator implements Comparator<List<Integer>>{
//            @Override
//            public int compare (List<Integer> l1, List<Integer> l2) {
//            long dis1 = distance(l1, a, b, c);
//            long dis2 = distance(l2, a, b, c);
//            
//            if (dis1 == dis2) {
//              return 0;
//            }
//            return dis1 < dis2 ? -1 : 1;
//            }
//            
//            private long distance (List<Integer> list, int[] a, int[] b, int[] c) {
//              long dis = 0;
//              
//              dis += a[list.get(0)] * a[list.get(0)];
//              dis += b[list.get(1)] * b[list.get(1)];
//              dis += c[list.get(2)] * c[list.get(2)];
//              
//              return dis;
//            }
//        }      
      
}
