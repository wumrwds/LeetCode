class Solution {
    /*
    
    dp[i] = min(min(dp[start...i-1]) + 1, dp[i]) = min(dp[start] + 1, dp[i])
          = INF
    
    since dp[] must be ascending, so dp[start] must be the smallest one among dp[start...i-1]
    */
    public int minTaps1(int n, int[] ranges) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+2);
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            int start = Math.max(i - ranges[i], 0), end = Math.min(i + ranges[i], n);
            
            for (int j = start; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        
        return dp[n] > n + 1 ? -1 : dp[n];
    }
    
    public int minTaps(int n, int[] ranges) {
        int[][] segments = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            segments[i][0] = i - ranges[i];
            segments[i][1] = i + ranges[i];
        }
        
        Arrays.sort(segments, (a, b) -> a[0] - b[0]);
        
//         for (int[] segment : segments) {
//             System.out.println(Arrays.toString(segment));
//         }
        
        // if start is equal to n, we should stop.
        int ans = 0;
        for (int i = 0, start = 0, end = 0; start < n && i <= n; start = end, ans++) {
            while (i <= n && segments[i][0] <= start) {
                end = Math.max(end, segments[i][1]);
                i++;
            }
            
            // System.out.println(start + ", " + end);
            
            // if the intervals are not overlapped, it's impossible to cover the garden.
            if (end <= start) {
                return -1;
            }
        }
        
        return ans;
    }
    
}