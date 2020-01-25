class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int cur, end, reach;
        
        int ans = 0;
        for (cur = end = reach = 0; cur < n - 1; cur++) {
            reach = Math.max(reach, cur + nums[cur]);
            
            if (cur == end) {
                end = reach;
                ans++;
            }
        }
        
        return ans;
    }
}