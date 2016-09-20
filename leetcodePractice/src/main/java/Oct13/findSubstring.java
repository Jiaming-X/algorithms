package Oct13;


import java.util.*;
import java.io.IOException;

class findSubstring{
    
    public static List<String> solution(String str, String query){
        List<String> result = new ArrayList<String>();
        List<Character> curr = new ArrayList<Character>();
        if(str == null || query == null || str.length() < query.length() ){
            return result;
        }
        
        helper(str, query, 0, result, curr, 0);
        return result;
    }
    
    public static void helper(String str, String query, int pos, List<String> result, List<Character> curr, int found){
        if(pos > str.length()){
            return;
        }
        if(query.length() == found){
            StringBuilder sb = new StringBuilder();
            for(Character c : curr){
                sb.append(c);
            }
            result.add(sb.toString());
        }
        
        for(int i = pos; i < str.length(); i++){
            if(str.charAt(i) == query.charAt(found)){
                curr.add(str.charAt(i));
                found++;
                helper(str, query, i + 1, result, curr, found);
                found--;
                for(int j = curr.size() - 1; j >= found; j--){
                    curr.remove(j);
                }
            } else if(found > 0){
                curr.add(str.charAt(i));
            }
        }
    }
    
    public static void main(String[] args) {
        try{
            List<String> result = solution("dsfsdctaceat", "cat");
            if(result.isEmpty()){
                throw new IOException("Not Found");
            }
        
            String output = result.get(0);
            for(String oneString : result){
                if(oneString.length() < output.length()){
                    output = oneString;
                }
            }
            System.out.println(output);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}



