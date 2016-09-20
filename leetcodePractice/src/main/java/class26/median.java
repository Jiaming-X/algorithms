package class26;

import java.util.Arrays;

public class median {
    public double median(int[] a, int[] b) {
        // write your solution here
        int k = a.length + b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        
        if (k % 2 == 1) {
          return (double)helper(a, 0, b, 0, k / 2 + 1);
        } else {
          return (double)((helper(a, 0, b, 0, k / 2) + helper(a, 0, b, 0, k / 2 + 1))) / 2.0;
        }
      }
      
      public int helper (int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (aLeft >= a.length) {
          return b[bLeft + k - 1];
        } else if (bLeft >= b.length) {
          return a[aLeft + k - 1];
        } else if (k == 1) {
          return Math.min(a[aLeft], b[bLeft]);
        }
        
        int aPos = aLeft + k / 2 - 1;
        int bPos = bLeft + k / 2 - 1;
        int aVal = aPos >= a.length ? Integer.MAX_VALUE : a[aPos];
        int bVal = bPos >= b.length ? Integer.MAX_VALUE : b[bPos];
        
        if (aVal > bVal) {
          return helper(a, aLeft, b, bPos + 1, k - k / 2);
        } else {
          return helper(a, aPos + 1, b, bLeft, k - k / 2);
        }
      }
}
