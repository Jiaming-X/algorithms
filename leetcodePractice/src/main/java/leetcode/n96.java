package leetcode;

import java.util.Arrays;

public class n96 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        UniqueBST soln = new UniqueBST();
        System.out.println(soln.numTrees(3));
    }
}

class UniqueBST {
    public int numTrees(int n) {
        if (n <= 0) {
            return 1;
        }
        // with n as root, the number of unique tree that can construct.
        // dp[i][j]: for the tree with size of i, the number of unique tree with j as head
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) { // size of the tree
            for (int j = 0; j < i; j++) {  // size of the left subTree
                dp[i] += (dp[j] * dp[i - 1 - j]);
            }

            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }
}
