package class1_sorting;

public class SelectionSorter {

	public int[] solve (int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		
		int len = array.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		
		
		return array;
	}
	
	public void swap (int[] array, int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
}
