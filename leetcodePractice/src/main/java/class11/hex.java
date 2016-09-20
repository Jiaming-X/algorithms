package class11;

public class hex {
    public String hex(int number) {
        // Write your solution here.
        StringBuilder sb = new StringBuilder();
        
        while (number > 0) {
            int num = number % 16;
            
            if (num < 10) {
                sb.append((char)('0' + num));
            } else {
                sb.append((char)('A' + num - 10));
            }
           
            number >>>= 4;
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        sb.append("x0");
        return sb.reverse().toString();
    }
}
