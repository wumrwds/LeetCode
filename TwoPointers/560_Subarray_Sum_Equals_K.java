/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    
    public int subarraySum(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }
        
        // declare the length of nums
        int n = nums.length;
        
        // calculate prefix sum array
        int[] prefixSums = new int[n+1];
        prefixSums[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixSums[i] = prefixSums[i-1] + nums[i-1];
        }
        
        // declare the counter
        int cnt = 0;
        
        // iterate the prefix sum array to check whether it currently has a case whose sum is equal to k
        Map<Integer, Integer> cntHashMap = new HashMap<>();
        cntHashMap.put(0, 1);
        for (int j = 1; j <= n; j++) {
            // s[j] - s[i] = k  => s[i] = s[j] - k
            if (cntHashMap.containsKey(prefixSums[j] - k)) {
                cnt += cntHashMap.get(prefixSums[j] - k);
            }
            
            // add the current element into the map
            cntHashMap.put(prefixSums[j], cntHashMap.getOrDefault(prefixSums[j], 0) + 1);
        }
        
        // return the counter
        return cnt;
    }
}