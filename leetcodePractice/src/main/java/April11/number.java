package April11;

import java.util.HashSet;

public class number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStrobogrammatic("2"));
	}
    // 0, 1, 8
    // 6 vs 9
    int[] set1 = {0, 1, 8};
    int[] set2 = {6, 9};
    
    public static boolean isStrobogrammatic(String num) {
        if (num == null || num.length() < 1) {
            return true;
        }
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        int len = num.length();
        char[] chars = num.toCharArray();
        
        for (int i = 0; i < (len) / 2; i++) {
            if (!match(chars[i], chars[len - 1 - i])) {
                return false;
            }
        }
        if (len % 2 == 1 && chars[len / 2] != '0' && chars[len / 2] != '1' && chars[len / 2] != '8') {
            return false;
        }
        
        return true;
    }
    
    public static boolean match (char char1, char char2) {
        int int1 = (char1 - '0');
        int int2 = (char2 - '0');
        if ( int1 == 0 || int1 == 1 || int1 == 8) {
            return int1 == int2;
        } else if (int1 == 6) {
            return int2 == 9;
        } else if (int1 == 9) {
            return int2 == 6;
        }
        return false;
    }
}
