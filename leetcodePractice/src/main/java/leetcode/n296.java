package leetcode;

import java.util.LinkedList;

public class n296 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        meetingRoom soln = new meetingRoom();
        int[][] grid = {{1, 1}};
        System.out.println(soln.minTotalDistance(grid));
    }

}

class meetingRoom {
    public void printM (int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println();
    }
    private class Cell {
        int x;
        int y;
        int cost;

        public Cell(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int minTotalDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][]  allCost = new int[m][n];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visit = new boolean[m][n];
                    int[][] oneCost = new int[m][n];
                    bfs(grid, oneCost, visit, i, j);
                    printM(oneCost);
                    addMatrix(allCost, oneCost, grid);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (allCost[i][j] > 0) {
                    result = Math.min(result, allCost[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void bfs (int[][] grid, int[][] one, boolean[][] visit, int x, int y) {
        int m = grid.length, n = grid[0].length;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        LinkedList<Cell> queue = new LinkedList<Cell>();
        queue.offer(new Cell(x, y, 0));
        visit[x][y] = true;
        
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    one[nx][ny] = curr.cost + 1;
                    queue.offer(new Cell(nx, ny, curr.cost + 1));
                }
            }
        }
    }

    public void addMatrix (int[][] one, int[][] two, int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                one[i][j] += two[i][j];
            }
        }
    }
}