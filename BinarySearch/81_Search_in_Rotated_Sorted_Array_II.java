package top.wumrwds;


import org.junit.Assert;


/**
 * LeetCode 81 - Search in Rotated Sorted Array II
 *
 * @author wumrwds
 */
public class Solution {

    /**
     * Searches whether a specific number occurs in the rotated ordered array.
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] > nums[mid]) {
                // situation 1
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[start] < nums[mid]) {
                // situation 2
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 3 =>  [1,1,1,1,3,1,1] or [1,1,3,1,1,1,1,1]
                int p = mid;
                while (p <= end && nums[p] == nums[mid]) {
                    p++;
                }

                if (p > end) {
                    // if the right part is all of the same value as mid
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }

        if (nums[start] == target || nums[end] == target) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(true, solution.search(nums1, 0));
        Assert.assertEquals(true, solution.search(nums1, 4));
        Assert.assertEquals(true, solution.search(nums1, 2));
        Assert.assertEquals(false, solution.search(nums1, 3));

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        Assert.assertEquals(true, solution.search(nums2, 0));
        Assert.assertEquals(false, solution.search(nums2, 3));
        Assert.assertEquals(false, solution.search(nums2, 7));
        Assert.assertEquals(false, solution.search(nums2, 4));

        int[] nums3 = {1, 1, 1, 1, 3, 1, 1};
        Assert.assertEquals(true, solution.search(nums3, 1));
        Assert.assertEquals(true, solution.search(nums3, 3));
        Assert.assertEquals(false, solution.search(nums3, 8));

        int[] nums4 = {1};
        Assert.assertEquals(true, solution.search(nums4, 1));
        Assert.assertEquals(false, solution.search(nums4, -8));

        int[] nums5 = {1, 1, 1, 1, 1, 1, 1, 1};
        Assert.assertEquals(true, solution.search(nums5, 1));
        Assert.assertEquals(false, solution.search(nums5, -8));

        int[] nums6 = {1, 1, 3, 1, 1, 1, 1, 1};
        Assert.assertEquals(true, solution.search(nums6, 1));
        Assert.assertEquals(true, solution.search(nums6, 3));
        Assert.assertEquals(false, solution.search(nums6, -1));

        int[] nums7 = {};
        Assert.assertEquals(false, solution.search(nums7, 1));

        int[] nums8 = null;
        Assert.assertEquals(false, solution.search(nums8, 1));

        System.out.println("All test cases pass.");
    }
}