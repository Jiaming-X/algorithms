package class1_sorting;

public class move0toTheEnd {

	public int[] moveZero (int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int leftInd = 0;
		int rightInd = array.length - 1;
		
		while (leftInd <= rightInd) {
			if (array[leftInd] != 0) {
				leftInd++;
			} else if (array[rightInd] == 0) {
				rightInd--;
			} else {
				swap(array, leftInd++, rightInd--);
			}
		}
		
		return array;
	}
	
	public void swap (int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
