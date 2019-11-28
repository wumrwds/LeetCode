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


class Solution {
    /*
    
    nums[]      = 1 3 -1 | -3 5 3 | 6 7
    maxToLeft   = 1 3  3   -3 5 5   6 7
    maxToRight  = 3 3 -1    5 5 3   7 7 
    
    ans  = Math.max(toLeft[i+k-1], toRight[i])
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        
        int[] maxToLeft = new int[n], maxToRight = new int[n];
        
        int max = nums[0];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                max = nums[i];
            }
            else {
                max = Math.max(max, nums[i]);
            }
            maxToLeft[i] = max;
        }
        System.out.println(Arrays.toString(maxToLeft));
        
        max = nums[n-1];
        for (int i = n - 1; i >= 0; i--) {
            if ( (i+1) % k == 0) {
                max = nums[i];
            }
            else {
                max = Math.max(max, nums[i]);
            }
            maxToRight[i] = max;
        }
        System.out.println(Arrays.toString(maxToRight));
        
        int[] ans = new int[n-k+1];
        for (int i = 0; i + k - 1 < n; i++) {
            ans[i] = Math.max(maxToLeft[i+k-1], maxToRight[i]);
        }
        
        return ans;
    }
}