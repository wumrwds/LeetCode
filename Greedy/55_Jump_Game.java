class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cur, end;
        
        for (cur = end = 0; cur <= end && cur < n; cur++) {
            int reach = cur + nums[cur];
            if (reach > end) {
                end = reach;
            }
        }
        
        return cur == n;
    }
}