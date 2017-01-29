package interview_IB;

import java.lang.reflect.Field;

public class A {

    private final Character m_value = 'a';
    
    public String toString() { return "" + m_value; }

    public static void main(String[] args) {
        try {
            Field f = A.class.getDeclaredField("m_value");
            f.setAccessible(true);
            A a = new A();
            f.set(a, (char) 'b' );
            System.out.println(a);
        } catch (Exception e) {    
            e.printStackTrace();
        }
    }
}
