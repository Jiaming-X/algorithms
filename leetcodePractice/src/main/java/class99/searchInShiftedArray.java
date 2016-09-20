package class99;

public class searchInShiftedArray {
    public int search(int[] array, int target) {
        // Write your solution here
        int i = 0, j = array.length - 1;
        
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (array[i] <= array[mid]) {
                if (array[i] <= target && target <= array[mid]) {
                    j = mid;
                } else {
                    i = mid;
                }
            } else {
                if (array[mid] <= target && target <= array[j]) {
                    i = mid;
                } else {
                    j = mid;
                }
            }
        }
        
        if (array[i] == target) {
            return i;
        } else if (array[j] == target) {
            return j;
        } else {
            return -1;
        }
    }
}
