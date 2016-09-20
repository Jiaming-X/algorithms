package Mar26;

import java.util.ArrayList;
import java.util.Collections;

public class longestCommonSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 4, 5, 1, 7, 8, 9};
		ArrayList<Integer> dp = new ArrayList<Integer>(nums.length);
		for (Integer num : nums) {
			dp.add(num);
		}
		lengthOfLIS(nums);
		//System.out.println(lengthOfLIS(nums));
	}
	public static int lengthOfLIS(int[] nums) {
	    ArrayList<Integer> dp = new ArrayList<Integer>(nums.length);
	    for (int num : nums) {
	        if (dp.size() == 0 || dp.get(dp.size()-1) < num) dp.add(num);
	        else {
	            int i = Collections.binarySearch(dp, num);
	            dp.set((i<0) ? -i-1 : i, num);
	        }
		    for (Integer tmp : dp) {
		    	System.out.print(tmp);
		    }
		    System.out.println();
	    }
	    //for (Integer num : dp) {
	    //	System.out.println(num);
	    //}
	    System.out.println(dp.size());
	    return dp.size();
	}
}
