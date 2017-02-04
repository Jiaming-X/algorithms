package Z_airbnb;

public class countDigitOne {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(countDigitOne(11));
    }
    public static int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        } else if (n < 10) {
            return 1;
        }
        
        int l = level(n);
        int head = n / l;
        System.out.println(l - 1);
        return head * countDigitOne(l - 1) + countDigitOne(n % l) + (head == 1 ? n % l + 1 : l);
    }
    
    public static int level (int num) {
        int result = 1;
        while (num / result >= 10) {
            result *= 10;
        }
        return result;
    }
}
