package class5_heapAndGraphSearch;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][]{ {1,  3,   5,  7},
			  {2,  4,   8,   9},
			  {3,  5, 11, 15},
			  {6,  8, 13, 18} };
		kthNumInMatrix solution = new kthNumInMatrix();

		System.out.println(solution.kthSmallest(input, 4));
	}

}
