package Oct15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class powerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		Set<Set<Integer>> result = powerSet(set);
		for(Set<Integer> aSet : result){
			System.out.println(aSet);
			System.out.println();
			for(Integer num : aSet){
				System.out.println(num);
			}
		}
		
	}
	
	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet){
		Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
		if(originalSet.isEmpty()){
			sets.add(new HashSet<Integer>());
			return sets;
		}
		List<Integer> list = new ArrayList<Integer>(originalSet);
		int head = list.get(0);
		Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
		
		for(Set<Integer> set : powerSet(rest)){
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}
}
