package class27;

public class solutIon {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        longestAscendingSequence soln = new longestAscendingSequence();
//        System.out.println(soln.longest(new int[]{5, 2, 6, 3, 4, 7, 5}));
        
        Point[] pts = new Point[4];
        pts[0] = new Point(0, 0);
        pts[1] = new Point(1, 1);
        pts[2] = new Point(2, 3);
        pts[3] = new Point(3, 3);
        
        largestSetPointPositiveSlope soln = new largestSetPointPositiveSlope();
        System.out.println(soln.largest(pts));
    }

}
