package top.wumrwds;


import org.junit.Assert;

/**
 * 312. Burst Balloons
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * Returns the maximum coins earned by bursting the balloons.
     *
     * Denote dp[i, j] as the maximum gain for bursting the balloons from i to j.
     *
     * dp[i, j] = | d[i, k-1] + nums[i-1] * nums[k] * nums[j+1] + d[k+1, j],    i =< j, k ∈ [i, j]
     *            | 0,                                                          i > j
     *
     * Explanation: selecting k means after bursting [i, k-1] and [k+1, j], bursting the balloon k in the last. Because
     *              both left and right sides are already burst, the coins for balloon k are nums[i-1] * nums[k] * nums[j+1]
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int len = 0; len < n; len++) {
            // j = i + len
            for (int i = 0; i + len < n; i++) {
                for (int k = i; k <= i + len; k++) {
                    dp[i][i+len] = Math.max(dp[i][i+len], getDpEle(dp, i, k-1) + getNumsEle(nums, i-1) * nums[k] * getNumsEle(nums, i+len+1) + getDpEle(dp, k+1, i+len));
                }
            }
        }

        return dp[0][n-1];
    }

    private int getNumsEle(int[] nums, int idx) {
        if (idx >= 0 && idx < nums.length) {
            return nums[idx];
        }

        return 1;
    }

    private int getDpEle(int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[] matrix1 = {3,1,5,54,75,13,86,43,8};
        int[] matrix2 = {3,2,3,4,7,9,4,84,1,5,8};
        int[] matrix3 = {1,2,3,4,5};
        int[] matrix4 = {5,4,3,2,1};
        int[] matrix5 = {1};
        int[] matrix6 = {};

        Assert.assertEquals(652745, new Solution().maxCoins(matrix1));
        Assert.assertEquals(18512, new Solution().maxCoins(matrix2));
        Assert.assertEquals(110, new Solution().maxCoins(matrix3));
        Assert.assertEquals(110, new Solution().maxCoins(matrix4));
        Assert.assertEquals(1, new Solution().maxCoins(matrix5));
        Assert.assertEquals(0, new Solution().maxCoins(matrix6));

        System.out.println("All test cases passed");
    }
}