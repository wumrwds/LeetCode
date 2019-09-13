public class Solution {
    
    /**
     * prefix sum element struct.
     */
    private class Struct implements Comparable<Struct> {
        /** Prefix sum */
        private int sum;
        /** Original index */
        private int index;
        
        Struct(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
        
        @Override
        public int compareTo(Struct s) {
            return this.sum - s.sum;
        }
    }
    
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        
        // get prefix sum array
        Struct[] prefixSum = new Struct[nums.length+1];
        prefixSum[0] = new Struct(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = new Struct(prefixSum[i-1].sum + nums[i-1], i);
        }
        
        Arrays.sort(prefixSum);
        
        // subarraySum(i, j) = prefixSum[j+1] - prefixSum[i],     0 <= i,j <= n-1
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            // the closest sum to 0 must be the difference between two neighbors
            if (prefixSum[i].sum - prefixSum[i-1].sum < minDiff) {
                minDiff = prefixSum[i].sum - prefixSum[i-1].sum;
                result[0] = Math.min(prefixSum[i].index, prefixSum[i-1].index);
                result[1] = Math.max(prefixSum[i].index, prefixSum[i-1].index) - 1;
            }
        }
        
        return result;
    }
}