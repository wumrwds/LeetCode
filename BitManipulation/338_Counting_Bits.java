class Solution {
    /*
     * Take number X. Divide it in 2 parts:
     * <1> the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
     * <2> the other digits ( the number of 1, which is " dp[i >> 1] ", equivalent to " dp[i/2] " )
     *
     * For example,
     * 6 - 110  = dp[3] + 6 % 2
     * 7 - 111 = dp[3] + 7 % 2
     * 8 - 1000 = dp[4] + 8 % 2
     */
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        
        // initialize
        dp[0] = 0;
        
        // dp[i] = dp[i/2] + i % 2;
        for (int i = 1; i <= num; i++) {
            // *ATTETION:* The bit operation priority; dp[i>>1] + i & 1 - Wrong
            dp[i] = dp[i >> 1] + (i & 1);
        }
        
        return dp;
    }
}