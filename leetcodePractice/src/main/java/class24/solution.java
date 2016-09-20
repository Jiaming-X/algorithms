package class24;

import java.util.List;

public class solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        subsetII soln = new subsetII();
//        
//
//        for (String str : soln.subSets("abca")) {
//            System.out.println(str);
//        }
        
//        pairI soln = new pairI();
//        for (List<Integer> str : soln.allPairs(new int[]{1, 2, 3, 4, 5}, 6)) {
//            System.out.print(str.get(0));
//            System.out.print(", ");
//            System.out.print(str.get(1));
//            System.out.println();
//        }
        
//        validParenthesis soln = new validParenthesis();
//        for(String str : soln.validParentheses(1, 1, 0)){
//            System.out.println(str);
//        }
        fourSum soln = new fourSum();
        System.out.println(soln.exist(new int[]{3,1,6,3,16,40},15));
    }

}
