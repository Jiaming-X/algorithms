package Mar1_2016;

import java.util.ArrayList;

public class DP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		//int[] array = {-4, 1, 1, 1, -5, 1, 1, 1, -4};
		int[] array = {-1,-2,-3,-100,-1,-50};
		for (Integer num : array) {
			inputs.add(num);
		}
		System.out.println(maxSubArray(array, 2));
	}
	
    public static int maxSubArray(int[] nums, int k) {
        // write your code here
        int[][] dp = new int[k + 1][nums.length + 1];
        int sum = 0, len = nums.length;
        
        for (int i = 1; i <= k; i++) {
            sum += nums[i - 1];
            dp[i][i] = sum;
        }
        for (int i = 2; i <= len; i++) {
            dp[1][i] = Math.max(dp[1][i - 1] + nums[i - 1], nums[i - 1]);
        }
        
        for (int i = 2; i <= k; i++) {
            for (int j = i + 1; j <= len; j++) {
                int localMax = dp[i][j - 1] + nums[j - 1];
                for (int m = i - 1; m < j; m++) {
                    if (nums[j - 1] + dp[i - 1][m] > localMax) {
                        localMax = nums[j - 1] + dp[i - 1][m];
                    }
                }
                dp[i][j] = localMax;
            }
        }
        int result = Integer.MIN_VALUE;
        for (int i = k; i <= len; i++) {
            result = Math.max(result, dp[k][i]);
        }
        printMatrix(dp);
        return result;
    }
    
    public static int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        int len = nums.size();
        int[][] f = new int[k+1][len];
        for (int i = 1; i < k+1; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums.get(j);
            }
            f[i][i-1] = sum;
        }
        for (int i = 1; i < len; i++) {
        	f[1][i] = Math.max(f[1][i-1]+nums.get(i), nums.get(i));
        }
        
        for (int i = 2; i < k+1; i++) {
            for (int n = i;  n< len; n++) {
                int curMax = f[i][n-1] + nums.get(n);
                for (int j = i-2; j < n; j++) {
                    if ((f[i-1][j] + nums.get(n)) > curMax) {
                        curMax = f[i-1][j] + nums.get(n);
                    }
                }
                f[i][n] = curMax;
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = k-1; i < len; i++){
            if (f[k][i] > res) {
                res = f[k][i];
            }
        }
        printMatrix(f);
        return res;
    }
    
    public static void printMatrix(int[][] matrix){
    	int m = matrix.length;
    	int n = matrix[0].length;
    	
    	for (int i = 0; i < m; i++){
    		for (int j = 0; j < n; j++) {
    			System.out.print(matrix[i][j]);
    			System.out.print(", ");
    		}
    		System.out.println();
    	}
    }
}
