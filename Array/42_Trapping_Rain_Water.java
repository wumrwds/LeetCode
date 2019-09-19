class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        // get left max array
        int[] leftMax = new int[height.length];
        int max = height[0];
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            leftMax[i] = max;
        }
        
        // get right max array
        int[] rightMax = new int[height.length];
        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            rightMax[i] = max;
        }
        
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            water += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        
        return water;
    }
}