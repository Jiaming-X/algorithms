package leetcode;

import java.util.*;

public class n403 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FrogJump soln = new FrogJump();
        int[] stones = {0, 1};
        System.out.println(soln.canCross(stones));
    }

}

class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones.length < 2 || stones[1] != 1) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(1).add(1);


        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];
            HashSet<Integer> set = map.get(stone);
            if(!set.isEmpty()) {
                for (Integer step : set) {
                    if (map.containsKey(stone + step)) {
                        map.get(stone + step).add(step);
                    }
                    if (stone + step - 1 > stone && map.containsKey(stone + step - 1)) {
                        map.get(stone + step - 1).add(step - 1);
                    }
                    if (map.containsKey(stone + step + 1)) {
                        map.get(stone + step + 1).add(step + 1);
                    }
                }
            }
        }
        System.out.println(map);
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}