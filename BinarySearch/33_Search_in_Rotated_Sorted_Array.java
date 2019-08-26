package top.wumrwds;

import org.junit.Assert;

/**
 * LeetCode 33 - Search in Rotated Sorted Array
 * 
 * @author wumrwds
 */
public class Solution {

    /**
     * Searches a specific number in a rotated ordered array.
     *
     * @param nums
     * @param target
     * @return If found, return the index; otherwise, return -1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] > nums[mid]) {
                // situation 1 (you can draw a picture like y = 1/x to help)
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
            else {
                // situation 2
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
        }

        // check the last two elements (start might be equal to end)
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        // not found
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {4,5,6,7,0,1,2};
        Assert.assertEquals(4, solution.search(nums1, 0));
        Assert.assertEquals(0, solution.search(nums1, 4));
        Assert.assertEquals(6, solution.search(nums1, 2));
        Assert.assertEquals(-1, solution.search(nums1, 3));

        int[] nums2 = {6,7,0,1,2,3};
        Assert.assertEquals(4, solution.search(nums2, 2));
        Assert.assertEquals(5, solution.search(nums2, 3));
        Assert.assertEquals(1, solution.search(nums2, 7));
        Assert.assertEquals(-1, solution.search(nums2, 4));

        int[] nums3 = {6,7};
        Assert.assertEquals(0, solution.search(nums3, 6));
        Assert.assertEquals(1, solution.search(nums3, 7));
        Assert.assertEquals(-1, solution.search(nums3, 8));

        int[] nums4 = {1};
        Assert.assertEquals(0, solution.search(nums4, 1));
        Assert.assertEquals(-1, solution.search(nums4, -8));

        int[] nums5 = {};
        Assert.assertEquals(-1, solution.search(nums5, 1));

        int[] nums6 = null;
        Assert.assertEquals(-1, solution.search(nums6, 1));

        System.out.println("All test cases passed.");
    }
}