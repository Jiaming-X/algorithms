package class10_recursionII;

public class abreMatching {

// assume that both  strings are not null
  public boolean match(String input, String pattern) {
	return match(input, pattern, 0, 0);
  }
  
  // s			t
  // ^--si		^--ti
  
  public boolean match(String s, String t, int si, int ti){
	  // base
	  if (ti == t.length() && si == s.length()) {
		  return true;
	  } else if (ti >= t.length() || si >= s.length()) {
		  return false;
	  }
	  
	  // case 1
	  if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
		  if (t.charAt(ti) == s.charAt(si)) {
			  return match(s, t, si + 1, ti + 1);
		  }
		  return false;
	  }
	  
	  // case 2
	  int count = 0;
	  
	  while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
		  count = count * 10 + (int)(t.charAt(ti) - '0');
		  ti++;
	  }
	  return match(s, t, si + count, ti);
  }
}
