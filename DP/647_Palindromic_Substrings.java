class Solution {
    /*
    dp[i][j] => whether the substring from i to j is a palindrome
    
    dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
             = true, i == j
    */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            cnt++;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = (i+1 > j-1 ? true : dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                
                if (dp[i][j]) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}