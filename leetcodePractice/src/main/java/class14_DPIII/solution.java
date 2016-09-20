package class14_DPIII;

public class solution {
    public int largestSum(int[] array) {
        // Write your solution here.
        
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}
