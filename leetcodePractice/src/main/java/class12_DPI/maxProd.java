package class12_DPI;

public class maxProd {

	// remaining
	// dp[0] = array[0];
	// 
	
	
  public int maxProduct(int length) {
    // Write your solution here.
	int[] dp = new int[length + 1];
	if (length == 2) {
		return 1;
	}
	
	dp[1] = 0;
	dp[2] = 1;
	
	
	for (int i = 3; i < length + 1; i++) {
		for (int j = 1; j <= i / 2; j++) {
			dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
		}
	}
	  
    return dp[length];
  }
}
