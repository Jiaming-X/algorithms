package May24;

import java.util.HashSet;

public class happyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappyNum(3));
	}
	public static boolean isHappyNum(int n){
		HashSet<Integer> set = new HashSet<Integer>();
		
		while (n != 1) {
			if (set.contains(n)) {
				return false;
			} else {
				n = getNum(n);
				set.add(n);
			}
		}
		return true;
	}
	
	public static int getNum (int n) {
		int result = 0;
		
		while (n != 0) {
			int tmp = n % 10;
			n /= 10;
			result += tmp * tmp;
		}
		return result;
	}
	
}
