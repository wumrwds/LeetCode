package top.wumrwds;


import java.util.*;

/**
 * 215. Kth Largest Element in an Array
 *
 * @author wumrwds
 */
public class Solution {
    private Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }

        return helper(nums, 0, nums.length - 1, k);
    }

    private int helper(int[] nums, int start, int end, int k) {
        int pivotIdx = partition(nums, start, end);

        if (pivotIdx - start + 1 == k) {
            return nums[pivotIdx];
        }
        else if (pivotIdx - start + 1 > k) {
            return helper(nums, start, pivotIdx-1, k);
        }
        else {
            return helper(nums, pivotIdx+1, end, k - pivotIdx + start - 1);
        }
    }

    private int partition(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }

        // randomly select an element as pivot
        int randomIdx = start + random.nextInt(end - start);
        swap(nums, randomIdx, end);

        int p = start - 1;
        for (int q = start; q < end; q++) {
            if (nums[q] >= nums[end]) {
                p++;
                swap(nums, q, p);
            }
        }

        // swap pivot
        swap(nums, p+1, end);

        return p+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

        int[] a = {3,2,1,5,6,4};
        int[] b = {1,1,1,1,1,1,2};
        int[] c = {1};
        int[] d = {};
        int[] e = {1,1,1,2,2,3,3,4,3,21,3,12,3,1,23,12,3,12,3,123,123124,34};

        System.out.println(new Solution().findKthLargest(a, 2));
        System.out.println(new Solution().findKthLargest(a, 3));
        System.out.println(new Solution().findKthLargest(a, 1));
        System.out.println(new Solution().findKthLargest(a, 6));
        System.out.println(new Solution().findKthLargest(b, 2));
        System.out.println(new Solution().findKthLargest(c, 1));
        System.out.println(new Solution().findKthLargest(d, 0));
        System.out.println(new Solution().findKthLargest(e, 0));
        System.out.println(new Solution().findKthLargest(e, 2));
        System.out.println(new Solution().findKthLargest(e, 4));
        System.out.println(new Solution().findKthLargest(e, 6));
    }
}