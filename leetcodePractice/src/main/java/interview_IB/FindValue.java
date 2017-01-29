package interview_IB;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.Map;

public class FindValue {
    public static void main(String[] args) throws MalformedURLException, IOException {
//
//        System.out.println(Byte.MIN_VALUE);
//        System.out.println(Byte.MAX_VALUE);
//        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
//
//            if (b == 0x90) {
//
//                System.out.print("We found it");
//
//             }
//
//        }
        
        
//        Map<Integer, String> hashMap = new HashMap<Integer, String>(5);
//        hashMap.put(1, "apple");
//        hashMap.put(2, null);
//        hashMap.put(new Integer(3), "peach");
//        hashMap.put(3, "orange");
//        hashMap.put(4, "peach");
//
//        for (String v : hashMap.values()) {
//
//            if ("orange".equals(v)) {
//                hashMap.put(5, "banana");
//            }    
//        }
//        System.out.println(hashMap.get(5));
        
        
//        final List<Integer> list = new ArrayList<Integer>();
//
//        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);
//
//        final Integer pos = Integer.valueOf(3);
//
//        list.remove(pos);
//
//        System.out.println(list);

    
//        int a = 1;
//
//        int b = a++;
//
//        int c = ++b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        
//        int a = 1 << 2;
//        System.out.println(a);
        

        HttpURLConnection connection = (HttpURLConnection) new URL("http://www.google.com/nohelp").openConnection();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
            System.out.println("Page not found");
        }
    }
}
