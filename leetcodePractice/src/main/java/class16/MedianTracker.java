package class16;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class MedianTracker {

    public PriorityQueue<Integer> larger;
    public PriorityQueue<Integer> smaller;
    
    public MedianTracker() {
        // add new fields and complete the constructor if necessary.
        larger = new PriorityQueue<Integer>();
        smaller = new PriorityQueue<Integer>(11, Collections.reverseOrder());
    }
      
    public void read(int value) {
        // write your implementation here.
        if (smaller.isEmpty() || smaller.peek() >= value) {
            smaller.offer(value);
        } else {
            larger.offer(value);
        }
        
        if (smaller.size() - larger.size() >= 2) {
            larger.offer(smaller.poll());
        } else if (larger.size() > smaller.size()) {
            smaller.offer(larger.poll());
        }
    }
      
    public Double median() {
        // write your implementation here.
        int num = size();
        
        if (num == 0) {
            return null;
        } else if (num % 2 != 0) {
            return (double)smaller.peek();
        } else {
            return (smaller.peek() + larger.peek()) / 2.0;
        }
    }
    
    public int size() {
        return this.larger.size() + this.smaller.size();
    }
}
