package class4_graphSearch;

import java.util.Arrays;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		quickSelector solution = new quickSelector();
		int[] array = new int[]{1, 1, -1, -1};//{1, 0, 0, -1, -1, 1, 0};
		array = solution.kSmallest(array, 5);
		System.out.println(Arrays.toString(array));
	}

}
