class Solution {
    /*
    dp[i] => min(dp[j] + i/j),   j is the factor of i
    */
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {   // O(n^2)
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        return dp[n];
    }


    /*
    Find a maximum factor path from n to 1
    */
    public int minStepsGreedy(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }
}