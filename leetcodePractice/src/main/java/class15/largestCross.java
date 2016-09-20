package class15;



public class largestCross {
    public int largest(int[][] matrix) {
        // Write your solution here.
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;
        
        int [][] leftU = leftUp(matrix, N, M);
        int [][] rightD = rightDown(matrix, N, M);
        
        return merge(leftU, rightD, N, M);
    }
    
    public int merge(int[][] one, int[][] two, int N, int M ) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                one[i][j] = Math.min(one[i][j], two[i][j]);
                result = Math.max(result, one[i][j]);
            }
        }
        
        return result;
    }
    
    public int[][] leftUp (int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1;
                    } else if (i == 0) {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = 1;
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }
                }
            }
        }
        merge(left, up, N, M);
        return left;
    }
    
    public int[][] rightDown (int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int[N][M];
        
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1 && j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if (i == N - 1) {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = 1;
                    } else if (j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        right[i][j] = right[i][j + 1] + 1;
                        down[i][j] = down[i + 1][j] + 1;
                    }
                }
            }
        }
        merge(right, down, N, M);
        return right;
    }
    
}
