package class99;

public class occurrence {
    public int totalOccurrence(int[] array, int target) {
        // Write your solution here
        int leftPos = findLeft(array, target);
        int rightPos = findRight(array, target);
        if (leftPos == - 1) {
            return 0;
        }
        return rightPos - leftPos + 1;
    }
    
    public int findLeft(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int i = 0, j = array.length - 1;
        
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (target <= array[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        if (array[i] == target) {
            return i;
        } else if (array[j] == target) {
            return j;
        }
        return -1;
    }
    
    public int findRight(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int i = 0, j = array.length - 1;
        
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (target < array[mid]) {
                j = mid;
            } else {
                i = mid;
            }
        }
        if (array[j] == target) {
            return j;
        } else if (array[i] == target) {
            return i;
        }
        return -1;
    }
}
