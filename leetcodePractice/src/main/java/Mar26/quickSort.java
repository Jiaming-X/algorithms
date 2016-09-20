package Mar26;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. K th statistics
		// 2. swich 
		int[] nums = {5, 6, -1, -3, -5, 7, 1, 2, 3};
		KthElemnt(4, nums);
		for (Integer num : nums) {
			System.out.println(num);
		}
	}
	
	public static void KthElemnt (int k, int[] numbers) {
		findKthElement(numbers, 0, numbers.length - 1, k);
	}
	
	public static void findKthElement(int[] numbers, int left, int right, int k){
		if (left > right) {
			return;
		}
		int pos = partition(left, right, numbers);
		findKthElement(numbers, pos + 1, right, k);
		findKthElement(numbers, left, pos - 1, k);
	}
	
	public static int partition (int left, int right, int[] numbers) {
		if (left == right) {
			return left;
		}
		
		int pivote = numbers[right];
		int ptr = left;
		
		for (int i = left; i < right; i++) {
			if (numbers[i] < pivote) {
				swap(numbers, ptr, i);
				ptr++;
			}
		}
		swap(numbers, ptr, right);
		return ptr;
	}
	
	public static void swap (int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
