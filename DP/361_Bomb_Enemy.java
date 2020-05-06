class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        int rowCnt = 0, max = 0;
        int[] colCnt = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j] == 'W') {
                    rowCnt = 0;
                    
                    if (j == 0 && grid[i][0] == 'E') {
                        rowCnt++;
                    }
                    
                    for (int k = j+1; k < n && grid[i][k] != 'W'; k++) {
                        rowCnt += (grid[i][k] == 'E' ? 1 : 0);
                    }
                }
                
                if (i == 0 || grid[i][j] == 'W') {
                    colCnt[j] = 0;
                    
                    if (i == 0 && grid[0][j] == 'E') {
                        colCnt[j]++;
                    }
                    
                    for (int k = i+1; k < m && grid[k][j] != 'W'; k++) {
                        colCnt[j] += (grid[k][j] == 'E' ? 1 : 0);
                    }
                }
                
                if (grid[i][j] == '0') {
                    max = Math.max(max, rowCnt + colCnt[j]);
                }
            }
        }
        
        return max;
    }
}