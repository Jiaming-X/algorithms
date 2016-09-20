package jiuzhangContest;

import java.util.*;

public class diceSum {
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        Double prob = Math.pow(((double) 1) / 6, n);
        Double oneSix = ((double) 1) / 6;
        
        double[][] dp = new double[n][1 + 6 * n];
        
        for (int i = 0; i < 6; i++) {
            dp[0][i + 1] = oneSix;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 1 + 6 * n; j++) {
                if (dp[i - 1][j] > 0) {
                    for (int k = 1; k <= 6; k++) {
                        dp[i][j + k] += (dp[i - 1][j] * oneSix);
                    }
                }
            }
        }
        for (int i = 0; i < 1 + 6 * n; i++) {
            if (dp[n - 1][i] > 0) {
                map.put(i, dp[n - 1][i]);
            }
        }
        for (Map.Entry<Integer, Double> one : map.entrySet()) {
            result.add(one);
        }
        return result;
    }    
    
//    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
//        // Write your code here
//        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
//        // to create the pair
//        List<Map.Entry<Integer, Double>> result = new ArrayList<Map.Entry<Integer, Double>>();
//        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
//        
//        helper(0, n, map, 0);
//        
//        for (Map.Entry<Integer, Double> one : map.entrySet()) {
//            result.add(one);
//        }
//        
//        return result;
//    }
//    
//    public void helper(int count, int n, HashMap<Integer, Double> map, int currSum){
//        if (count == n) {
//            if (!map.containsKey(currSum)) {
//                map.put(currSum, (double)0);
//            }
//            map.put(currSum, map.get(currSum) + Math.pow(((double) 1) / 6, n) );
//            return;
//        }
//        
//        for (int i = 0; i < 6; i++) {
//            helper(count + 1, n, map, currSum + (i + 1));
//        }
//    }
}
