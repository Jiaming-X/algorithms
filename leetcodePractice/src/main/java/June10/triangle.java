package June10;

public class triangle {
//[[2],[3,4],[6,5,7],[4,1,8,3]]
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = new int[4][4];
		triangle[0][0] = 2;
		triangle[1][0] = 3;
		triangle[1][1] = 4;
		
		triangle[2][0] = 6;
		triangle[2][1] = 5;
		triangle[2][2] = 7;

		triangle[3][0] = 4;
		triangle[3][1] = 1;
		triangle[3][2] = 8;
		triangle[3][3] = 3;		
		System.out.println(minimumTotal2(triangle));
	}
    public static int minimumTotal3(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0){
            return -1;
        } else if (triangle.length == 1) {
            return triangle[0][0];
        }
        
        int h = triangle.length;
        int[][] dpTable = new int[2][h];
        int first = triangle[0][0] + triangle[1][0];
        int diag = triangle[0][0] + triangle[1][1];

        // initialize
        dpTable[0][0] = triangle[0][0];
        dpTable[1][0] = first;
        dpTable[1][1] = diag;
        
        // top-down
        for(int i = 2; i < h; i++){
        	first += triangle[i][0];
        	diag += triangle[i][i];
            dpTable[i % 2][0] = first;
            dpTable[i % 2][i] = diag;
            
            for(int j = 1; j < i; j++){
                dpTable[i % 2][j] = Math.min(dpTable[(i - 1) % 2][j - 1], dpTable[(i - 1) % 2][j]) + triangle[i][j];
            }
            
            if (i == 3) {
                for (int k = 0; k <= i; k++) {
                    System.out.print(dpTable[i % 2][k]);
                    System.out.print(",");
                }
                System.out.println();
            }
            
        }
        // min
        int best = Integer.MAX_VALUE;
        for(int i = 0; i < h; i++){
            best = Math.min(best, dpTable[(h - 1) % 2][i]);
        }
        return best;
    }
    public static int minimumTotal2(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0){
            return -1;
        } else if (triangle.length == 1) {
            return triangle[0][0];
        }
        
        int h = triangle.length;
        int[][] dpTable = new int[h][h];
        int first = triangle[0][0] + triangle[1][0];
        int diag = triangle[0][0] + triangle[1][1];
        
        dpTable[0][0] = triangle[0][0];
        dpTable[1][0] = first;
        dpTable[1][1] = diag;
        // initialize
        /*
        for(int i = 1; i < h; i++){
            dpTable[i][0] = dpTable[i - 1][0] + triangle[i][0];
            dpTable[i][i] = dpTable[i - 1][i - 1] + triangle[i][i];
        }
        */
        
        // top-down
        for(int i = 2; i < h; i++){
        	first += triangle[i][0];
        	diag += triangle[i][i];
            dpTable[i][0] = first;
            dpTable[i][i] = diag;
            
            for(int j = 1; j < i; j++){
                dpTable[i][j] = Math.min(dpTable[i - 1][j - 1], dpTable[i - 1][j]) + triangle[i][j];
            }
            
            if (i == 3) {
                for (int k = 0; k <= i; k++) {
                    System.out.print(dpTable[i][k]);
                    System.out.print(",");
                }
                System.out.println();
            }
            
        }
        // min
        int best = Integer.MAX_VALUE;
        for(int i = 0; i < h; i++){
            best = Math.min(best, dpTable[h - 1][i]);
        }
        return best;
    }	
	
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        
        // state: f[x][y] = minimum path value from 0,0 to x,y
        int n = triangle.length;
        int[][] f = new int[n][n];
        
        // initialize 
        f[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }
        
        // top down
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - 1]) + triangle[i][j];
            }
        }
        
        // answer
        int best = f[n - 1][0];
        for (int i = 0; i < n; i++) {
            System.out.println(f[n - 1][i]);
        }
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }
        return best;
    }
}
