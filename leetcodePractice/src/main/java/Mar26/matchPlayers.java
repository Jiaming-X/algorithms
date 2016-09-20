package Mar26;

import java.util.ArrayList;
import java.util.List;

public class matchPlayers {

    public static void main(String[] args) {
    	int n = 8;
    	List<String> curr = new ArrayList<String>();
    	
    	for (int i = 0; i < n; i++) {
    		curr.add(Integer.toString(i + 1));
    	}
    	helper(curr);
    	for (String num : curr) {
    		System.out.println(num);
    	}
    }
    
    public static void helper (List<String> list) {
    	if (list.size() == 1) {
    		System.out.println(list.get(0));
    		return;
    	}
    	
    	List<String> newList = new ArrayList<String>();
    	
    	for (int i = 0; i < list.size() / 2; i++) {
    		newList.add("(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")");
    	}
    	helper(newList);
    }
    /*
      // answers from the web
    public  static  String match(int n) { 
	    List<String> mathces = new ArrayList<String>();
	    for(int i=1; i<= n; i++){ 
	        mathces.add(Integer.toString(i)); 
	    }
	    String[] res= new String[1];
	    helpMatch(mathces, res);
	    System.out.println(res[0]);
	    return res[0];
    }
	
	public static void helpMatch(List<String> matches, String[] res){
	    if(matches.size() == 1) {
	        res[0] = matches.get(0);
	        return;
	    }
	
	    List<String> newMatches = new ArrayList<String>();
	    int len = matches.size();
	    for(int i=0; i< matches.size()/2; i++){
	        newMatches.add( "(" + matches.get(i) + "," +  matches.get(len-1-i) + ")");
	    }
	    helpMatch(newMatches, res);
	}
	*/
}