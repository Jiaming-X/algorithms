package class6_graphSearchII;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		combinations solution = new combinations();
		int[] coins = new int[]{1, 2, 5, 10, 25};
		List<List<Integer>> result = solution.combinations(99, coins);
		
		for (List<Integer> list : result) {
			for (Integer num : list) {
				System.out.print(num);
				System.out.print(", ");
			}
			System.out.println();
		}
	}

}
