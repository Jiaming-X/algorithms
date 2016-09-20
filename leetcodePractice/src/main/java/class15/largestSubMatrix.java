package class15;

public class largestSubMatrix {
    public int largest(int[][] matrix) {
        // Write your solution here.
        int N = matrix.length;
        int M = matrix[0].length;
        
        if (N == 1 && M == 1) {
            return matrix[0][0];
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] curr = new int[M];
            for (int j = i; j < N; j++) {
                add(curr, matrix[j]);
                
                result = Math.max(result, max(curr));
            }
        }
        
        
        return result;
    }
    
    public void add(int[] curr, int[] row){
        for (int j = 0; j < row.length; j++) {
            curr[j] += row[j];
        }
    }
    
    public int max(int[] row) {
        int result = row[0];
        int tmp = row[0];
        for (int i = 1; i < row.length; i++) {
            tmp = Math.max(tmp + row[i], row[i]);
            result = Math.max(result, tmp);
        }
        
        return result;
    }
    
}
