package Mar26;

import java.util.Stack;

public class stackSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>(); 
		int[] nums = {1, 2, 3, -4, 10, 9, 8, 7, 6};
		for (Integer num : nums) {
			stack.push(num);
		}
		
		//sortStackIII(stack);
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	public static void sortStackII (Stack<Integer> stack) {
		
	}
	
	public static void sortStackIII (Stack<Integer> stack) {
		Stack<Integer> one = new Stack<Integer>();
		Stack<Integer> two = new Stack<Integer>();
		
		while (!stack.isEmpty()) {
			one.push(stack.pop());
		}
		
		while (!one.isEmpty()) {
			int minNum = one.pop();
			while (!one.isEmpty()) {
				int num = one.pop();
				if (minNum > num) {
					two.push(minNum);
					minNum = num;
				} else {
					two.push(num);
				}
			}
			stack.push(minNum);
			one = two;
			two = new Stack<Integer>();
		}
		//while (!one.isEmpty()) {
		//	stack.push(one.pop());
		//}
	}
}
