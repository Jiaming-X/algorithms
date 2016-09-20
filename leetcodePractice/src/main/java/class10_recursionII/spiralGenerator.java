package class10_recursionII;

import java.util.ArrayList;
import java.util.List;

public class spiralGenerator {

	  public int[][] spiralGenerate(int m, int n) {
		  	int[][] matrix = new int[m][n];
		  	if (m == 0 || n == 0) {
		  		return matrix;
		  	}
		  	
		  	int left = 0, right = n - 1;
		  	int up = 0, down = m - 1;
		  	int num = 1;
		  	
		  	/*
		  	 *  1 nothing left
		  	 *  2 one row left
		  	 *  3 one column left
		  	 */
		  	while (left < right && up < down) {
		  		
		  		for (int i = left; i <= right; i++) {
		  			matrix[up][i] = num++;
		  		}
		  		for (int i = up + 1; i <= down; i++) {
		  			matrix[i][right] = num++;
		  		}
		  		for (int i = right - 1; i >= left; i--) {
		  			matrix[down][i] = num++;
		  		}
		  		for (int i = down - 1; i >= up + 1; i--) {
		  			matrix[i][left] = num++;
		  		}
		  		
		  		left++;
		  		right--;
		  		up++;
		  		down--;
		  	}
		  	if (left > right || up > down) {
		  		return matrix;
		  	} else if (left == right) {
		  		// 1 col left
		  		for (int i = up; i <= down; i++) {
		  			matrix[i][left] = num++;
		  		}
		  	} else {
		  		// 1 row left
		  		for (int i = left; i <= right; i++) {
		  			matrix[up][i] = num++;
		  		}
		  	}
		  	//spirlTraversal(matrix, 0, matrix.length, result);
		    return matrix;
	  }	
	
}
