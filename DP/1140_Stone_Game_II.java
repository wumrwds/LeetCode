class Solution {
    
    private int[][] memo;
    private int[] prefixSum;
    
    /**
     * It's question of game theory. The more scores Alex gets, the less scores Lee gets, since the total scores is fixed.
     * 
     * Our task is to get the maximum scores Alex can get. So it's equivalent to get the maxium difference between Alex and Lee.
     * 
     * We can write a helper function which represents the maximum difference a player can get when we start at index i with the current M.
     * (So that means: if Alex call this function, it represents the maximum difference between Alex and Lee, and vice versa.)
     * 
     * We can use memoization to record the duplicate state results. We can draw a recursion tree to have a straightforward view.
     * 
     * See: https://youtu.be/e_FrC5xavwI
     */
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        memo = new int[n+1][(n+1)/2 + 1];
        
        prefixSum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i-1] + piles[i-1];
        }
        
        int maxDiff = helper(piles, 0, 1);
        
        return (prefixSum[n] + maxDiff) / 2;
    }
    
    private int helper(int[] piles, int i, int M) {
        if (i >= piles.length) {
            return 0;
        }
        
        if (memo[i][M] > 0) {
            return memo[i][M];
        }
        
        int maxDiff = Integer.MIN_VALUE;
        for (int X = 1; X <= 2*M; X++) {
            if (i+X > piles.length) {
                break;
            }
            
            int sum = prefixSum[i+X] - prefixSum[i];
            maxDiff = Math.max(maxDiff, sum - helper(piles, i+X, Math.max(M, X)));
        }
        
        memo[i][M] = maxDiff;
        
        return maxDiff;
    }
}