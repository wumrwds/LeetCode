class Solution {
    private static int[] DIRECTION_X = new int[]{1, 0, -1, 0};
    private static int[] DIRECTION_Y = new int[]{0, 1, 0, -1};
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Collections.emptyList();
        }
        
        int m = matrix.length, n = matrix[0].length;
        
        // get which grids that Pacific & Atlantic can reach
        boolean[][] pacificCanReach = new boolean[m][n], atlanticCanReach = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacificCanReach);
            dfs(matrix, i, n-1, atlanticCanReach);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacificCanReach);
            dfs(matrix, m-1, j, atlanticCanReach);
        }
        
        // collect results
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificCanReach[i][j] && atlanticCanReach[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int[][] matrix, int i, int j, boolean[][] oceanCanReach) {
        int m = matrix.length, n = matrix[0].length;
        
        oceanCanReach[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int x = i + DIRECTION_X[k], y = j + DIRECTION_Y[k];
            
            if (x >= 0 && x < m && y >= 0 && y < n 
                && !oceanCanReach[x][y] && matrix[x][y] >= matrix[i][j]) {
                dfs(matrix, x, y, oceanCanReach);
            }
        }
    }
}