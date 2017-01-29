package leetcode;

import java.util.*;

public class n127 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        worldLadder soln = new worldLadder();
        //System.out.println(soln.ladderLength(, endWord, wordList));
    }

}


class worldLadder {
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> queue = new LinkedList<String>();
        HashSet<String> visit = new HashSet<String>();
        int level = 1;
        wordList.add(beginWord);
        wordList.add(endWord);
        queue.offerLast(beginWord);
        visit.add(beginWord);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            for (int i = 0; i < size; i++) {
                String current = queue.pollFirst();
                
                for (String next : expand(current, wordList)) {
                    if (!visit.contains(next)) {
                        queue.offerLast(next);
                    }
                    if (next.equals(endWord)) {
                        return level;
                    }
                    visit.add(next);
                }
            }
        }
        
        return 0;
    }
    
    public List<String> expand (String word, Set<String> wordList) {
        List<String> expansion = new ArrayList<String>();
        char[] charArray = word.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
            char tmp = charArray[i];
            for (char aChar = 'a'; aChar <= 'z'; aChar++) {
                charArray[i] = aChar;
                String next = new String(charArray);
                if (tmp != charArray[i] && wordList.contains(next)) {
                    expansion.add(next);
                }
                charArray[i] = tmp;
            }
        }
        return expansion;
    }
}