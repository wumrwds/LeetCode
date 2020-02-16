class Solution {
    /*
    dp[i][j] => the maximum length of the repeated subarray that ends at i for A, at j for B
    
    dp[i][j] = (A[i] == B[j]) ? dp[i-1][j-1] + 1 : 0
             = 0,            i = 0 || j = 0
    */
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        
        // initialize
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        
        // state transisition
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max;
    }
}