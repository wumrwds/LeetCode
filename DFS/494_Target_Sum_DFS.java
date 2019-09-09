class Solution {
    /*
     * Returns the number of solutions to assign symbols to make the sum of nums be target.
     */
    public int findTargetSumWays(int[] nums, int S) {
        int[] cnt = {0};
        dfsHelper(nums, 0, S, 0, cnt);
        
        return cnt[0];
    }
    
    private void dfsHelper(int[] nums, int idx, int target, int curSum, int[] cnt) {
        if (idx == nums.length) {
            if (curSum == target) {
                cnt[0]++;
            }
        }
        else {
            // case + 
            dfsHelper(nums, idx + 1, target, curSum + nums[idx], cnt);
            
            // case -
            dfsHelper(nums, idx + 1, target, curSum - nums[idx], cnt);
        }
    }
}