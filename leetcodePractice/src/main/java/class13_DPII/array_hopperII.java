package class13_DPII;

public class array_hopperII {
    public int minJump(int[] array) {
    // Write your solution here
        if (array == null || array.length == 1) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 0;
        
        for (int i = 1; i < array.length; i++) {
            dp[i] = -1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (j + array[j] >= i && dp[j] != -1) {
                    if (dp[i] == -1 || dp[j] + 1 < dp[i]) {
                        dp[i] = dp[j] + 1 ;
                    }
                }
            }
        }

        return dp[array.length - 1];
    }
}
