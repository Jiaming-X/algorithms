package class10_recursionII;

import java.util.ArrayList;
import java.util.List;

public class spiral2 {
	  public List<Integer> spiral(int[][] matrix) {
		  	List<Integer> result = new ArrayList<Integer>();
		  	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
		  		return result;
		  	}
		  	int m = matrix.length;
		  	int n = matrix[0].length;
		  	int left = 0, right = n - 1;
		  	int up = 0, down = m - 1;
		  	
		  	/*
		  	 *  1 nothing left
		  	 *  2 one row left
		  	 *  3 one column left
		  	 */
		  	while (left < right && up < down) {
		  		
		  		for (int i = left; i <= right; i++) {
		  			result.add(matrix[up][i]);
		  		}
		  		for (int i = up + 1; i <= down; i++) {
		  			result.add(matrix[i][right]);
		  		}
		  		for (int i = right - 1; i >= left; i--) {
		  			result.add(matrix[down][i]);
		  		}
		  		for (int i = down - 1; i >= up + 1; i--) {
		  			result.add(matrix[i][left]);
		  		}
		  		
		  		left++;
		  		right--;
		  		up++;
		  		down--;
		  	}
		  	if (left > right || up > down) {
		  		return result;
		  	} else if (left == right) {
		  		// 1 col left
		  		for (int i = up; i <= down; i++) {
		  			result.add(matrix[i][left]);
		  		}
		  	} else {
		  		// 1 row left
		  		for (int i = left; i <= right; i++) {
		  			result.add(matrix[up][i]);
		  		}
		  	}
		  	//spirlTraversal(matrix, 0, matrix.length, result);
		    return result;
	  }
	  
	  
}
