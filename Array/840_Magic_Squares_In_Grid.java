class Solution {
    /*
    
    1. the center must be 5
    2. the order must be 43816729 or 92761834
    3. the even must be in the corner, the odd must be on the edge (only check one point is enough)
    
    */
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int cnt = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 5 && isMagic(grid, i, j)) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private boolean isMagic(int[][] grid, int i, int j) {
        if (grid[i-1][j-1] % 2 != 0) {
            return false;
        }
        
        String seq = "" + grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i][j+1]
            + grid[i+1][j+1] + grid[i+1][j] + grid[i+1][j-1] + grid[i][j-1];
        
        return "4381672943816729".contains(seq) || "9276183492761834".contains(seq);
    }
}