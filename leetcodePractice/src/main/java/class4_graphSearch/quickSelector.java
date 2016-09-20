package class4_graphSearch;

import java.util.Arrays;

public class quickSelector {

	  public int[] kSmallest(int[] array, int k) {
		    // Write your solution here
		  	if (k == 0 || array == null || array.length == 0 ) {
		  		return new int[0];
		  	}
		  
		  	quickSelect(array, 0, array.length - 1, k);
		  	int[] result = Arrays.copyOf(array, k);
		  	Arrays.sort(result);
		    return result;
	  }
	      
	  public void quickSelect(int[] array, int left, int right, int k) {
		  if (left >= right) {
			  return;
		  }
		  int pos = partition(array, left, right);
		  if (pos == k - 1) {
			  return;
		  } else if (pos > k - 1) {
			  quickSelect(array, left, pos - 1, k);
		  } else {
			  quickSelect(array, pos + 1, right, k - pos);
		  }
	  }
	  
	  public int partition(int[] array, int left, int right) {
		  int randInd = getPivot(left, right);
		  swap(array, randInd, right);
		  int leftInd = left;
		  int rightInd = right - 1;
		  
		  while (leftInd <= rightInd) {
			  if (array[leftInd] < array[right]) {
				  leftInd++;
			  } else if (array[rightInd] >= array[right]) {
				  rightInd--;
			  } else {
				  swap(array, leftInd++, rightInd--);
			  }
		  }
		  swap(array, leftInd, right);
		  
	    return leftInd;
	  }
		  
	  public int getPivot(int left, int right) {
	    return left + ((int)(Math.random() * (right - left + 1)));
	  }
		  
	  public void swap(int[] array, int left, int right) {
	    int tmp = array[left];
	    array[left] = array[right];
	    array[right] = tmp;
	  }	
}
