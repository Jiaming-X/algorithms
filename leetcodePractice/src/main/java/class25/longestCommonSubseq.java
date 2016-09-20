package class25;

public class longestCommonSubseq {
    public int longest(String s, String t) {
        // Write your solution here.
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int max = 0;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i][j - 1], dp[i - 1][j]));
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                
            }
        }
        
        return max;
    }
}
