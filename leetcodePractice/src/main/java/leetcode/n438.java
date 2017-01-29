package leetcode;

import java.util.*;

public class n438 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        allAnagram soln = new allAnagram();
        //System.out.println(soln.findAnagrams("cbaebabacd", "abc"));
        System.out.println(soln.findAnagrams("baa", "aa"));
    }
}

class allAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() < p.length()) {
            return result;
        }
        int pLen = p.length();
        int[] targetMap = new int[26];
        int matchNum = p.length();
        for (int i = 0; i < p.length(); i++) {
            targetMap[p.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(targetMap));
        for (int i = 0; i < s.length(); i++) {
            
            // add current char, and check if number is matched 
            targetMap[s.charAt(i) - 'a']--;
            if (targetMap[s.charAt(i) - 'a'] >= 0) {
                matchNum--;
            }
            
            // remove char outside the window.
            if (i >= pLen) {
                targetMap[s.charAt(i - pLen) - 'a']++;
                if (targetMap[s.charAt(i - pLen) - 'a'] > 0) {
                    matchNum++;
                }
            }
            
            System.out.println(Arrays.toString(targetMap));
            System.out.println(matchNum);
            if (i >= pLen - 1 && matchNum == 0) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}