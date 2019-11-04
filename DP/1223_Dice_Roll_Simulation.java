class Solution {
    private static final int MOD_BASE = (int) 1e9 + 7;
    
    /*
    State definition: 
        dp[i][j]: the total number of different sequences of i rolls with the the last number being j.  
        
    Init: 
        dp[1][j] = 1, for j in [0, 5]. (1-indexed mapped to 0-indexed).  
        
    Answer: 
        sum of dp[n][j] for j in [0, 5].
    
    State transition analysis:
        dp[i][j] = sum(dp[i-1][k]) - sum(dp[i - rollMax -1][t]),   k can be all [0,5], t can be [0, 5] except j
        
    eg. rollMax for 1 is 2
    
     1   -1-   (1)
    {2}   2     2
    {3}   3     3
    {4}   4     4
    {5}   5     5
    {6}   6     6
    
    for dp[3][0], we don't allow 3 consecutive 1, so we must remove the amount of 3 consecutive 1 from dp[3][0]
    */
    public int dieSimulator(int n, int[] rollMax) {
        int[][] dp = new int[n][7];
        
        // initialize
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        
        dp[0][6] = 6;
        
        for (int i = 1; i < n; i++) {
            int sum = 0;
            
            for (int j = 0; j < 6; j++) {
                dp[i][j] = dp[i-1][6];
                
                // eg. rollMax = 1,  11 ->  it's not valid  but we dont have dp[i-rollMax[j]-1] row
                //     so we just simply minus 1
                if (i == rollMax[j]) {
                    dp[i][j] -= 1;
                }
                else if (i > rollMax[j]) {
                    int reduction = dp[i-rollMax[j]-1][6] - dp[i-rollMax[j]-1][j];
                    dp[i][j] = ((dp[i][j] - reduction) % MOD_BASE + MOD_BASE) % MOD_BASE;
                }
                
                sum = ((sum + dp[i][j]) % MOD_BASE + MOD_BASE) % MOD_BASE;
            }
            
            dp[i][6] = sum;
            System.out.println(Arrays.toString(dp[i]));
        }
        
        return dp[n-1][6];
    }
}