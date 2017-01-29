package TA_Class4;

public class Wildcard {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= p.length(); i++) { // p
            for (int j = 1; j <= s.length(); j++) { // s
                if (p.charAt(i - 1) != '*' && p.charAt(i - 1) != '?') {
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1));
                    if (!dp[i][j]) {
                        return false;
                    } 
                } else if (p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    for (int k = j; k <= s.length(); k++) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        System.out.println("~~~");
        for (int i = 1; i <= p.length(); i++) { // p
            for (int j = 1; j <= s.length(); j++) { // s
                System.out.print((dp[i][j]?1:0));
            }
            System.out.println(".");
        }
        return dp[p.length()][s.length()];
    }
}


