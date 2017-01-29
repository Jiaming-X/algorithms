package leetcode;

import java.util.Arrays;
import java.util.*;

public class n315 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CountSmallerAfterSelf soln = new CountSmallerAfterSelf();
        int[] input = {5, 2, 6, 1};
        List<Integer> result = soln.countSmaller(input);
        System.out.println(result);
    }

}

class CountSmallerAfterSelf {
    public int[] result;
    // The idea of merge sort
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return list;
        }

        int[] index = new int[nums.length];
        this.result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        mergeSort(nums, index, 0, nums.length - 1);

        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    public void mergeSort (int[] array, int[] index, int left, int right) {
        if (left >= right) {
            return;
        }  
        int mid = left + (right - left) / 2;
        mergeSort(array, index, left, mid);
        mergeSort(array, index, mid + 1, right);
        mergeTwoLists(array, index, mid, left, right);
    }

    public void mergeTwoLists (int[] array, int[] index, int mid, int left, int right) {
        if (left == right) {
            return;
        }
        int[] newIndex = new int[right - left + 1];
        int pos = 0;
        int arrayOne = left;
        int arrayTwo = mid + 1;

        int countRightSmaller = 0;
        while (arrayOne <= mid && arrayTwo <= right) {
            if (array[index[arrayOne]] > array[index[arrayTwo]]) {
                newIndex[pos] = index[arrayTwo];
                countRightSmaller++;
                arrayTwo++;
            } else {
                newIndex[pos] = index[arrayOne];
                this.result[index[arrayOne]] += countRightSmaller;
                arrayOne++;
            }
            pos++;
        }

        while (arrayOne <= mid) {
            newIndex[pos] = index[arrayOne];
            this.result[index[arrayOne]] += countRightSmaller;
            arrayOne++;
            pos++;
        }
        while (arrayTwo <= right) {
            newIndex[pos] = index[arrayTwo];
            arrayTwo++;
            pos++;
        }
        for (int i = left; i <= right; i++) {
            index[i] = newIndex[i - left];
        }
    }
}