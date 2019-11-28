class Solution {
    /*
    Silding Window:
    
    the number of subarrays that ends at index `end` is just the window size.
    
    Therefore, the total number is just the sum of every valid window's size.
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, end = 0;
        int n = nums.length;
        int product = 1, cnt = 0;
        
        while (end < n) {
            product *= nums[end];
            end++;
            
            while (product >= k && start < end) {
                product /= nums[start];
                start++;
            }
            
            cnt += (end - start);
        }
        
        return cnt;
    }
}