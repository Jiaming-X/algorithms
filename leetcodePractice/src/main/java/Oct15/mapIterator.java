package Oct15;

import java.util.*;

public class mapIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		for(Map.Entry<Integer, String> entry : map.entrySet()){
			System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
		}
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)it.next();
			System.out.println(entry.getValue() + entry.getKey());
		}
	}

}
