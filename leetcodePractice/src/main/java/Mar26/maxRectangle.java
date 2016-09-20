package Mar26;

public class maxRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [[1,1,0,0,1],[0,1,0,0,1],[0,0,1,1,1],[0,0,1,1,1],[0,0,0,0,1]]
		boolean[][] matrix = new boolean[5][5];
		int[] one = {1,1,0,0,1};
		int[] two = {0,1,0,0,1};
		int[] thr = {0,0,1,1,1};
		int[] fou = {0,0,1,1,1};
		int[] fiv = {0,0,0,0,1};
		for (int i = 0; i < 5; i++) {
			if (one[i] == 1) {
				matrix[0][i] = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (two[i] == 1) {
				matrix[1][i] = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (thr[i] == 1) {
				matrix[2][i] = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (fou[i] == 1) {
				matrix[3][i] = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (fiv[i] == 1) {
				matrix[4][i] = true;
			}
		}
		maximalRectangle(matrix);
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		*/
	}
    public static int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int result = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][][] results = new int[m + 1][n + 1][2]; // [0] vertical, [1] horizontal
        for (int i = 1; i <= m; i++) {
            results[i][0][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            results[0][i][1] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1]) {
                    results[i][j][0] = Math.min(results[i - 1][j - 1][0], results[i - 1][j][0]) + 1;
                    results[i][j][1] = Math.min(results[i - 1][j - 1][1], results[i][j - 1][1]) + 1;
                    result = Math.max(result, results[i][j][0] * results[i][j][1]);
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("(" + results[i][j][0] + ", ");
                System.out.print(results[i][j][1] + ")");
            }
            System.out.println();
        }
        return result;
    }
}
