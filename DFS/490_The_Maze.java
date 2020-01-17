class Solution {
    private static int[] DIRECTION_X = new int[] {1, 0, -1, 0};
    private static int[] DIRECTION_Y = new int[] {0, -1, 0, 1};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        
        boolean[][] isStopPoint = new boolean[m][n];
        isStopPoint[start[0]][start[1]] = true;
        for (int k = 0; k < 4; k++) {
            int x = start[0] + DIRECTION_X[k];
            int y = start[1] + DIRECTION_Y[k];
            
            if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                dfs(maze, isStopPoint, x, y, k);
            }
        }
        
        return isStopPoint[destination[0]][destination[1]];
    }
    
    private void dfs(int[][] maze, boolean[][] isStopPoint, int i, int j, int direction) {
        int m = maze.length, n = maze[0].length;
        int x = i + DIRECTION_X[direction], y = j + DIRECTION_Y[direction];
        
        if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
            dfs(maze, isStopPoint, x, y, direction);
        }
        else if (!isStopPoint[i][j]){
            isStopPoint[i][j] = true;
            
            for (int k = 0; k < 4; k++) {
                if (k != direction) {
                    x = i + DIRECTION_X[k];
                    y = j + DIRECTION_Y[k];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                        dfs(maze, isStopPoint, x, y, k);
                    }
                }
            }
        }
    }
}