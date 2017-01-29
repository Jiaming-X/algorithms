package interview_IB;

public class testException {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        classA soln = new classA();
        try {
            soln.fun();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


 class classA {


    void divide( int num, int den) throws Exception {

        if( den == 0) {
            throw new Exception("DivideByZeroException");
        }

        System.out.println( "" + (num / den) );


    }


    void fun() {
        try {
            divide( 4, 0);
        } catch (Exception e) { 
            System.out.println("works");
        }
    } 


 }

