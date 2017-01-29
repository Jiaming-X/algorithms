package leetcode;

import java.util.Arrays;

public class n321 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] one = {3,4,6,5};
        int[] two = {9,1,2,5,8,3};
        int k = 5;
        System.out.println(Arrays.toString(maxNumber(one, two, k)));
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0) {
            return nums2;
        } else if (nums2 == null || nums2.length == 0) {
            return nums1;
        }
        int[] result = new int[k];
        
        for (int i = 0; i <= k; i++) {
            if (i < nums1.length && k - i < nums2.length) {
                int[] one = findMaxSubArray(nums1, i);
                int[] two = findMaxSubArray(nums2, k - i);
                int[] combined = merge(one, two);
                
                if (larger(combined, result)) {
                    result = combined;
                }
            }
        }
        return result;
    }
    
    public static boolean larger(int[] one, int[] two) {
        int i = 0;
        while (i < one.length && one[i] == two[i]) {
            i++;
        }
        if (i < one.length && one[i] != two[i]) {
            return one[i] > two[i];
        }
        return false;
    }
    
    public static int[] findMaxSubArray (int[] array, int k) {
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int num = 0;
        
        for (int i = 0; i < array.length; i++) {
            while (num != 0 && result[num - 1] < array[i] && k - num < array.length - i) {
                num--;
            }
            if (num < k) {
                result[num++] = array[i];
            }
        }
        return result; 
    }
    
    public static int[] merge(int[] one, int[] two) {
        if (one == null || one.length == 0) {
            return two;
        } else if (two == null || two.length == 0) {
            return one;
        }
        
        int i = 0, j = 0, count = 0;
        int m = one.length, n = two.length;
        int[] result = new int[m + n];
        
        while (i < m || j < n) {
            if (i == m) {
                result[count++] = two[j++];
            } else if (j == n) {
                result[count++] = one[i++];
            } else if (one[i] < two[j]) {
                result[count++] = two[j++];
            } else {
                result[count++] = one[i++];
            }
        }
        return result;
    }
}
