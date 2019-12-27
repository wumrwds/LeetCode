class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        
        int start = 0, end = A.length - 1, maxSum = Integer.MIN_VALUE;
        while (start < end) {
            int sum = A[start] + A[end];
            
            if (sum < K) {
                maxSum = Math.max(maxSum, sum);
                start++;
            }
            else {
                end--;
            }
        }
        
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }
}