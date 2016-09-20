package class21;

public class cuttingWood {
    
    
    public int minCost(int[] cuts, int length) {
        // Write your solution here.
        
        int[] pos = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            pos[i + 1] = cuts[i];
        }
        pos[cuts.length + 1] = length;

        int size = pos.length;
        int[][] dp = new int[size][size];
        
        for (int i = size - 3; i >= 0; i--) {
            for (int j = i + 2; j < size; j++) {
                
                int minCost = Integer.MAX_VALUE;
                for (int locSize = 1; locSize < j - i; locSize++) {
                    minCost = Math.min(minCost, dp[i][j - locSize] + dp[j - locSize][j] + (pos[j] - pos[i]));
                }
                dp[i][j] = minCost;
            }
        }
        
        return dp[0][size - 1];
    }
}
