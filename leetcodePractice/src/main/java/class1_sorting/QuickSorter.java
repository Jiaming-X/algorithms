package class1_sorting;

import java.util.Random;

public class QuickSorter {

	public int[]  quickSort (int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	
	public void quickSort (int[] array, int left, int right) {
		if (left >= right) {
			return;
		}
		int pivotInd = getPivot(left, right);
		pivotInd = partition(array, pivotInd, left, right);
		quickSort(array, left, pivotInd - 1);
		quickSort(array, pivotInd + 1, right);
	}
	
	public int partition (int[] array, int pivot, int left, int right) {
		swap(array, pivot, right);
		int leftInd = left;
		int rightInd = right - 1;
		
		while (leftInd <= rightInd) {
			if (array[leftInd] < array[right]) {
				leftInd++;
			} else if (array[rightInd] >= array[right]) {
				rightInd--;
			} else {
				swap(array, leftInd, rightInd);
				leftInd++;
				rightInd--;
			}
		}
		swap(array, leftInd, right);
		return leftInd;
	}
	
	public int getPivot (int left, int right) {
		return ((int) (Math.random() * (right - left + 1))) + left;
	}
	
	public void swap (int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
}
