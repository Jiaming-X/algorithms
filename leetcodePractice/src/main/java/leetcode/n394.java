package leetcode;

public class n394 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DecodeString soln = new DecodeString();
        String str = "3[a]2[bc]";
        System.out.println(soln.decodeString(str));
    }

}

class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[1];
        return helper(s.toCharArray(), pos);
    }
    
    public String helper(char[] array, int[] pos) {
        if (pos[0] >= array.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        
        while(pos[0] < array.length) {
            // char
            while (pos[0] < array.length && Character.isLetter(array[pos[0]])) {
                sb.append(array[pos[0]]);
                pos[0] += 1;
                System.out.println("0");
            }
            System.out.println(array[pos[0]] == '3');
            System.out.println(Character.isDigit(array[pos[0]]));
            
            // decode the encoded string
            if (pos[0] < array.length && Character.isDigit(array[pos[0]])) {
                int num = 0;
                System.out.println("if");
                while (pos[0] < array.length && Character.isDigit(array[pos[0]])) {
                    System.out.println("while");
                    num = num * 10 + (array[pos[0]] - '0');
                    pos[0] += 1;
                    System.out.println("2");
                }
                pos[0] += 1;

                System.out.println("3");
                String repeat = helper(array, pos);
                System.out.println("num" + num);
                System.out.println(repeat);
                for (int i = 0; i < num; i++) {
                    sb.append(repeat);
                    System.out.println("4");
                }
                if (array[pos[0]] == ']') {
                    pos[0]+= 1;
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }
}