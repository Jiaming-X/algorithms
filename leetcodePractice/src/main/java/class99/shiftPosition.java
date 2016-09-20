package class99;

public class shiftPosition {
    public int shiftPosition(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        
        int i = 0, j = array.length - 1;
        
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (array[j] >= array[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        if (array[i] < array[j]) {
            return i;
        }
        return j;
    }
}
