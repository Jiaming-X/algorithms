package class5_heapAndGraphSearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthNumInMatrix {

  public int kthSmallest(int[][] matrix, int k) {
	    // Write your solution here.
	if (k == 0) {
		return matrix[0][0];
	}
	int m = matrix.length;
	int n = matrix[0].length;
	boolean[][] visit = new boolean[m][n];
	
	PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator <Cell>(){
		@Override
		public int compare(Cell c1, Cell c2) {
			if (c1.value == c2.value) {
				return 0;
			}
			return c1.value < c2.value ? -1 : 1;
		}
	});
	
	minHeap.offer(new Cell(matrix[0][0], 0, 0));
	visit[0][0] = true;
	
	for (int i = 0; i < k - 1; i++) {
		Cell curr = minHeap.poll();
		
		if (curr.row + 1 < m && !visit[curr.row + 1][curr.col]) {
			minHeap.offer(new Cell(matrix[curr.row + 1][curr.col], curr.row + 1, curr.col));
			visit[curr.row + 1][curr.col] = true;
		}
		if (curr.col + 1 < n && !visit[curr.row][curr.col + 1]) {
			minHeap.offer(new Cell(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
			visit[curr.row][curr.col + 1] = true;
		}
	}
	  
    return minHeap.peek().value;
  }	

	class Cell {
		  int value;
		  int row;
		  int col;
		  
		  public Cell(int value, int row, int col) {
			  this.value = value;
			  this.row = row;
			  this.col = col;
		  }
	}
}