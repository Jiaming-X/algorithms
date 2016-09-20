package class15;

public class solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
       int [][] matrix = 
               { {0, 0, 0, 0},

                {1, 1, 1, 1},

                {0, 1, 1, 1},

                {1, 0, 1, 1} };
       largestCross solution = new largestCross();
       System.out.println(solution.largest(matrix));
       */
        
        int [][] matrix = 
            {  {1, -2, -1, 4},

               {1, -1,  1, 1},

               {0, -1, -1, 1},

               {0,  0,  1, 1}};
        largestSubMatrix solutino = new largestSubMatrix();
        solutino.largest(matrix);
        System.out.println(solutino.largest(matrix));
    }

}
