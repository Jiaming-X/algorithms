package jiuzhangContest;

import java.util.Map;

public class solution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.println(((double)1) / 6);
        diceSum soln = new diceSum();
        
        for (Map.Entry<Integer, Double> one : soln.dicesSum(5)) {
            System.out.print(one.getKey() + ", " + one.getValue());
            System.out.println();
        }
        
//        diceSum soln = new diceSum();
//        
//        System.out.println();
        
        
      }

}
