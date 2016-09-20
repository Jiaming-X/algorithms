package class27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class mostPointsOnALine {
    public int most(Point[] points) {
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            int sameX = 1;
            int same = 1;
            int most = 0;
            Point one = points[i];
            
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            
            for (int j = i + 1; j < points.length; j++) {
                Point two = points[j];
                
                if (one.x == two.x && one.y == two.y) {
                    same++;
                } else if (one.x == two.x) {
                    sameX++;
                } else {
                    Double slope = (double)(one.y - two.y) / (double)(one.x - two.x);
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                    most = Math.max(most, map.get(slope));
                }
                most = Math.max(most, sameX) + same;
                max = Math.max(max, most);
            }
        }
        
        // Write your solution here.
        return max;
    }
    
    static class MyComparator implements Comparator<Point> {
        @Override
        public int compare(Point a, Point b){
            if (a.x < b.x) {
                return -1;
            } else if (a.x > b.x) {
                return 1;
            } else if (a.y < b.y) {
                return -1;
            } else if (a.y > b.y) {
                return 1;
            }
            return 0;
        }
    }
}
