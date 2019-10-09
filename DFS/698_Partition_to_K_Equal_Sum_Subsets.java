class Solution {
    private boolean canPartition;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = sum(nums);
        if (sum % k != 0) {
            return false;
        }

        // calculate the sum of each subset
        int subsetSum = sum / k;

        // dfs
        canPartition = false;
        dfs(nums, k, subsetSum, 0, 0, new boolean[nums.length]);

        return canPartition;
    }

    private void dfs(int[] nums, int k, int targetSum, int idx, int curSum, boolean[] isVisited) {
        if (canPartition) {
            return;
        }

        if (k == 1) {
            canPartition = true;
            return;
        }

        if (curSum == targetSum) {
            dfs(nums, k-1, targetSum, 0, 0, isVisited);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (!isVisited[i]) {
                if (curSum + nums[i] <= targetSum) {
                    isVisited[i] = true;
                    dfs(nums, k, targetSum, i + 1, curSum + nums[i], isVisited);
                    isVisited[i] = false;
                }
            }
        }
    }


    private static int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}