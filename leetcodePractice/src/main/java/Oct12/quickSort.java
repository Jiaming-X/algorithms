package Oct12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {6, 5, 4, 3, 2, 1, 0};
		
		System.out.println("Start quick sort");
		//makeQuickSort(x, 0, x.length - 1);
		
		System.out.println(Arrays.toString(x));
	}
	
	public static void makeQuickSort(int[] x, int low, int high){
		if(x == null || x.length == 0){
			return;
		}
		if(low >= high){
			return;
		}
		int middle = low + (high - low)/2;
		int pivot = x[middle];
		int i = low;
		int j = high;
		
		while(i <= j){
			while(x[i] < pivot){
				i++;
			}
			while(pivot < x[j]){
				j--;
			}
			
			
			if(i <= j){
				int tmp = x[i];
				x[i] = x[j];
				x[j] = tmp;
				i++;
				j--;
			}
		}
		if(low < j){
			makeQuickSort(x, low, j);
		}
		if(high > i){
			makeQuickSort(x, i, high);
		}
		return;
	}

}
