package class7_hashTableAndString;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class topKfreqMap {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here.
	if (k <= 0 || combo == null || combo.length == 0) {
		return new String[0];
	}
	
	HashMap<String, Integer> map = getFreqMap(combo);
	PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k, 
			new Comparator<Map.Entry<String, Integer>>(){
				@Override
				public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
					return m1.getValue().compareTo(m2.getValue());
				}
		
	});
	
	for (Map.Entry<String, Integer> entry : map.entrySet()) {
		if (minHeap.size() < k) {
			minHeap.offer(entry);
		} else if (minHeap.peek().getValue() < entry.getValue()) {
			minHeap.poll();
			minHeap.offer(entry);
		}
	}
	  
    return convertToArray(minHeap);
  }
  
  public String[] convertToArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
	  String[] result = new String[minHeap.size()];
	  
	  for (int i = minHeap.size() - 1; i >= 0; i--) {
		  result[i] = minHeap.poll().getKey();
	  }
	  
	  return result;
  }
  
  public HashMap<String, Integer> getFreqMap(String[] strings){
	  HashMap<String, Integer> map = new HashMap<String, Integer>();
	  
	  for (String one : strings) {
		  if (map.containsKey(one)) {
			  map.put(one, map.get(one) + 1);
		  } else {
			  map.put(one, 1);
		  }
	  }
	  
	  return map;
  }
}
