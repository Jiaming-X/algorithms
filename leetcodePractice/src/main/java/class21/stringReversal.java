package class21;

public class stringReversal {
    public String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() <= 1) {
          return input;
        }
        char[] inputs = input.toCharArray();
        swap(inputs, 0, inputs.length - 1);

        int i = 0;
        int j = 0;
        
        for (; j < inputs.length; j++) {
          if (inputs[j] != ' ') {
            continue;
          }
          swap(inputs, i, j - 1);
          i = j + 1;
        }
        swap(inputs, i, j - 1);
        return new String(inputs);
      }
      
      public void swap (char[] array, int left, int right) {
          while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
          }
      }
}
