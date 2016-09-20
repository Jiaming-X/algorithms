package class2_recursion;

public class Fibonacci_Number {

	// BF + recrusion: O(2^n)
	public long fib0 (int k) {
		if (k == 0) {
			return 0;
		} else if (k == 1) {
			return 1;
		}
		
		return fib0(k - 1) + fib0(k - 2);
	}
	
	// dp: O(n), space, O(n)
	public long fib1 (int k) {
		if (k == 0) {
			return 0;
		} else if (k == 1) {
			return 1;
		}
		
		long[] result = new long[k + 1];
		result[0] = 0;
		result[1] = 1;
		
		for (int i = 2; i <= k; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[k];
	}

	// dp: O(n), space O(1)
	public long fib2 (int k) {
		if (k == 0) {
			return 0;
		} else if (k == 1) {
			return 1;
		}

		long[] result = new long[k + 1];
		result[0] = 0;
		result[1] = 1;
		
		for (int i = 2; i <= k; i++) {
			result[i%2] = result[(i - 1)%2] + result[(i - 2)%2];
		}
		return result[k%2];
	}	
	
	public static final long[][] SEED = {{1, 1}, {1, 0}};

	public long fib3 (int K) {
		if (K == 0) {
			return 0;
		} else if (K == 1) {
			return 1;
		}
		long[][] matrix = {{1L, 1L}, {1L, 0L}};
		pow(matrix, K - 1);
		return matrix[0][0];
	}	
	
	public void pow(long[][] matrix, int k) {
		if (k == 1) {
			return;
		}
		pow(matrix, k / 2);
		multiple(matrix, matrix);
		if (k % 2 != 0) {
			multiple(matrix, SEED);
		}
	}
	
	public void multiple(long[][] matrix, long[][] multipler){
		long topLeft = matrix[0][0] * multipler[0][0] + matrix[0][1] * multipler[1][0];
		long topRight = matrix[0][0] * multipler[0][1] + matrix[0][1] * multipler[1][1];
		long bottomLeft = matrix[1][0] * multipler[0][0] + matrix[1][1] * multipler[1][0];
		long bottomRight = matrix[1][0] * multipler[0][1] + matrix[1][1] * multipler[1][1];
		
		matrix[0][0] = topLeft;
		matrix[0][1] = topRight;
		matrix[1][0] = bottomLeft;
		matrix[1][1] = bottomRight;
	}

}
