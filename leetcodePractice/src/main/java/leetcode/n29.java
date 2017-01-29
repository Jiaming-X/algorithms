package leetcode;

public class n29 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Divide soln = new Divide();
        
        System.out.println(soln.divide(-2147483648, -1));
    }

}

class Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        
        long result = helper(lDividend, lDivisor);
        
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else {
            result = sign * result;
        }
        
        return (int)result;
    }
    
    public long helper(long lDividend, long lDivisor) {
        if (lDividend < lDivisor) {
            return 0;
        }
        
        long sum = lDivisor;
        long multi = 1;
        
        while (sum + sum <= lDividend) {
            sum = sum + sum;
            multi += multi;
        }
        return multi + helper(lDividend - sum, lDivisor);
    }
}