package Amazon;

import java.util.*;

public class courseScheduleII {
    public static void main (String[] args) {
        courseScheduler soln = new courseScheduler();
        //int[][] prerequisites = {{1, 0}, {2, 0}};
        int[][] prerequisites = {{5,8}, {3,5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        int num = 10;
        int[] result = soln.findOrder(num, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}

class Print<KeyType, ValueType> {
    public void printHashMap (HashMap<KeyType, ValueType> map) {
        for (Map.Entry<KeyType, ValueType> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}

class courseScheduler {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> all =  new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            all.add(i);
        }
        HashMap<Integer, HashSet<Integer>> indegree = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, HashSet<Integer>> next = new HashMap<Integer, HashSet<Integer>>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] result = new int[numCourses];
        int count = 0;
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            if (!indegree.containsKey(pair[0])) {
                indegree.put(pair[0], new HashSet<Integer>());
            }
            indegree.get(pair[0]).add(pair[1]);
            
            if (!next.containsKey(pair[1])) {
                next.put(pair[1], new HashSet<Integer>());
            }
            next.get(pair[1]).add(pair[0]);
        }
        
        HashSet<Integer> visit = new HashSet<Integer>();
        for (Integer num : all) {
            if (!next.containsKey(num) && !indegree.containsKey(num)) {
                result[count++] = num;
            } else if (!indegree.containsKey(num)) {
                queue.offerLast(num);
            }
        }
        
        while (!queue.isEmpty()) {
            Integer current = queue.pollFirst();
            result[count++] = current;
            
            if (next.containsKey(current)) {
                for (Integer neig : next.get(current)) {
                    indegree.get(neig).remove(current);
                    if (indegree.get(neig).size() == 0) {
                        indegree.remove(neig);
                        queue.offerLast(neig);
                    }
                }
            }
        }
        
        if(count == numCourses){
            return result;
        }else{
            return new int[0];
        }
    }
}


