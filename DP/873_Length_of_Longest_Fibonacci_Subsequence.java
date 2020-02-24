class Solution {
    /*
    dp[i][j] => maximum length of the sequence ends with i and j
    
    dp[i][j] = dp[k][i] + 1       k, i in [0, j-1] and num[k] + num[i] = num[j]
             = 2                  for every i < j
    */
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        
        // state initialize
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        
        // state transition
        int max = 0;
        for (int j = 2; j < n; j++) {
            int p = 0, q = j - 1;
            while (p < q) {
                int sum = A[p] + A[q];
                if (sum == A[j]) {
                    dp[q][j] = dp[p][q] + 1;
                    max = Math.max(max, dp[q][j]);
                    p++;
                    q--;
                }
                else if (sum < A[j]) {
                    p++;
                }
                else {
                    q--;
                }
            }
        }
        
        return max;
    }
}