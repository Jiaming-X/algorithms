package Mar26;

import java.util.HashMap;
import java.util.Map;

public class recursiveFraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fractionToDecimal(1, 14));
	}
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        String sign = (numerator == 0 || (numerator < 0 ) == (denominator < 0) ) ? "" : "-";
        sb.append(sign);
        
        long num = (long)Math.abs(numerator);
        long den = (long)Math.abs(denominator);
        sb.append((int)(num / den));
        if (num % den == 0) {
            return sb.toString();
        }
        sb.append(".");
        num = num % den;
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while (!map.containsKey((num))) {
            ///long tmp = (10 * num / den);
        	System.out.println(num);
            map.put(num, sb.length());
            sb.append(10 * num / den);
            num = 10 * num % den;
        }
        int pos = map.get(num);
        sb.insert(pos, "(");
        sb.append(")");
        return sb.toString().replace("(0)", "");
    }
}
