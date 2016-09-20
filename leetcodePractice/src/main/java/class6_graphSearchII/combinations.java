package class6_graphSearchII;

import java.util.ArrayList;
import java.util.List;

public class combinations {

  public List<List<Integer>> combinations(int target, int[] coins) {
	    // Write your solution here.
    List<List<Integer>> result = new ArrayList<List<Integer>>();
	List<Integer> curr = new ArrayList<Integer>();
    helper(result, curr, 0, target, coins);
    return result;
  }	
  
  public void helper(List<List<Integer>> result, List<Integer> curr, int index, int target, int[] coins){
	  if (index >= coins.length) {
		  if (target == 0) {
			  result.add(new ArrayList<Integer>(curr));
		  }
		  return;
	  }
	  
	  int num = target / coins[index];
	  
	  for (int i = 0; i <= num; i++) {
		  curr.add(i);
		  helper(result, curr, index + 1, target - i * coins[index], coins);
		  curr.remove(curr.size() - 1);
	  }
  }
}
