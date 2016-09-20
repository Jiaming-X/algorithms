package Mar26;

import java.util.Random;

public class firstKlargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. K th statistics
		// 2. swich 
		int[] nums = {5, 6, 7, 1, 2, 3};
		System.out.println(KthElemnt(4, nums));
		for (Integer num : nums) {
			System.out.println(num);
		}
		//Random rand = new Random();
		//System.out.println(rand.nextInt(50) + 1);
	}
	
	public static int KthElemnt (int k, int[] numbers) {
		return findKthElement(numbers, 0, numbers.length - 1, k);
	}
	
	public static int findKthElement(int[] numbers, int left, int right, int k){
		if (left > right) {
			return 0;
		}
		if (left == right) {
			return numbers[left];
		}
		
		int pos = partition(left, right, numbers);
		//findKthElement(numbers, pos + 1, right, k);
		//findKthElement(numbers, left, pos - 1, k);
		//return 0;
		
		if (pos + 1 == k) {
			return numbers[pos];
		} else if (pos + 1 > k) {
			return findKthElement(numbers, left, pos - 1, k);
		} else {
			return findKthElement(numbers, pos + 1, right, k);
		}
		
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
