package class12_DPI;

public class array_hopper {
	  public boolean canJump(int[] array) {
		    // Write your solution here.
		    boolean[] dp = new boolean[array.length];
		    dp[0] = true;
		    
		    for (int i = 0; i < array.length; i++) {
		      for (int j = 0; j < i; j++) {
		        if (dp[j] && array[j] + j >= i) {
		          dp[i] = true;
		        }
		      }
		    }
		    
		    return dp[array.length - 1];
		  }
}


