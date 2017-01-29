package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class n126 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Word_Ladder_II soln = new Word_Ladder_II();
        String beginWord = "hit";
        String endWord = "cog";
        String[] strs = {"hot","dot","dog","lot","log"};
        HashSet<String> wordList = new HashSet<String>(Arrays.asList(strs));
        
        System.out.println(wordList);
        // "hot"
        // "dog"
        // ["hot","dog","dot"]
        List<List<String>> result = soln.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }

}
class Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        ArrayList<String> curr = new ArrayList<String>();
        curr.add(beginWord);
        wordList.add(beginWord);
        wordList.add(endWord);
        
        HashMap<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        bfs(wordList, map, distance, beginWord);
        
        dfs(result, curr, endWord, map, distance);

        return result;
    }
    public void dfs (ArrayList<List<String>> result, ArrayList<String> curr, String endWord, HashMap<String, HashSet<String>> map, HashMap<String, Integer> distance) {
        String prev = curr.get(curr.size() - 1);
        if (prev.equals(endWord)) {
            result.add(new ArrayList<String>(curr));
            return;
        }
        for (String next : map.get(prev)) {
            curr.add(next);
            dfs(result, curr, endWord, map, distance);
            curr.remove(curr.size() - 1);
        }
    }

    public void bfs (Set<String> wordList, HashMap<String, HashSet<String>> map, HashMap<String, Integer> distance, String startWord) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offerLast(startWord);
        int dis = 0;
        distance.put(startWord, 0);
        
        for (String one : wordList) {
            map.put(one, new HashSet<String>());
        }
        
        while (!queue.isEmpty()) {
            String curr = queue.pollFirst();
            int currDist = distance.get(curr);
            for (String one : expand(curr, wordList)) {
                if ((!distance.containsKey(one) || distance.get(one) == currDist + 1)) {
                    map.get(curr).add(one);
                    distance.put(one, currDist + 1);
                    queue.offerLast(one);
                }
            }
        }
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



