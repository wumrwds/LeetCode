class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n+1];
        int[] rightProduct = new int[n+2];

        leftProduct[0] = 1;
        for (int i = 1; i <= n; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }
        
        rightProduct[n+1] = 1;
        for (int i = n; i > 0; i--) {
            rightProduct[i] = rightProduct[i+1] * nums[i-1];
        }
        
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            ans[i-1] = leftProduct[i-1] * rightProduct[i+1];
        }
        return ans;
    }
}