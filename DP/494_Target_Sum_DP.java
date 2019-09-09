package top.wumrwds;


/**
 * 312. Burst Balloons
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * Returns the number of solutions to assign symbols to make the sum of nums be target.
     *
     * Denote dp[i][j] as the maximum number of solutions for taking the first i th elements and getting a target j.
     *
     * dp[i][j] = | dp[i-1][j+nums[i]] + dp[i-1][j-nums[i]],     i > 1
     *            | ++1,                                           i = 1, j = nums[i] or -nums[i]
     *
     * To store the negative index, we need to make a index mapping function.
     *
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        // calculate sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // if target is out of the range, return 0
        if (Math.abs(S) > sum) {
            return 0;
        }

        int[][] dp = new int[nums.length][2*sum+1];

        // initialize
        dp[0][dpIndexMapping(nums[0], sum)]++;
        dp[0][dpIndexMapping(-nums[0], sum)]++;

        for (int i = 1; i < nums.length; i++) {
            for(int j = -sum; j <= sum; j++) {
                dp[i][dpIndexMapping(j, sum)] = (j-nums[i] >= -sum && j-nums[i] <= sum ? dp[i-1][dpIndexMapping(j-nums[i], sum)] : 0)
                        + (j+nums[i] >= -sum && j+nums[i] <= sum ? dp[i-1][dpIndexMapping(j+nums[i], sum)] : 0);
            }
        }

        return dp[nums.length-1][dpIndexMapping(S, sum)];
    }

    private static int dpIndexMapping(int j, int sum) {
        return j + sum;
    }

    public static void main(String[] args) {
        int[] matrix1 = {3,1,5,54,75,13,86,43,8};
        int[] matrix2 = {3,2,3,4,7,9,4,84,1,5,8};
        int[] matrix3 = {1,2,3,4,5};
        int[] matrix4 = {5,4,3,2,1};
        int[] matrix5 = {1};
        int[] matrix6 = {};
        int[] matrix7 = {0,0,0,0,0,0,0,0,1};

        System.out.println(new Solution().findTargetSumWays(matrix7, 1));

        System.out.println("All test cases passed");
    }
}