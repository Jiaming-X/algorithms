package class1_sorting;

import java.util.Arrays;


public class solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		MergeSorter solution = new MergeSorter();
		int[] array = new int[]{3, 12, 5, 1};
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		QuickSorter solution2 = new QuickSorter();
		int[] array2 = new int[]{3, 12, 5, 1};
		array2 = solution2.quickSort(array2);
		System.out.println(Arrays.toString(array2));

		SelectionSorter solution3 = new SelectionSorter();
		int[] array3 = new int[]{3, 12, 5, 1};
		array3 = solution3.solve(array3);
		System.out.println(Arrays.toString(array3));	
		*/
		/*
		move0toTheEnd solution  = new move0toTheEnd();
		int[] array = new int[]{0, 0, 3, 12, 5, 1, 0};
		array = solution.moveZero(array);
		System.out.println(Arrays.toString(array));
		*/
		RainbowSorter solution = new RainbowSorter();
		int[] array = new int[]{1, 1, -1, -1};//{1, 0, 0, -1, -1, 1, 0};
		array = solution.rainbowSort(array);
		System.out.println(Arrays.toString(array));
	}
}
