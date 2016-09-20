package Mar26;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

//import java.util.PriorityQueue;

public class kthSmallestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,7,11};
		int[] B = {2,4,6};
		//(kthSmallestSum(A, B, 8));
		System.out.println(kthSmallestSum(A, B, 8));
	}
    public static int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return -1;
        }
        Comparator<Point> cp = new Comparator<Point>() {
            public int compare(Point left, Point right) {
                return left.val - right.val;
            } 
        };
        PriorityQueue<Point> queue = new PriorityQueue<Point>(2 * k, cp);
        int m = A.length, n = B.length;
        Point curr = new Point(0, 0, A[0] + B[0]);
        HashSet<String> set = new HashSet<String>();
        set.add(curr.x + "," + curr.y);          
        queue.offer(curr);
        
        for (int i = 0; i < k - 1; i++) {
            curr = queue.poll();
            System.out.println(curr.x + ", " + curr.y + ", " + curr.val);
            if (curr.x + 1 < m && !set.contains((curr.x + 1) + "," + curr.y)) {
            	set.add((curr.x + 1) + "," + curr.y);
                queue.offer(new Point(curr.x + 1, curr.y, A[curr.x + 1] + B[curr.y]));
            }
            if (curr.y + 1 < n && !set.contains((curr.x) + "," + (curr.y + 1))) {
            	set.add((curr.x) + "," + (curr.y + 1));
                queue.offer(new Point(curr.x, curr.y + 1, A[curr.x] + B[curr.y + 1]));
            }
        }
        
        return queue.poll().val;
    }
}
class Point {
    int x, y, val;
    
    public Point (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}