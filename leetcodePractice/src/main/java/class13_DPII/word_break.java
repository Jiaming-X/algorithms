package class13_DPII;

import java.util.HashSet;

public class word_break {

    public boolean canBreak(String input, String[] dict) {
        // Write your solution here.
        HashSet<String> set = toSet(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        
        canBreak[0] = true;
        
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(input.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        for (Boolean bo : canBreak) {
            System.out.println(bo);
        }
        return canBreak[canBreak.length - 1];
    }
    
    public HashSet<String> toSet (String[] dict) {
        HashSet<String> dictSet = new HashSet<String>();
        for (String str : dict) {
            dictSet.add(str);
        }
        
        return dictSet;
    }
}
