package class26;


/*
 *  A = {1, 4, 6}, B = {2, 3}, k = 3
 * 
 *  bianry search to find the soln
 *  
 *  each search, cut some array into half until we find the element. log n
 *  
 *  excluding the 
 * 
 * 
 * k = 5
 * 
 * k / 2 = 2
 * 
 * k / 4
 * 
 * k / 8
 * 
 *      0  1  2
 * A = {1, 4, 6, 10, 11}
 * 
 * B = {2, 3, 4, 6}, 
 * 
 * 
 * 
 * 
 * 
 * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
 * 
 * aLeft, 0, 1, 1
 * 
 * bLeft, 0, 0, 1
 * 
 * k      3, 2, 1
 * 
 */

public class kthInTwoArrays {
    public int kth(int[] a, int[] b, int k) {
        // Write your solution here.
        return helper(a, 0, b, 0, k);
    }
    
    public int helper (int[] a, int aLeft, int[] b, int bLeft, int k) {
        if (aLeft >= a.length) {
            return b[bLeft + k - 1];
        } else if (bLeft >= b.length) {
            return a[aLeft + k - 1];
        } else if (k == 1) {
            return a[aLeft] > b[bLeft] ? b[bLeft] : a[aLeft];
        }
        
        int aPos = aLeft + k / 2 - 1;
        int bPos = bLeft + k / 2 - 1;
        
        int aVal = aPos >= a.length ? Integer.MAX_VALUE : a[aPos];
        int bVal = bPos >= b.length ? Integer.MAX_VALUE : b[bPos];
        
        if (aVal < bVal) {
            return helper(a, aLeft + k / 2, b, bLeft, k - k / 2);
        } else {
            return helper(a, aLeft, b, bLeft + k / 2, k - k / 2);
        }
    }
}
