package class26;

public class interLeave {
    public boolean canMerge(String a, String b, String c) {
        // Write your solution here.
        if (c.length() != a.length() + b.length() ) {
            return false;
        }
        int m = a.length(), n = b.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j > 0 && dp[i][j - 1] && b.charAt(j - 1) == c.charAt(i + j - 1)) { // move to left 1 step
                    dp[i][j] = true;
                }
                if (i > 0 && dp[i - 1][j] && a.charAt(i - 1) == c.charAt(i + j - 1)) { // move down 1 step
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}
