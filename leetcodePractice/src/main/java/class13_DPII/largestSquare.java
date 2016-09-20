package class13_DPII;

public class largestSquare {
    public int largest(int[][] matrix) {
        // Write your solution here.
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }
}
