class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        
        int first = binarySearchFirst(nums, target);
        int last = binarySearchLast(nums, target);
        
        int[] ans = new int[2];
        ans[0] = first;
        ans[1] = last;
        return ans;
    }
    
    private int binarySearchFirst(int[] nums, int target) {
        int start = 0, end = nums.length -1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
    
    private int binarySearchLast(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        return -1;
    }
}