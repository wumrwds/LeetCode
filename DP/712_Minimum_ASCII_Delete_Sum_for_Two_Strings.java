class Solution {
    /*
    equivalent to maximum ASCII sum common String
    
    dp[i][j] => the maximum ASCII sum of common subsequence for s1.substring(0, i) and s2.substring(0, j)
    
    dp[i][j] = (s1[i] == s2[j]) ? dp[i-1][j-1] + ASCII(s1[i]) : max(dp[i-1][j], dp[i][j-1]);
             = 0,           i = 0 || j = 0
    */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        
        // state initialization
        
        // state transition
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        int sum = 0;
        for (char ch : s1.toCharArray()) {
            sum += ch;
        }
        for (char ch : s2.toCharArray()) {
            sum += ch;
        }
        
        return sum - 2 * dp[m][n];
    }
}