package class13_DPII;

public class solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    /*
	    array_hopperII solution = new array_hopperII();
	    int[] nums = {3, 3, 1, 0, 4};
	    System.out.println(solution.minJump(nums));
	    
	    word_break solution2 = new word_break();
	    String[] strs = new String[]{"bob", "cat", "rob"};
	    System.out.println(solution2.canBreak("robcatbob", strs));
	    */
	    //editDistance solution = new editDistance();
	    //System.out.println(solution.editDistance("sigh", "asith"));
	    int[][] matrix = 
	          { {1, 1, 1, 1},
	            {1, 1, 1, 1},
	            {1, 1, 1, 1},
	            {1, 1, 1, 1}
	            };
	    largestSquare solution = new largestSquare();
	    System.out.println(solution.largest(matrix));
	}
}
