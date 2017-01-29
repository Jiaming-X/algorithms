package leetcode;

import java.util.*;

public class n18 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] input = {1,0,-1,0,-2,2};
        FourSum soln = new FourSum();
        
        List<List<Integer>> result = soln.fourSum(input, 0);
                
        for (List<Integer> one : result) {
            System.out.println(one);
        }
    }

}

class FourSum {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        HashMap<Integer, ArrayList<Element>> map = new HashMap<Integer, ArrayList<Element>>();
        ArrayList<Element> list = getAllCombination(nums, map);
        
        System.out.println(map.size());
        System.out.println(Arrays.toString(nums));
        
        for (int i = 0; i < list.size(); i++) {
            Element one = list.get(i);
            System.out.println(nums[one.i] + ", " + nums[one.j] + ", " + one.sum);
            
            if (map.containsKey(target - one.sum)) {
                for (Element two : map.get(target - one.sum)) {
                    if (one.j < two.i) {
                        Integer[] tmp = new Integer[]{nums[one.i], nums[one.j], nums[two.i], nums[two.j]};
                        result.add(Arrays.asList(tmp));
                    }
                }
            }
        }
        
        return result;
    }
    
    public ArrayList<Element> getAllCombination(int[] nums, HashMap<Integer, ArrayList<Element>> map) {
        ArrayList<Element> list = new ArrayList<Element>();
        for (int i = 0; i < nums.length; i++) {
//            if (i != 0 && nums[i - 1] == nums[i]) {
//                continue;
//            }
            for (int j = i + 1; j < nums.length; j++) {
//                if (j != i + 1 && nums[j - 1] == nums[j]) {
//                    continue;
//                }
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Element>());
                }
                Element ele = new Element(i, j, sum);
                map.get(sum).add(ele);
                list.add(ele);
            }
        }
        return list;
    }
    
    class Element {
        int i;
        int j;
        int sum;
        
        public Element (int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}