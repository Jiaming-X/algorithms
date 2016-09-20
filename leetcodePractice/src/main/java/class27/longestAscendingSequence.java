package class27;

public class longestAscendingSequence {
    public int longest(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return array.length;
        }
        
        int[] dp = new int[array.length];
        dp[0] = 1;
        int max = 0;
        
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
   }
}
