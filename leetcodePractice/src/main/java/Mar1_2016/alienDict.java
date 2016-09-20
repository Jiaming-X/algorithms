package Mar1_2016;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class alienDict {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"wrt","wrf","er","ett","rftt"};//{"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"};
		System.out.println(alienOrder(words));
	}

    public static String alienOrder(String[] words) {
        if (words == null || words.length <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashSet<Character> set = new HashSet<Character>();
        String one = "";
        String two = words[0];
        
        for (int i = 1; i < words.length; i++) {
            one = two;
            two = words[i];
            int len = Math.min(one.length(), two.length());
            int pos = 0;
            
            if (one.substring(0, len).equals(two.substring(0, len))) {
                continue;
            }
            
            while (pos < len && one.charAt(pos) == two.charAt(pos)) {
                pos++;
            }
            char oneChar = one.charAt(pos);
            char twoChar = two.charAt(pos);
            map.put(oneChar, twoChar);
            if (set.contains(oneChar)) {
                set.remove(oneChar);
            } else {
                set.add(oneChar);
            }
            if (set.contains(twoChar)) {
                set.remove(twoChar);
            } else {
                set.add(twoChar);
            }
        }
        if (set.isEmpty()) {
            return words[0].substring(0, 1);
        }
        Iterator<Character> it = set.iterator();
        char curr = it.next();
        if (!map.containsKey(curr)) {
            curr = it.next();
        }
        System.out.println("Works");
        set = new HashSet<Character>();
        System.out.println(curr);
        while (map.containsKey(curr)) {
        	System.out.println(curr);
            sb.append(curr);
            if(!set.contains(curr)){
                set.add(curr);
            } else {
                return "";
            }
            curr = map.get(curr);
        }
        sb.append(curr);
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
