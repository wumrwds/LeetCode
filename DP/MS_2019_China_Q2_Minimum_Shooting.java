package top.wumrwds.microsoft;

import java.util.Arrays;

/**
 * 作者：hu2323233
 * 链接：https://www.nowcoder.com/discuss/173201
 * 来源：牛客网
 *
 * 2. 最少射击几次
 *
 * N个瓶子都有编号，每次能射击1个或多个瓶子，如果是回文的就能一次性击倒。最少几次能全击倒？
 *
 *
 * 测试
 *
 * 输入：[1, 2]
 *
 * 输出：2
 *
 *
 * 输入：[1,3,4,1,5]
 *
 * 输出：3
 *
 * 说明：第一次先射3，变成[1,3,1,5]，因为有[1,3,1]回文可以一次击倒，剩下[5]再一次
 *
 * 输入：[1,3,4,4,1]
 * 输入：[1,4,3,4,1]
 *
 */
public class Q2 {

    /**
     * state definition: dp[i][j] => the minimal cost of bursting all bottles from i to j
     *
     * state transition: dp[i][j] = min(dp[i+1][j-1], if nums[i] == nums[j], dp[i][k]+dp[k+1][j])
     *                            = 1,              i == j
     *
     */
    public int minimumShooting(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 1;
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;

                if (nums[i] == nums[j]) {
                    dp[i][j] = Math.min(dp[i][j], i + 1 <= j - 1 ? dp[i + 1][j - 1] : 1);
                }

                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Q2 solution = new Q2();
        System.out.println(solution.minimumShooting(new int[]{1, 2}));
        System.out.println(solution.minimumShooting(new int[]{1,3,4,1,5}));
        System.out.println(solution.minimumShooting(new int[]{1,3,4,4,1}));
        System.out.println(solution.minimumShooting(new int[]{1,4,3,4,1}));
        System.out.println(solution.minimumShooting(new int[]{1, 2, 3, 2, 9, 8, 9, 1}));
    }
}
