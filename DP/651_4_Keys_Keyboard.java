class Solution {
    /*
    dp[i][j] => maximum number of 'A's for operating i actions and the number of 'A's in the buffer is j
    
    dp[i][j] = max(dp[i-1][j] + 1, dp[i-1][j] + j)             j <= dp[i-2]
             = 0                i = 0, j = 0
    */
    public int maxA(int N) {
        List<Map<Integer, Integer>> dp = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            dp.add(new HashMap<>());
        }
        dp.get(0).put(0, 0);
        
        // state transition
        for (int i = 1; i <= N; i++) {
            if (i >= 2) {
                for (Map.Entry<Integer, Integer> entry : dp.get(i-2).entrySet()) {
                    int buffer = entry.getKey(), maximum = entry.getValue();
                    
                    dp.get(i).put(maximum, maximum);
                }
            }
            
            for (Map.Entry<Integer, Integer> entry : dp.get(i-1).entrySet()) {
                int buffer = entry.getKey(), maximum = entry.getValue();
                
                dp.get(i).put(buffer, maximum + Math.max(1, buffer));
            }
        }
        
        int ans = 0;
        for (Integer c : dp.get(N).values()) {
            ans = Math.max(ans, c);
        }
        return ans;
    }
}

class Solution {
    private int[] memo;
    
    public int maxA(int N) {
        memo = new int[N+1];
        
        return helper(N);
    }
    
    /**
     * Returns the maximum number in step k
     */
    private int helper(int k) {
        if (k == 0 || memo[k] > 0) {
            return memo[k];
        }
        
        int max = k;
        
        for (int i = 0; i <= k - 3; i++) {
            max = Math.max(max, helper(i) * (k - i - 1));
        }
        
        memo[k] = max;
        
        return max;
    }
}