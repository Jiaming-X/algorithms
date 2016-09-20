package class2_recursion;

public class powerFunct {

	public long power (int a, int b) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a;
		}
		
		long half = power(a, b / 2);
		if (b % 2 == 0) {
			return half * half;
		}
		return half * half * a;
	}
}
