package May24;

import java.util.ArrayList;

public class generateParenthesis {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = generate(3);
		for (String aStr : list) {
			System.out.println(aStr);
		}
	}
	
	public static ArrayList<String> generate (int n) {
		ArrayList<String> result = new ArrayList<String>();
		String[] parethesis = {"(", ")"};
		helper(result, "", n, n, parethesis);
		
		return result;
	}
	
	public static void helper (ArrayList<String> result, String curr, int left, int right, String[] par) {
		if (left == 0 && right == 0) {
			result.add(curr);
			return;
		}
		
		if (left > 0) {
			helper(result, curr + "(", left - 1, right, par);
		}
		if (right > 0 && right > left) {
			helper(result, curr + ")", left, right - 1, par);
		}
		return;
	}
}
