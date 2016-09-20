package class8_stringII;

public class decompression {
    public String decompress(String input) {
        // Write your solution here.
        if (input == null || input.length() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] inputs = input.toCharArray();
        char currChar = ' ';
        int freq = 0;
        
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] >= 'a' && inputs[i] <= 'z') {
                appendChar(sb, currChar, freq); // previous char.
                currChar = inputs[i];
                freq = 0;
            } else {
                freq = freq * 10 +  (inputs[i] - '0');
            }
        }
        appendChar(sb, currChar, freq);
        
        return sb.toString();
    }
    
    private void appendChar(StringBuilder sb, char aChar, int freq) {
        for (int i = 0; i < freq; i++) {
            sb.append(aChar);
        }
    }
}
