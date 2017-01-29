package leetcode;

import java.util.*;

public class n39 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {2, 3, 6, 7};
        CombinationSum soln = new CombinationSum();
        
        System.out.println(soln.combinationSum(num, 7));
    }

}

class CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(result, current, 0, candidates, target);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> current, int pos, int[] nums, int target) {
        if (target == 0) {
//            System.out.println(current);
            result.add(new ArrayList<Integer>(current));
            return;
        }else if (pos >= nums.length || target < 0) {
            return;
        }
        int maxNum = target / nums[pos] + 1;
        System.out.println(current);
        for (int i = 0; i < maxNum; i++) {
            int subSum = 0;
            for (int j = 0; j < i; j++) {
                subSum += nums[pos];
                current.add(nums[pos]);
            }
            
            helper(result, current, pos + 1, nums, target - subSum);
            
            for (int j = 0; j < i; j++) {
                current.remove(current.size() - 1);
            }
        }
    }    
}