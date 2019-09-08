public class Solution {
    /**
     * Time complexity: O(n*v) 
     * Space complexity: O(n*v)
     * 
     * Denote dp[i][j] as the max weight for the first i items with backpack of j size.
     * 
     * So for the i th item, it will have two cases:
     * - 1. dont put the i th item in
     * - 2. put the i th item in
     * 
     *                  not put         put i th in
     * dp[i][j] = | max(dp[i-1][j], dp[i-1][j-A[i]] + A[i]),     i > 0, j >= A[i]
     *            | dp[i-1][j],                                  i > 0, j < A[i]
     *            | 0,                                           i = 0
     * 
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack1(int m, int[] A) {
        int[][] dp = new int[A.length+1][m+1];
        
        // initialize 
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Math.max(dp[i-1][j], j-A[i-1] < 0 ? 0 : dp[i-1][j-A[i-1]] + A[i-1]);
            }
        }
        
        return dp[A.length][m];
    }

    /**
     * Time complexity: O(n*v) 
     * Space complexity: O(v)
     * 
     *  i th       i-1 th       i-1 th
     *  dp[v] = max(dp[v], dp[v-A[i]] + A[i])
     * 
     * For the i th loop, in order not to tame the result in the i-1 th loop (otherwise, the dp[v-A[i]] won't be correct), so we loop
     * from the higher end to the lower end.
     * 
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack2(int m, int[] A) {
        // initialize with 0
        int[] dp = new int[m+1];
        
        for (int i = 0; i < A.length; i++) {
            // must iterate from the high end to the low end
            for (int v = m; v >= A[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v-A[i]] + A[i]);
            }
        }
        
        return dp[m];
    }
}