class Solution {
    public int movesToMakeZigzag(int[] nums) {
        System.out.println(toZigZag(nums, true) + ", " + toZigZag(nums, false));
        
        return Math.min(toZigZag(nums, true), toZigZag(nums, false));
        // return toZigZag(nums, false);
    }
    
    private int toZigZag(int[] nums, boolean startWithPeak) {
        int n = nums.length, cnt = 0;
        
        for (int i = startWithPeak ? 1 : 0; i < n; i += 2) {
            int min = Math.min(i-1 >= 0 ? nums[i-1] : Integer.MAX_VALUE, i+1 < n ? nums[i+1] : Integer.MAX_VALUE) - 1;
            
            // System.out.println(min);
            
            if (nums[i] > min) {
                cnt += nums[i] - min;
            }
        }
        
        return cnt;
    }





    /**
     * One pass.
     * 
     * @param A
     * @return
     */
    public int movesToMakeZigzag(int[] A) {
        int res[] = new int[2],  n = A.length, left, right;
        for (int i = 0; i < n; ++i) {
            left = i > 0 ? A[i - 1] : 1001;
            right = i + 1 < n ? A[i + 1] : 1001;
            res[i % 2] += Math.max(0, A[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}