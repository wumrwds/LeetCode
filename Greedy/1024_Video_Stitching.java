class Solution {
    public int videoStitching(int[][] clips, int T) {
        int n = clips.length;
        
        Arrays.sort(clips, (a, b) -> a[0] - b[0]);
        
        int cnt = 0;
        for (int i = 0, start = 0, end = 0; start < T; cnt++, start = end) {
            
            while (i < n && clips[i][0] <= start) {
                end = Math.max(end, clips[i][1]);
                i++;
            }
            
            if (start == end) {
                return -1;
            }
        }
        
        return cnt;
    }

    /*

    DP

    */
    public int videoStitchingDP(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, T + 1);
        dp[0] = 0;
        for (int i = 1; i <= T && dp[i - 1] < T; i++) {
            for (int[] c : clips) {
                if (c[0] <= i && i <= c[1])
                    dp[i] = Math.min(dp[i], dp[c[0]] + 1);
            }
        }
        return dp[T] == T + 1 ? -1 : dp[T];
    }
}