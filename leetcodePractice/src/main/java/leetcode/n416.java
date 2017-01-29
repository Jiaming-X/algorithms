package leetcode;

import java.util.Arrays;

public class n416 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        EqualSebsetSum soln = new EqualSebsetSum();
        int[] nums = {1, 2, 5};
        System.out.println(soln.canPartition(nums));
        
    }
}

class EqualSebsetSum {
    
    // dp[i][j]: find the subset from nums[0, i] to sum up value j
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 == 1) {
            return false;
        }
        System.out.println(sum);
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                
                if (j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(dp));
        
        return dp[nums.length][target];
    }
    
    public int sum(int[] nums) {
        int sum = 0;
        
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}