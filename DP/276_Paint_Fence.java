class Solution {
    /*
    same[i] = diff[i-1]
    diff[i] = k * sum(same[i-1], diff[i-1]) - same[i-1] - same[i] = (k-1) * sum
    */
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        
        int same = 0, diff = k;
        for (int i = 1; i < n; i++) {
            int sum = same + diff;
            same = diff;
            diff = (k-1) * sum;
        }
        
        return same + diff;
    }
}