package Mar1_2016;

public class distinctSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit", T = "rabbit";
		numDistinct(S, T);
	}
    public static int numDistinct(String S, String T) {
        // write your code here
        int[][] f = new int[S.length() + 1][T.length() + 1];
        
        for(int i = 0; i <= S.length(); i++){
            f[i][0] = 1;
        }
        
        for(int i = 1; i <= S.length(); i++){
            for(int j = 1; j <= T.length(); j++){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j]; 
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        
        for(int i = 0; i <= S.length(); i++){
            for(int j = 0; j <= T.length(); j++){
                System.out.print(f[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return f[S.length()][T.length()];
    }
}
