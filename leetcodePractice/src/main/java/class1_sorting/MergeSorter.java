package class1_sorting;

public class MergeSorter {
	  public int[] mergeSort(int[] array) {
		    // Write your solution here.
		    if (array == null || array.length <= 1) {
		      return array;
		    }
		    int[] helper = new int[array.length];
		    mergeSort(array, helper, 0, array.length - 1);
		    
		    return array;
		  }
		  
		  public void mergeSort (int[] array, int[] helper, int left, int right) {
		      if (left >= right) {
		          return;
		      }  
		      int mid = left + (right - left) / 2;
		      mergeSort(array, helper, left, mid);
		      mergeSort(array, helper, mid + 1, right);
		      mergeTwoLists(array, helper, mid, left, right);
		  }
		  
		  public void mergeTwoLists (int[] array, int[] helper, int mid, int left, int right) {
		      int leftH = left;
		      while (leftH <= right) {
		          helper[leftH] = array[leftH];
		          leftH++;
		      }

		      int curr = left;
		      int arrayOne = left;
		      int arrayTwo = mid + 1;
		      
		      while (arrayOne <= mid && arrayTwo <= right) {
		          if (helper[arrayOne] < helper[arrayTwo]) {
		              array[curr++] = helper[arrayOne++];
		          } else {
		              array[curr++] = helper[arrayTwo++];
		          }
		      }
		      
		      while (arrayOne <= mid) {
		          array[curr++] = helper[arrayOne++];
		      }
		      while (arrayTwo <= right) {
		          array[curr++] = helper[arrayTwo++];
		      }      
		  }
}
