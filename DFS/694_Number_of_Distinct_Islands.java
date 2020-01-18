class Solution {
    
    private static int[] DIRECTION_X = new int[] {1, 0, -1, 0};
    private static int[] DIRECTION_Y = new int[] {0, 1, 0, -1};
    
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        boolean[][] isVisited = new boolean[m][n];
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    isVisited[i][j] = true;
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, isVisited, i, j, sb);
                    hashSet.add(sb.toString());
                }
            }
        }
        
        return hashSet.size();
    }
    
    private void dfs(int[][] grid, boolean[][] isVisited, int i, int j, StringBuilder sb) {
        int m = grid.length, n = grid[0].length;
        
        for (int k = 0; k < 4; k++) {
            int x = i + DIRECTION_X[k], y = j + DIRECTION_Y[k];
            
            if (x >= 0 && x < m && y >= 0 && y < n && !isVisited[x][y] && grid[x][y] == 1) {
                isVisited[x][y] = true;
                sb.append(k);
                dfs(grid, isVisited, x, y, sb);
            }
            
            sb.append("|");
        }
    }
}