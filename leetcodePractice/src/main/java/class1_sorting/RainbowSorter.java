package class1_sorting;

public class RainbowSorter {

	// in [0, neg), all # = -1
	// in [0, zero) all # = -1, or 0
	// in [neg, zero), all # = 0
	// in (one, len], # = 1
	public int[] rainbowSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int neg = 0;
		int zero = 0;
		int one = array.length - 1;
		
		while (zero <= one) {
			if (array[zero] == 1) {
				swap(array, zero, one--);
			} else if (array[zero] == -1) {
				swap(array, zero++, neg++);
			} else {
				zero++;
			}
		}
		
		return array;
	}
	
	public void swap(int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
