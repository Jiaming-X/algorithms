package class10_recursionII;

import java.util.ArrayList;
import java.util.List;


/*
 * 
 * 	1 2 3 
 *  8 9 4  
 *  7 6 5  
 *  
 *  
 *  5 x 5
 *  
 *  offSet: 1, 2, 3
 *  size  : 5, 3, 1
 */
public class spiral1 {

	  public List<Integer> spiral(int[][] matrix) {
		    // Write your solution here.
		  	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			    return new ArrayList<Integer>();
		  	}
		  	List<Integer> result = new ArrayList<Integer>();
		  	spirlTraversal(matrix, 0, matrix.length, result);
		    return result;
	  }
	  
	  public void spirlTraversal (int[][] matrix, int offSet, int size, List<Integer> result) {
		  if (size == 0) {
			  return;
		  } else if (size == 1) {
			  result.add(matrix[offSet][offSet]);
			  return;
		  }
		  // base
		  for (int i = 0; i < size - 1; i++) {
			  result.add(matrix[0 + offSet][offSet + i]);
		  }
		  for (int i = 0; i < size - 1; i++) {
			  result.add(matrix[offSet + i][offSet + size - 1]);
		  }
		  for (int i = size - 1; i >= 1; i--) {
			  result.add(matrix[offSet + size - 1][offSet + i]);
		  }
		  for (int i = size - 1; i >= 1; i--) {
			  result.add(matrix[offSet + i][offSet]);
		  }
		  
		  // recursion
		  spirlTraversal(matrix, offSet + 1, size - 2, result);
	  }
}
