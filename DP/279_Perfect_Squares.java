class Solution {
    
    /*
    dp[i] = min(dp[k] + dp[i-k]),   k in [1, 4, 9, ..., floor(sqrt(n))^2]
          = 1,  i = 1, 4, 9, 16...     
    
    */
    
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int sqrt = (int) Math.floor(Math.sqrt(n));
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // initialize
        for (int i = 1; i <= sqrt; i++) {
            dp[i*i] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            if (dp[i] == 1) {
                continue;
            }
            
            for (int j = 1; j <= sqrt; j++) {
                if (j*j > i) {
                    continue;
                }
                
                dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        
        return dp[n];
    }
}