package class13_DPII;

public class editDistance {
    // assume that both of them are not null, nor empty
    
    public int editDistance(String one, String two) {
        // Write your solution here.
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < one.length(); i++) {
            dp[i + 1][0] = i + 1;
        }
        for (int i = 0; i < two.length(); i++) {
            dp[0][i + 1] = i + 1;
        }
        
        for (int i = 1; i <= one.length(); i++) {
            for (int j = 1; j <= two.length(); j++) {
                if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        
        return dp[one.length()][two.length()];
    }
}
