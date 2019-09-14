public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0, rigtht = nums.length - 1;
        
        while (left < rigtht) {
            if (nums[left] < k) {
                left++;
                continue;
            }
            
            if (nums[rigtht] >= k) {
                rigtht--;
                continue;
            }
            
            // swap elements
            int tmp = nums[left];
            nums[left] = nums[rigtht];
            nums[rigtht] = tmp;
            
            left++;
            rigtht--;
        }
        
        return (rigtht < 0 || nums[rigtht] < k) ? rigtht + 1 : rigtht;
    }
}