package Feb23_2016;

public class GoogleOA1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDigit(223336226));
	}

	public static int removeDigit(int num){
		int max = Integer.MIN_VALUE;
		String str = Integer.toString(num);
		char prevChar = ' ';
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != prevChar) {
				String newNum = str.substring(0, i) + str.substring(i + 1, str.length());
				max = Math.max(max, Integer.valueOf(newNum));
				prevChar = str.charAt(i);
			}
		}
		
		return max;
	}
}
