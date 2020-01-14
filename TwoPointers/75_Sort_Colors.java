class Solution {
    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1;
        for (int i = 0; i <= q; i++) {
            if (nums[i] == 0) {
                swap(nums, p, i);
                p++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, q);
                q--;
                if (nums[i] == 0 || nums[i] == 2) {
                    i--;
                }
            }
        }
    }
    
    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }
}