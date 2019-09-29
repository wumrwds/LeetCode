class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        } 
        
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int[] max = new int[n-k+1];

        // move sliding window until its end meets the end of the array
        for (int i = 0; i < n; i++) {
            // remove the left most element
            if (!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.pollFirst();
            }

            // remove the elements which are less than the current incoming element
            // (because utill the current incoming element leaves the sliding window, these removed elements
            // will not be able to become the maximum; this part is decreasing, so pollLast())
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // add the current incoming element
            deque.offerLast(i);

            if (i >= k-1) {
                max[i-k+1] = Math.max(nums[deque.peekFirst()], nums[i]);
            }
        }

        return max;
    }
}