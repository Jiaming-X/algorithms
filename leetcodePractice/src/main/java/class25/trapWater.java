package class25;

public class trapWater {
    public int maxTrapped(int[] array) {
        // Write your solution here.
        if (array == null || array.length <= 2) {
          return 0;
        }
        
        int result = 0;
        int i = 0, j = array.length - 1;
        int left = array[0], right = array[array.length - 1];
        
        while (i < j) {
          if (left < right) {
            if (left > array[i + 1]) {
              result += (left - array[i + 1]);
            } else {
              left = array[i + 1];
            }
            i++;
          } else {
            if (right > array[j - 1]) {
                System.out.println(right - array[j - 1]);
              result += (right - array[j - 1]);
            } else {
              right = array[j - 1];
            }
            j--;
          }
        }
        
        return result;
      }
}
