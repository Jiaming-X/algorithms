package class8_stringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 *  a b c d
 *  |
 *  i
 *  for loop, and swap
 *  a (b c d),                  b (a c d),    c (b a d),  d (b c a)
 *  
 *  a b (c d),  a c (b d), a d ()
 * 
 */

public class permutation {
    public List<String> permutations(String set) {
        // Write your solution here.
        char[] inputs = set.toCharArray();
        List<String> result = new ArrayList<String>();
        
        helper(inputs, 0, result);
        
        return result;
    }
    
    public void helper (char[] inputs, int pos, List<String> result) {
        if (pos >= inputs.length) {
            result.add(new String(inputs));
            return;
        }
        HashSet<Character> usedChar = new HashSet<Character>();
        
        for (int i = pos; i < inputs.length; i++) {
            if (usedChar.contains(inputs[i])) {
                continue;
            }
            usedChar.add(inputs[i]);
            swap(inputs, i, pos);
            helper(inputs, pos + 1, result);
            swap(inputs, i, pos);
        }   
    }
    
    public void swap (char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
