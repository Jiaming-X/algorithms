package class8_stringII;

public class stringReorder {
    /*
     * 1, 2, 3, 4, 5, 6, 7, 8
     * 
     * 
     * 1, 2, 4, 3, 6, 5, 7, 8
     * 1, 2, 4, 3, 6, 5, 7, 8
     * 
     * 1, 2, 5, 6               3, 4, 7, 8
     * 
     * 
     * 1, 5, 2, 6               3, 7, 4, 8
     */
    
    public int[] reorder(int[] array) {
        // Write your solution here.
        if (array.length % 2 == 0) {
             reorder(array, 0, array.length - 1);
        } else {
             reorder(array, 0, array.length - 2);
        }
        return array;
    }
    
    public void reorder (int[] array, int left, int right) {
        int len = right - left + 1;
        if (len <= 2) {
            return;
        }
        int mid = left + (len) / 2;
        int lmid = left + (len) / 4;
        int rmid = left + (len) * 3 / 4;
                
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }
    
    public void reverse (int[] array, int left, int right) {
        while (left < right) { 
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
