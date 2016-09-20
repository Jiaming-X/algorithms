package class27;

import java.util.Arrays;
import java.util.Comparator;

public class largestSetPointPositiveSlope {
    public int largest(Point[] points) {
        // Write your solution here.
        if (points == null || points.length <= 1) {
            return 0;
        }
        
        MyComparator mycomparator = new MyComparator();
        Arrays.sort(points, mycomparator);
        int[] dp = new int[points.length];
        dp[0] = 1;
        int max = 1;
        
        for (int i = 1; i < points.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (points[j].x < points[i].x && points[j].y < points[i].y) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    static class MyComparator implements Comparator<Point> {
        @Override
        public int compare (Point A, Point B) {
            if (A.y < B.y) {
                return -1;
            } else if (A.y > B.y) {
                return 1;
            } else if (A.x < B.x) {
                return -1;
            } else if(A.x > B.x) {
                return 1;
            }
            return 0;
        }
    }
}

class Point {
   public int x;
   public int y;
   public Point(int x, int y) {
     this.x = x;
     this.y = y;
   }
}