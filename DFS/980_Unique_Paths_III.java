class Solution {
    
    private int m, n, empty, cnt;
    
    public int uniquePathsIII(int[][] grid) {
        empty = 1; 
        cnt = 0;
        m = grid.length;
        n = grid[0].length;
        
        int[] start = new int[2]; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }
                else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        
        grid[start[0]][start[1]] = 0;
        dfs(grid, start[0], start[1]);
        
        return cnt;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] >= 0) {
            
            // System.out.println(x + ", " + y + ", " + empty + ", " + grid[x][y]);
            
            if (empty == 0 && grid[x][y] == 2) {
                cnt++;
            }
            else if (grid[x][y] == 0) {
                empty--;
                grid[x][y] = -2;
                dfs(grid, x-1, y);
                dfs(grid, x, y-1);
                dfs(grid, x+1, y);
                dfs(grid, x, y+1);
                empty++;
                grid[x][y] = 0;
            }
        }
    }
}