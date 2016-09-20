package class21;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here.
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(arrayOfArrays.length, new myComparator());
        int size = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            if (arrayOfArrays[i].length > 0) {
                minHeap.add(new Element(i, 0, arrayOfArrays[i][0]));
                size += arrayOfArrays[i].length;
            }
        }
        int[] result = new int[size];
        int i = 0;
        
        while (!minHeap.isEmpty()) {
            Element ele = minHeap.poll();
            result[i++] = ele.value;
            if (ele.y + 1 < arrayOfArrays[ele.x].length) {
                minHeap.add(new Element(ele.x, ele.y + 1, arrayOfArrays[ele.x][ele.y + 1]));
            }
        }
        
        return result;
    }
    

    static class myComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }
    }
    
    static class Element {
        public int x;
        public int y;
        public int value;
        
        public Element (int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}

