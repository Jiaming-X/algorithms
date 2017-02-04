package Z_airbnb;

import java.util.*;

public class text_justification {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String[] words = {
//                           "This    is    an",
//                           "example  of text",
//                           "justification.  "
//                        };
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = fullJustify(words, 16);
        for (String one : result) {
            System.out.println(one);
        }
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
        
        int index = 0;
        
        // [index, end)
        while (index < words.length) {
            int sum = words[index].length();
            int end = index + 1;
            while (end < words.length) {
                if (sum + 1 + words[end].length() > maxWidth) {
                    break;
                }
                sum +=(1 + words[end].length());
                end++;
            }
            
            StringBuilder sb = new StringBuilder();
            // not the last line, and last line
            if (end == words.length || end - index == 1) {
                sb.append(words[index]);
                for (int i = index + 1; i < end; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = 0; i < maxWidth - sum; i++) {
                    sb.append(" ");
                }
            } else {
                sb.append(words[index]);
                
                int extra = (maxWidth - sum) / (end - index - 1);
                int pos = (maxWidth - sum) % (end - index - 1);
                for (int i = index + 1; i < end; i++) {
                    for (int j = 0; j <= extra; j++) {
                        sb.append(" ");
                    }
                    if (i <= index + pos) {
                        sb.append(" ");
                    }
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            index = end;
        }
        return result;
    }
}
