package class25;

import java.util.Comparator;
import java.util.PriorityQueue;

public class trapperWaterII {
    public int maxTrapped(int[][] matrix) {
        // Write your solution here.
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        
        PriorityQueue<Cell> queue = prepare(matrix, visited);
        
        /*
         *  {5,3,7,4,5},
            {6,2,5,2,3},
            {4,1,3,2,4},
            {9,6,8,2,3},
            {5,2,1,3,7}
         */
        
        while (!queue.isEmpty()) {
          Cell cell = queue.poll();
          
          for (int i = 0; i < 4; i++) {
            int nextX = cell.x + dx[i]; 
            int nextY = cell.y + dy[i];
            
            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n || visited[nextX][nextY]) {
              continue;
            }
            visited[nextX][nextY] = true;
            result += Math.max(0, cell.val - matrix[nextX][nextY]);
            int gain = Math.max(0, cell.val - matrix[nextX][nextY]);
            
            int height = Math.max(cell.val, matrix[nextX][nextY]);
            queue.offer(new Cell(nextX, nextY, height));
            System.out.println("x: " + cell.x + ", y:" + cell.y + ", val:" + cell.val);
            System.out.println("x: " + nextX + ", y:" + nextY + ", val:" + height + ", gain:" + gain);
            System.out.println();
          }
        }
        
        return result;
      }
      
      public PriorityQueue<Cell> prepare (int[][] matrix, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(m * n, new Comparator<Cell>() {
            @Override
            public int compare (Cell cell1, Cell cell2) {
              if (cell1.val == cell2.val) {
                return 0;
              }
              return cell1.val < cell2.val ? -1 : 1;
            }
          });
        
        for (int i = 0; i < m; i++) {
          queue.offer(new Cell(i, 0, matrix[i][0]));
          queue.offer(new Cell(i, n - 1, matrix[i][n - 1]));
          visited[i][0] = true;
          visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
          queue.offer(new Cell(0, i, matrix[0][i]));
          queue.offer(new Cell(m - 1, i, matrix[m - 1][i]));
          visited[0][i] = true;
          visited[m - 1][i] = true;
        }
        return queue;
      }
      
      static class Cell {
        int x;
        int y;
        int val;
        
        public Cell (int x, int y, int val) {
          this.x = x;
          this.y = y;
          this.val = val;
        }
      } 
}
