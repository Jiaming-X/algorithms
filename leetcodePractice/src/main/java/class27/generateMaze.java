package class27;

public class generateMaze {
    public int[][] maze(int n) {
        // Write your solution here.
        int[][] maze = new int[n][n];
        if (n <= 1) {
            return maze;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = 1;
            }
        }
        maze[0][0] = 0;
        generate(maze, 0, 0);
        return maze;
    }
    
    public void generate (int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        
        for (Dir oneDir : dirs) {
            int nextX = oneDir.moveX(x, 2);
            int nextY = oneDir.moveY(y, 2);
            
            if (isValidWall(maze, nextX, nextY)) {
                maze[nextX][nextY] = 0;
                maze[oneDir.moveX(x, 1)][oneDir.moveY(y, 1)] = 0;
                
                generate(maze, nextX, nextY);
            }
        }
    }
    
    private boolean isValidWall(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1;
    }
    
    public void shuffle (Dir[] dirs) {
        for (int i = 0; i < dirs.length; i++) {
            int rand = (int)(Math.random() * (dirs.length - i));
            Dir tmp = dirs[dirs.length - i - 1];
            dirs[dirs.length - i - 1] = dirs[rand];
            dirs[rand] = tmp;
        }
    }
    
    enum Dir {
        EAST(0, 1), WEST(0, -1), NORTH(1, 0), SOUTH(-1, 0);
        
        int deltaX;
        int deltaY;
        
        Dir (int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
        
        public int moveX(int x, int times){
            return x + times * deltaX;
        }
        
        public int moveY(int y, int times) {
            return y + times * deltaY;
        }
    }
}
