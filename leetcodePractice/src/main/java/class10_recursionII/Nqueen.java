package class10_recursionII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * (y1 - y2) / (x1 - x2) = + - 1
 * 
 * 1. y1 - y2 = x1 - x2  =>     y1 - x1 + n == y2 - x2 + n   => [0, 2 * n]  
 * 
 *     
 * 2. y1 + x1 = y2 + x2    
 */

public class Nqueen {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] soln = new int[n];
        
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] revDiag = new boolean[2 * n];
        
        helper(result, soln, 0, col, diag, revDiag);
        
        return result;
    }
    
    public void helper(List<List<Integer>> result, int[] soln, int row, boolean[] col, 
            boolean[] diag, boolean[] revDiag) {
        if (row >= soln.length) {
            result.add(toList(soln));
            return;
        }
        
        for (int i = 0; i < soln.length; i++) {
            if (valid(row, i, col, diag, revDiag)) {
                soln[row] = i;
                mark(row, i, col, diag, revDiag);
                
                helper(result, soln, row + 1, col, diag, revDiag);
                
                unMark(row, i, col, diag, revDiag);
            }
        }
    }
    
    public void mark(int x, int y, boolean[] col, boolean[] diag, boolean[] revDiag) {
        int n = col.length;
        col[y] = true;
        diag[x + y] = true;
        revDiag[y - x + n] = true;
    }
    
    public void unMark(int x, int y, boolean[] col, boolean[] diag, boolean[] revDiag) {
        int n = col.length;
        col[y] = false;
        diag[x + y] = false;
        revDiag[y - x + n] = false;
    }
    
    public boolean valid (int x, int y, boolean[] col, boolean[] diag, boolean[] revDiag) {
        int n = col.length;
        if (col[y] || diag[x + y] || revDiag[y - x + n]) {
            return false;
        }
        return true;
    }
    
    public List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer num : array) {
            list.add(num);
        }
        return list;
    }
}
