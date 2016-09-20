package class11;

public class allUniqueChar {
    public boolean allUnique(String word) {
        // write your solution here
        if (word == null || word.length() < 2) {
          return true;
        } else if (word.length() > 128) {
          return false;
        }
        
        char[] inputs = word.toCharArray();
        boolean[] check = new boolean[128];
        
        for (Character aChar : inputs) {
          int pos = (int) aChar;
          
          if (check[pos]) {
            return false;
          } else {
              check[pos] = true;
          }
        }
        
        return true;
      }
}
