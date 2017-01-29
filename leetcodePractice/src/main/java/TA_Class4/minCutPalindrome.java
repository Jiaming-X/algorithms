package TA_Class4;

public class minCutPalindrome {
    public int minCut(String s) {
        if (s == null || s.length() <= 1 || isPalindrome(s.toCharArray(), 0, s.length() - 1)) {
            return 0;
        }
        char[] inputs = s.toCharArray();
        int[] dp = new int[inputs.length];
        
        for (int i = 0; i < inputs.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        System.out.println("hello");
        for (int i = 1; i < dp.length; i++) {
            if (isPalindrome(inputs, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = i - 1; j > 0; j--) {
                if (isPalindrome(inputs, j, i)) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                } else {
                    dp[i] = Math.min(dp[i], dp[i - 1] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[dp.length - 1];
    }
    
    public boolean isPalindrome(char[] str, int i, int j) {
        while (i < j) {
            if (str[i] != str[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
