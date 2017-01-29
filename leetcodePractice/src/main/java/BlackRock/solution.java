package BlackRock;

public class solution {
    /*
     *
     *2
5
8
3
     */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long num = 3;
        System.out.println( ((long)Math.sqrt( (long)Math.pow(10, 30))) ==  (long)Math.pow(10, 15));
        //System.out.println(((int)findStairNum(num)));
    }
    static long findStairNum (long num) {
        long sqrtNum = (long)Math.sqrt(num);
        
        if ((sqrtNum + 2) * (sqrtNum + 1) / 2 <= num) {
            return sqrtNum + 1;
        } else if ((sqrtNum + 1) * (sqrtNum) / 2 <= num) {
            return sqrtNum;
        } else {
            return sqrtNum - 1;
        }
    }
}
