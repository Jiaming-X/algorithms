package Amazon;

import java.util.*;

public class slidingWindow {

    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        HighFive soln = new HighFive();
        Map<Integer, Double> res = soln.getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}

class Result { 
    int id;
    int val;
    
    public Result (int id, int val) {
        this.id = id;
        this.val = val;
    }
}

class HighFive {
    public Map<Integer, Double> getHighFive(Result[] results){
        Map<Integer, Double> result = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (Result one : results) {
            if (!map.containsKey(one.id)) {
                map.put(one.id, new ArrayList<Integer>());
            }
            map.get(one.id).add(one.val);
        }
        for (Map.Entry<Integer, ArrayList<Integer>> one : map.entrySet()) {
            ArrayList<Integer> scores = one.getValue();
            Collections.sort(scores, new Comparator<Integer>() {
                @Override
                public int compare (Integer one, Integer two) {
                    if (one == two) {
                        return 0;
                    }
                    return one > two ? -1 : 1;
                }
            });
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += scores.get(i);
            }
            result.put(one.getKey(), (double)(sum / 5.0));
        }
        
        return result;
    }
}