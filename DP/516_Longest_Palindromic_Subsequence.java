class Solution {
    /*
    
    dp[i][j] = dp[i+1][j-1] + 2                 s[i] == s[j]
             = max(dp[i+1][j], dp[i][j-1])      s[i] != s[j]
             = check(s[i...j])                  j - i < 3
             
    */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : 
                    Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : 
                    Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
        return dp[0][n-1];
    }

    public int longestPalindromeSubseq3(String s) {
        int n = s.length();
        int[] dp = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int tmp = dp[j];
                dp[j] = s.charAt(i) == s.charAt(j) ? pre + 2 : 
                    Math.max(dp[j-1], dp[j]);
                pre = tmp;
            }
        }
        
        return dp[n-1];
    }
}