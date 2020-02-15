class Solution {
    /*
    dp[i][j] => whether we can use the first i elements to sum up to j
    
    dp[i][j] = dp[i-1][j-num[i]] | dp[i-1][j]
             = true                             j = 0
    */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int n = nums.length;
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        
        // state transition
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 1; j--) {
                dp[j] = (j - nums[i] < 0 ? false : dp[j-nums[i]]) || dp[j];
                if (dp[sum]) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int n = nums.length;
        sum /= 2;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        // initialize
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // state transition
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = (j-nums[i-1] < 0 ? false : dp[i-1][j-nums[i-1]]) || dp[i-1][j];
                
                if (dp[i][sum]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}