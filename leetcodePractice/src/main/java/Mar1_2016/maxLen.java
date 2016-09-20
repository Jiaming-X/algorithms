package Mar1_2016;

import java.util.HashMap;

public class maxLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public class Solution {
	    public int maxSubArrayLen(int[] nums, int k) {
	        int[] array = new int[nums.length];
	        int sum = 0;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        
	        for (int i = 0; i < nums.length; i++) {
	            sum += nums[i];
	            array[i] = sum;
	        }
	        int result = 0;
	        map.put(0, -1);
	        for (int i = 0; i < array.length; i++) {
	            if (map.containsKey(array[i] - k)) {
	                result = Math.max(result, i - map.get(array[i] - k));
	            } else if (!map.containsKey(array[i])) {
	                map.put(array[i], i);
	            }
	        }
	        return result;
	    }
	}
}
