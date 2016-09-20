package Oct14;

import java.util.ArrayList;
import java.util.List;

public class textJustistification {

	public static void main(String[] args) {
		String[] array = new String[1];
		array[0] = "a";
		int maxNum = 1;

		List<String> aList = fullJustify(array, maxNum);
		for(String oneString : aList){
			System.out.println("|" + oneString + "|");
		}
	}

    public static List<String> fullJustify(String[] words, int maxWidth) {
        if(words.length == 0 || maxWidth == 0){
            ArrayList<String> output = new ArrayList<String>();
            
            output.add("");
            return output;
        }
        
        List<String> result = new ArrayList<String>();
        List<String> curr = new ArrayList<String>();
        int lineLength = 0; 
        
        for(String token : words){
            if(lineLength + token.length() <= maxWidth){
                lineLength = (lineLength == 0)?(lineLength + token.length()):(lineLength + 1 + token.length());
                curr.add(token);
            } else {
                result.add(format(curr, maxWidth, lineLength, false));
                curr = new ArrayList<String>();
                curr.add(token);
                lineLength = token.length();
            }
        }
        result.add(format(curr, maxWidth, lineLength, words.length > 1));
        curr = new ArrayList<String>();
        return result;
    }
    
    public static String format(List<String> curr, int maxWidth, int lineLength, boolean spaceAtTail){
        int extraLength = curr.size() <= 1 ? (maxWidth - lineLength) : (maxWidth - lineLength) / (curr.size() - 1);
        int pos = curr.size() <= 1 ? 1 : (maxWidth - lineLength) % (curr.size() - 1);
        String formatedString = "";
        
        for(int i = 0; i < curr.size(); i++){
            formatedString += (curr.get(i) + " ");
            
            for(int j = 0; j < extraLength + (j < pos ? 1: 0); j++){
                formatedString += " ";
            }
        }
        formatedString = formatedString.trim();
        if(curr.size() == 1 && spaceAtTail){
            for(int j = 0; j <= maxWidth - formatedString.length(); j++){
                formatedString += " ";
            }
        }
        return formatedString;
    }
	
	
	
}
