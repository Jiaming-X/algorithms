package class24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetII {
    public List<String> subSets(String set) {
        // Write your solution here.
        ArrayList<String> result = new ArrayList<String>();
        if (set == null) {
          return result;
        } else if (set.length() == 0) {
          result.add("");
          return result;
        }
        
        char[] inputs = set.toCharArray();
        Arrays.sort(inputs);
        StringBuilder sb = new StringBuilder();
        
        helper(result, 0, sb, inputs);
        
        return result;
      }
      
      public void helper(ArrayList<String> result, int pos, StringBuilder sb, char[] inputs) {
        if (pos >= inputs.length) {
          result.add(sb.toString());
          return;
        }
        
        sb.append(inputs[pos]);
        helper(result, pos + 1, sb, inputs);
        sb.deleteCharAt(sb.length() - 1);
        
        while (pos + 1 < inputs.length && inputs[pos] == inputs[pos + 1]) {
          pos++;
        }
        
        helper(result, pos + 1, sb, inputs);
      }
}
