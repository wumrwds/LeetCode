class Solution {
    /*
    
    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]), 
             = triangle[0][0],           i = j = 0
    
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int m = triangle.size();
        int[] dp = new int[m];
        
        // initialize
        dp[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < m; i++) {
            // tmp array
            int[] dpTmp = new int[m];
            
            for (int j = 0; j <= i; j++) {
                dpTmp[j] = Math.min(
                    (j - 1 < 0 ? Integer.MAX_VALUE : dp[j-1]),
                    ( j > i - 1 ? Integer.MAX_VALUE : dp[j])
                ) + triangle.get(i).get(j);
            }
            
            dp = dpTmp;
        }
        
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (dp[i] < minPath) {
                minPath = dp[i];
            }
        }
        
        return minPath;
    }
}